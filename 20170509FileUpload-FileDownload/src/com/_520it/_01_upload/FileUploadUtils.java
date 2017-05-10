//需求：头像文件让用户由自己的电脑上传到网站服务器，在上一个文件的基础上，约束用户上传的头像文件类型和文件大小
// (1)文件类型约束:
// 解决:<1>通过文件名称的后缀来判断；<2>根据文件MIME类型来判断// (2)文件大小约束:
//建FileUploadUtils工具类，把设置缓存大小，随机生成文件名，上存到指定文件夹的功能放到那里，建upload(HttpServletRequest req)方法
package com._520it._01_upload;

import java.io.File;
import java.util.List;
import java.util.UUID;

//import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class FileUploadUtils {
    public static void upload(HttpServletRequest req) {
        // 在运行文件上传操作前，先检查该请求是否为上传文件的请求
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        System.out.println(isMultipart);
        if (!isMultipart) {
            // 如果不是上传文件的请求，结束本方法
            return;
        }
        try {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // 设置缓存大小
            factory.setSizeThreshold(1024 * 100);
            // factory.setRepository();

            // 建FileItemFactory的对象
            // FileItemFactory factory = new DiskFileItemFactory();
            // 建文件上传对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            //通过upload对象约束上传单个文件的大小
            upload.setFileSizeMax(20);
            //通过upload对象约束上传的所有文件的大小
            upload.setSizeMax(50);
            // 解析请求中的数据，返回list集合
            List<FileItem> items = upload.parseRequest(req);
            // 一个fileItem是一个表单元素
            for (FileItem fileItem : items) {
                if (fileItem.isFormField()) {
                } else {
                    // 文件类型约束，先拿文件的MIME类型
                    String contentType = fileItem.getContentType();
                    // if判断语句，如果MIME类型名字不以image/开头，在页面上显示错误信息给用户
                    if (!contentType.startsWith("image/")) {
                        // 由于是业务逻辑的异常，新建异常类继承RuntimeException
                        throw new LogicException("文件类型不正确，请重新上传头像");
                    }
                    // 假如类型不正确，在抛出异常时后面代码无法执行，只有类型正确才能继续后面

                    // 文件名称约束: 不同的用户上传的文件名称可能相同
                    // 解决:UUID
                    // （1）用UUID随机生成文件名
                    String uuidname = UUID.randomUUID().toString();
                    // （2）获得文件名的后缀名
                    String extension = FilenameUtils.getExtension(fileItem.getName());
                    // （3）把以上两者合并
                    String filename = uuidname + "." + extension;
                    // （4）指定文件上传到服务器的绝对路径
                    String realPath = req.getServletContext().getRealPath("/upload");

                    // （5）把文件保存到磁盘,注意要把新文件名和新路径填入下面
                    fileItem.write(new File(realPath, filename));
                    // 判断当前文件是否在内存中
                    System.out.println(fileItem.isInMemory());
                }
            }
        }
        //注意catch (LogicException e)要放在catch (Exception e)前面
        catch (LogicException e) {
            //抛给调用者
            throw e;
        }
        catch (FileSizeLimitExceededException e) {
            //抛给调用者
            throw new LogicException("上传头像文件过大，请重新上传",e);
        }
        catch (SizeLimitExceededException e) {
            //抛给调用者
            throw new LogicException("上传的所有头像文件过大，请重新上传",e);
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}