//需求：用一个servlet把所有学生信息列出来成表。在学生信息后面有超链接，点击删除该学生
package src.com._520it.pss.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com._520it.pss.dao.IMemberDAO;
import src.com._520it.pss.dao.impl.MemberDAOImpl;
import src.com._520it.pss.member.Member;
//为这servlet配置
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IMemberDAO dao = null;
    //当每次访问servlet时都创建dao对象，而不是在service中创建（每次请求都创建一次）
    @Override
    public void init() throws ServletException {
        dao = new MemberDAOImpl();
    }
    //重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求/响应格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //列举所有成员信息
        List<Member> members = dao.listAll();
        //把成员数据的集合设置到请求对象中
        req.setAttribute("members", members);
        //把请求转发到某个jsp页面上
        req.getRequestDispatcher("/jsp/list.jsp").forward(req, resp);
    }
/**
 * 小结：先写完整的DAO，再建servlet并配置部署好,在service方法中调用IMemberDAO中的listAll方法得到所有信息
 * 通过setAttribute方法把list集合送进请求对象，并用请求转发送到jsp文件，在jsp文件中输出
 */
}
