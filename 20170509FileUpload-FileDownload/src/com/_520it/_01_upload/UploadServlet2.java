//需求：头像文件让用户由自己的电脑上传到网站服务器，在上一个文件的基础上，为避免文件名重复，使用随机生成方式重命名文件
package com._520it._01_upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import org.apache.commons.io.FilenameUtils;

//@WebServlet("/upload")
public class UploadServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在运行文件上传操作前，先检查该请求是否为上传文件的请求
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        System.out.println(isMultipart);
        if (!isMultipart) {
            // 如果不是上传文件的请求，结束本方法
            return;
        }
        try {
            // 建FileItemFactory的对象
            FileItemFactory factory = new DiskFileItemFactory();
            // 建文件上传对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求中的数据，返回list集合
            List<FileItem> items = upload.parseRequest(req);
            // 一个fileItem是一个表单元素
            for (FileItem fileItem : items) {
                if (fileItem.isFormField()) {
                    System.out.println(fileItem.getFieldName());
                    System.out.println(fileItem.getString("UTF-8"));
                    //否则打印出上传文件的相关信息
                }else{
                // 文件名称约束: 不同的用户上传的文件名称可能相同
                // 解决:UUID
                // （1）用UUID随机生成文件名
                String uuidname = UUID.randomUUID().toString();
                // （2）获得文件名的后缀名
                String extension = FilenameUtils.getExtension(fileItem.getName());
                // （3）把以上两者合并
                String filename = uuidname + "." + extension;
                // （4）把文件保存到磁盘,注意要把新文件名填入下面
                fileItem.write(new File("D:\\123",filename));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
/**
 * 小结：使用第三方库时，一定要下载源码包和说明书研究，并避开与java自带包的冲突
 */
}
