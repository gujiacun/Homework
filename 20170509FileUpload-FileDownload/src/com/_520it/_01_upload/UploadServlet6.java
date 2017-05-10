//需求：头像文件让用户由自己的电脑上传到网站服务器，在上一个文件的基础上，约束用户上传的头像文件大小
// (1)文件类型约束:
// 解决:<1>通过文件名称的后缀来判断；<2>根据文件MIME类型来判断// (2)文件大小约束:
//建FileUploadUtils工具类，把设置缓存大小，随机生成文件名，上存到指定文件夹的功能放到那里，建upload(HttpServletRequest req)方法
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

@WebServlet("/upload")
public class UploadServlet6 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //只需调用工具类的方法，以后不同的servlet都能调用同一个工具类的方法
        //抓住异常并处理
        try {
            FileUploadUtils.upload(req);
        } catch (Exception e) {
           //要把异常信息送给用户看，用请求转发
            req.setAttribute("errorMsg", e.getMessage());
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        }

    }
    /**
     * 小结：使用第三方库时，一定要下载源码包和说明书研究，并避开与java自带包的冲突
     * 注意，由于这几个servlet是复制的，所以注解配置相同，要么修改配置，要么注释掉
     * 注意catch (LogicException e)要放在catch (Exception e)前面
     * 即范围小的要放在范围大的前面/特殊情况优先处理
     */
}
