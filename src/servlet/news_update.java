package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.news_dao;
import entity.news;

/**
 * Servlet implementation class news_update
 */
public class news_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public news_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		news_dao nd = new news_dao();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int en_id = new Integer(request.getParameter("en_id"));
		news ns = new news();
		ns.show(en_id, title, content, null);
		if(nd.upodate(ns)>0){
			response.sendRedirect("news_result");
		}
		
		
		
	}

}
