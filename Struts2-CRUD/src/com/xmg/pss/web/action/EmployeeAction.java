package com.xmg.pss.web.action;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryObject;
import com.xmg.pss.service.IEmployeeService;
import com.xmg.pss.service.impl.EmployeeServiceImpl;
@Getter
@Setter
public class EmployeeAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;
	private IEmployeeService service = new EmployeeServiceImpl();
	
	private Employee e;
	private EmployeeQueryObject qo = new EmployeeQueryObject();

	private File headImg;
	private String headImgFileName;
	private String headImgContentType;

	@Override
	public String execute() throws Exception {
		PageResult result = service.pageQuery(qo);
		//将数据添加到值栈中
		ActionContext.getContext().put("result", result);
		return "list";
	}

	public String delete() throws Exception {
		if (e.getId() != null) {
			service.delete(e);
		}
		return SUCCESS;
	}

	public String input() throws Exception {
		if (e.getId() != null) {
			e = service.get(e.getId());
		}
		return INPUT;
	}

	public String saveOrUpdate() throws Exception {
		//执行文件的上传操作
		//将文件保存到磁盘中
		//获取/upload文件夹在磁盘中的绝对路径
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		FileUtils.copyFile(headImg, new File(realPath, headImgFileName));
		//将文件所在的路径设置给员工对象
		e.setHeadImg("/upload/" + headImgFileName);
		if (e.getId() != null) {
			service.update(e);
		} else {
			service.save(e);
		}
		return SUCCESS;
	}

	//在所有的业务方法执行之前执行该方法
	@Override
	public void prepare() throws Exception {

	}

	//在saveOrUpdate方法执行之前执行该方法
	public void prepareSaveOrUpdate() throws Exception {
		if (e.getId() != null) {
			e = service.get(e.getId());
		}
	}

	//在所有的业务方法执行之前执行该方法
	@Override
	public void validate() {

	}

	//在saveOrUpdate方法执行之前执行该方法
	/*public void validateSaveOrUpdate() {
		if (StringUtils.isEmpty(e.getUsername())
				|| e.getUsername().trim().length() < 6) {
			super.addFieldError("username", "亲,您的账号不能为空或者长度不能少于6位");
		}
	}*/
}
