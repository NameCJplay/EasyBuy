package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;

import entity.comment;

/**
 * Servlet implementation class UpdatecommentServlet
 */
public class UpdatecommentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		CommentDao cmd = new CommentDao();
		
		String replyContent = request.getParameter("replyContent");
		int orderId = new Integer(request.getParameter("orderId"));
			comment com = new comment(orderId, null, null, replyContent, null, null);
			cmd.update(com);
			response.sendRedirect("QuerycommentServlet");
		}
		
		
	}


