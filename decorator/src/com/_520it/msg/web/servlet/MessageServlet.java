package com._520it.msg.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.msg.dao.IMessageDAO;
import com._520it.msg.dao.impl.MessageDAOImpl;
import com._520it.msg.domain.Message;
import com._520it.msg.util.CommUtil;
import com._520it.msg.util.FilterUtil;

@WebServlet("/msg")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMessageDAO dao = new MessageDAOImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if (CommUtil.hasLength(cmd)) {
			if ("save".equals(cmd)) {
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				//--------------------------------------
				title  = FilterUtil.filter(title);
				content  = FilterUtil.filter(content);
				//--------------------------------------
				Message msg = new Message();
				msg.setSn(UUID.randomUUID().toString());
				msg.setTitle(title);
				msg.setContent(content);
				dao.add(msg);
			}
		}
		List<Message> list = dao.getAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}
}
