package com.xmg.pss.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
//用框架写前端页面，先实现CRUD
//（1）在web.xml中建filter过滤器，记住写StrutsPrepareAndExecuteFilter的全限定名
//（2）拷贝struts.xml到resources中，删剩根元素和开发者选项
//（3）建web包，建action包和filter包，在action包里建action类（继承ActionSupport），建实体类和dao两个的对象重写execute方法，
//在这方法里用list方法，把数据加到值栈中,返回list，在struts.xml中配置相应的result
import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryOnject;
import com.xmg.pss.service.IEmployeeService;
import com.xmg.pss.service.impl.EmployeeServiceImpl;
import com.xmg.pss.util.MD5;

import lombok.Getter;
import lombok.Setter;
//加密操作，让DBA也看不到用户的登陆密码。做法：把用户密码取出，进行加密操作，再把生成的MD5新密文送进数据库
//（1）把MD5.java放到util里面
//（2）在saveOrUpdate()里，在else里，取出用户输入的密码，用MD5.java里的encode方法加密生成密文，再加入随机字符串
//（3）吧上一步结果设置给实体类对象，送进数据库（执行save方法）

//登陆的用户名长度校验
//建validateSaveOrUpdate()里，判断用户名是否为空/长度是否超过6，是就输出错误信息
//在edit.jsp里输出错误信息,<s:property value="fieldErrors.username[0]"/>

//由于在现在在list.jsp上点击编辑按钮，跳转到edit.jsp上，修改某个信息并提交返回后，会出现密码丢失问题，解决方案：
//因为是在执行update方法，把用户输入的新信息保存到数据库（造成密码丢失），而在这个action中是saveOrUpdate方法执行这步操作，所以要在这步之前解决问题
//（1）action实现Preparable接口，重写prepare方法，由于要在saveOrUpdate方法前执行，写成prepareSaveOrUpdate方法；
//（2）在上一步的方法内，拿id，根据id拿数据库中的对象（数据库中的对象包含密码）
//（3）把server.xml中的默认拦截器改为paramsPrepareParamsStack(要在package里改)
//执行顺序：用户点击编辑按钮来到编辑页面，此时执行prepareSaveOrUpdate()方法，从数据库中根据用户传入的id拿出id对应的对象，
//执行saveOrUpdate()方法，用户更新数据，我们获取更新的数据，设置给对象；最后把封装好数据的对象放进数据库
@Setter
@Getter
public class EmployeeAction extends ActionSupport implements Preparable{

    private static final long serialVersionUID = 1L;
    Employee e = new Employee();
    IEmployeeService service = new EmployeeServiceImpl();
    //IEmployeeDAO dao = new EmployeeDAOImpl();

    // 给高级查询+分页查询用
    EmployeeQueryOnject qo = new EmployeeQueryOnject();

    //被上传的文件对象
    private File headImg;
    //被上传的文件原始名字
    private String headImgFileName;
    //被上传的文件类型
    private String headImgContentType;
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        // List<Employee> list = dao.list();
        // ActionContext.getContext().put("list", list);
        PageResult result = service.pageQuery(qo);
        ActionContext.getContext().put("result", result);
        return "list";
    }
    @SkipValidation
    // 删除方法
    public String delete() throws Exception {
        if (e.getId() != null) {
            service.delete(e);
        }
        return SUCCESS;
    }
    @SkipValidation
    public String input() throws Exception {
        if (e.getId() != null) {
            e = service.get(e.getId());
        }
        return INPUT;
    }

    // 编辑/保存方法
    
    public String saveOrUpdate() throws Exception {
        //文件上传（1）在页面中改表单enctype="mulitpart/form-data"，s:file name="headImg"
        //（2）在action中提供headImg（File类型），上传的文件原始名字,上传的文件类型,提供set/get方法
        //（3）在WebContent里新建upload文件夹，通过ServletActionContext拿到该文件夹真实路径
        String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
        //System.out.println(realPath);
        //（4）将文件保存到磁盘
        FileUtils.copyFile(headImg, new File(realPath, headImgFileName));
        //（5）把文件所在路径设置给员工对象
        e.setHeadImg("/upload/"+headImgFileName);
        //(6)在WEB-INF文件夹内建classes文件夹，把文件的class文件改到里面，把Webcontent的真实地址放到tomcat的server.xml里面
        //(7)在list.jsp页面，用img标签，src里面塞一个s:property标签，value为#em.headImg，即头像文件的路径
        //(8)设置默认头像，在upload文件夹内加默认头像文件，在上一步里面加上default=默认头像文件的路径
        if (e.getId() != null) {
            service.update(e);
        } else {
            //加密操作,取出用户输入的密码
            String password = e.getPassword();
            //用MD5.java里的encode方法加密生成密文，再加入随机字符串
            e.setPassword(MD5.encode(password)+"随机字符串");
            //System.out.println();
            //吧上一步结果设置给实体类对象，送进数据库（执行save方法）
            service.save(e);
        }
        return SUCCESS;
    }
    @Override
    public void validate() {
        // 执行校验操作
        super.validate();
    }
    @Override
    public void prepare() throws Exception {
        // TODO Auto-generated method stub
    }
    
    //拿id，根据id拿数据库中的对象,先执行这方法，再执行SaveOrUpdate
    public void prepareSaveOrUpdate() throws Exception {
        if (e.getId() != null) {
            //此时的e被更新为数据库中的对象，而数据库中的对象与页面上的不一样，是包含密码信息的
            e = service.get(e.getId());
        }
    }
//    public void validateSaveOrUpdate(){
//        if (e.getUsername() == null || e.getUsername().trim().length()>6) {
//            super.addFieldError("username", "用户名不能为空或大于6位");
//        }
//    }
/**
 * 小结：服务器中的图片文件只存它的保存路径
 */
}
