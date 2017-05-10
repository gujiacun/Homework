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
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("delete".equals(cmd)) {
            delete(req, resp);
        } else if ("edit".equals(cmd)) {
            edit(req, resp);
        } else if ("saveOrUpdate".equals(cmd)) {
            saveOrUpdate(req, resp);
        } else {
            listAll(req, resp);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        if (StringUtils.hasLength(id)) {
            dao.delete(Long.valueOf(id));
        }
        resp.sendRedirect(req.getContextPath()+"/student");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        if (StringUtils.hasLength(id)) {
            Student stu = dao.get(Long.valueOf(id));
            req.setAttribute("stu", stu);
        }
        req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);
    }

    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        Student stu = new Student();
        stu.setName(name);
        stu.setAge(Integer.valueOf(age));
        if (StringUtils.hasLength(id)) {
            stu.setId(Long.valueOf(id));
            dao.update(stu);
        }
        dao.save(stu);
        resp.sendRedirect(req.getContextPath()+"/student");
    }

    protected void listAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Student> list = dao.listAll();
        for (Student student : list) {
            System.out.println(student);
        }
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
    }
}
