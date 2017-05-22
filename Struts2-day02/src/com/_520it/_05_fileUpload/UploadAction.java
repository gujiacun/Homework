package com._520it._05_fileUpload;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import lombok.Getter;
import lombok.Setter;

//实现上传文件操作
//（1）把jsp页面中的表单的enctype改为multipart/form-data，在表单中<s:file name="headImg"></s:file>
//（2）建本类action
//（3）在struts.xml中配置本action
public class UploadAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    //由于在页面中有username提交过来，所以建字段并提供set方法
    @Setter
    private String username;
    
  //由于在页面中有文件上传过来，所以建字段并提供set方法
    @Setter@Getter
    private File headImg;
    //上传文件名称
    @Setter
    private String headImgFileName;
    @Setter
    private String headImgContentType  ;
    
    @Override
    public String execute() throws Exception {
        // 测试
        System.out.println("文件上传");
        
        //现在要把文件放到upload文件夹内，先拿他的路径
        String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
        //在这个路径上建新的文件对象
        File destFile  =new File(realPath, headImgFileName);
        //把用户上传到服务器的文件保存到服务器的某个地方
        FileUtils.copyFile(headImg, destFile);
        
        //不用跳转
        return NONE;
    }
/**
 * 小结：FileUtils是import org.apache.commons.io.FileUtils;
 * 上传文件名称是一个属性，可以直接在action中拿，必须先定义好，在提供set方法，名字是XXXFileName
 */
}
