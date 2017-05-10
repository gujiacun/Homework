//需求：通过此访问在WEB-INF下的图片文件，实现在网页上的下载
//（1）由于在WEB-INF文件夹下，只能用请求转发访问,建好servlet的准备
//（2）在jsp页面中的超链接有3个，在那里设置属性name并传入这里
//（3）通过getParameter拿用户下载的文件名称
//（4）去指定目录中找对应文件，即拿某文件在WEB-INF文件夹的绝对路径
//（5）新建File对象，传入上面得到的文件名称和路径
//（6）为解决下载文件时，文件名称由于是中文而乱码/文件格式为DOWNLOAD两个问题，设置响应报头
//（7）在上一步中，由于不同浏览器设置响应报头格式不同，所以要用if条件分开处理（判断条件为得到响应头的User-Agent是否包含MSIE）
//（8）把找到的文件响应给浏览器
package com._520it._02_download;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String filename = req.getParameter("filename");
        System.out.println(filename);
        String realPath = req.getServletContext().getRealPath("/WEB-INF/download");
        File file = new File(realPath, filename);
        String header = req.getHeader("User-Agent");
        if (header.contains("MSIE")) {
            resp.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(filename, "utf-8"));
        } else {
            resp.setHeader("Content-Disposition","attachment;filename="+new String(filename.getBytes("UTF-8"),"ISO8859-1"));
        }
        Files.copy(Paths.get(file.getAbsolutePath()), resp.getOutputStream());
    }
}
