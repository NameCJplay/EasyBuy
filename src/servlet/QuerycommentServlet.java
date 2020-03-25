package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.easybuy_order_dao;
import entity.comment;
import entity.easybuy_order;

/**
 * Servlet implementation class QuerycommentServlet
 */
public class QuerycommentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CommentDao com = new CommentDao();
		//当前页面
		int pagenow = 0;		
		//每页条数
		int pagesize = 1;	
		//总数据数
		int count = com.count();
		//总页面数量
		int pageall = 0;
		//记录
		String page = "";
		
		if(count % pagesize==0){
			pageall = count/pagesize;
		}else{
			pageall = (count/pagesize)+1;
		}
		
		String pagestr = request.getParameter("pagenow");
		if(pagestr!=null){
			int pageint = new Integer(pagestr);
			if(pageint>=0 && pageint <pageall){
				pagenow = pageint;
			}	
		}
		
		
		page +="<li><a href='QuerycommentServlet?pagenow="+(pagenow-1)+"'>上一页</a></li>";
		for (int i = 0; i <= pageall-1; i++) {
			if(i==pagenow){
				page+="<li class='current'>"+(i+1)+"</li>";
			}else{
				page+="<li><a href='QuerycommentServlet?pagenow="+i+"'>"+(i+1)+"</a></li>";
			}
		}
		page +="<li><a href='QuerycommentServlet?pagenow="+(pagenow+1)+"'>下一页</a></li>";
		
		
		ArrayList<comment> comlist = com.limit(pagenow, pagesize);
		request.setAttribute("comlist",comlist);
		request.setAttribute("page", page);
		request.getRequestDispatcher("guestbook.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*ArrayList<comment> plist=new CommentDao().select();
		request.setAttribute("plist",plist);
		request.getRequestDispatcher("guestbook.jsp").
		forward(request, response);*/
	}

}
