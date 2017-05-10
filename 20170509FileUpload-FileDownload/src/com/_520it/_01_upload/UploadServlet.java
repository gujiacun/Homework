//需求：建servlet文件，建login.jsp文件，写出登陆页面，其中头像文件让用户由自己的电脑上传到网站服务器
//（1）表单提交方式改为post，编码形式改为multipart/form-data，上传组件改为file
//（2）导入jar包，参考说明文件
//(3)在login.jsp的action中设置好文件上传到这里来，
package com._520it._01_upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在运行文件上传操作前，先检查该请求是否为上传文件的请求
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        System.out.println(isMultipart);
        if (!isMultipart) {
            //如果不是上传文件的请求，结束本方法
            return;
        }
        try {
            // 建FileItemFactory的对象
            FileItemFactory factory = new DiskFileItemFactory();
            // 建文件上传对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求中的数据，返回list集合
            List<FileItem> items = upload.parseRequest(req);
            //一个fileItem是一个表单元素
            for (FileItem fileItem : items) {
                //若是普通的表单元素，打印它的属性名字
                if (fileItem.isFormField()) {
                    System.out.println(fileItem.getFieldName());
                    System.out.println(fileItem.getString("UTF-8"));
                    //否则打印出上传文件的相关信息
                }else{
                    System.out.println(fileItem.getContentType());
                    System.out.println(fileItem.getName());
                    System.out.println(fileItem.getFieldName());
                    System.out.println(fileItem.getSize());
                    //把上传文件保存到服务器的磁盘
                    fileItem.write(new File("d:/",fileItem.getName()));
                    // (3)文件类型约束:
                    // 解决:<1>通过文件名称的后缀来判断
                    // <2>根据文件MIME类型来判断
                    
                    // (1)文件名称约束: 不同的用户上传的文件名称可能相同
                    // 解决:UUID
                    // (2)上传路径约束: 上传文件的路径不能写死，
                    //得到指定文件夹的绝对路径
                    // (4)文件大小约束:
                    //
                    //
                    // 缓存大小和临时目录:
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
