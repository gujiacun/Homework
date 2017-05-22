package com._520it.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.dao.IStudentDAO;
import com._520it.dao.impl.StudentDAOImpl;
import com._520it.domain.Student;
import com._520it.util.StringUtils;

//由于以后可能还有很多web组件，加上student区分
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IStudentDAO dao = null;

    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 由list.jsp传入命令，service方法根据不同命令参数调用下方不同参数
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("delete".equals(cmd)) {
            delete(req, resp);
        } else if ("edit".equals(cmd)) {
            edit(req, resp);
        }else if("saveOrUpdate".equals(cmd)){
            saveOrUpdate(req, resp);
        }
        else {
            list(req, resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有学生的所有信息
        List<Student> list = dao.listAll();
        // 由于list.jsp在WEB-INF文件夹下，共享数据到request，请求转发
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
    }

    // 调用dao中的删除方法，首先要获取被删除的对象的id
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在list.jsp页面中，删除按钮的超链接带有id，通过请求对象获取id
        String id = req.getParameter("id");
        // 通过对象调用delete方法
        if (StringUtils.hasLength(id)) {
            dao.delete(Long.valueOf(id));
        }
        // 删除数据后，跳转到servlet页面，再次查询剩下的所有信息
        resp.sendRedirect(req.getContextPath() + "/student");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在list.jsp页面中，编辑按钮的超链接带有id，通过请求对象获取id
        String id = req.getParameter("id");
        // 判断id是否有值，如果有的话将id对应的student取出添加到请求对象中
        if (StringUtils.hasLength(id)) {
            Student stu = dao.get(Long.valueOf(id));
            //dao.update(stu);
            // 由于list.jsp在WEB-INF文件夹下，共享数据到request，请求转发
            req.setAttribute("stu", stu);
        }
        // 编辑数据后，跳转到servlet页面，再次查询所有信息
        req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);
    }

    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String age = req.getParameter("age");
        Student stu = new Student();
        stu.setName(name);
        if (StringUtils.hasLength(age)) {
            stu.setAge(Integer.valueOf(age));
        }
        if (StringUtils.hasLength(id)) {
            stu.setId(Long.valueOf(age));
            dao.update(stu);
        }else {
            dao.save(stu);
        }
        resp.sendRedirect(req.getContextPath()+"/student");
    }
/**
 * 小结：当程序体系比较复杂时，一定要搞清每次点击的完整跳转路径，依次安排程序
 */
}
