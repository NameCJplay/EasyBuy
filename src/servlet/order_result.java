package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.easybuy_order_dao;
import entity.easybuy_order;

/**
 * Servlet implementation class order_result
 */
public class order_result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order_result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		request.setCharacterEncoding("UTF-8");
		easybuy_order_dao eod = new easybuy_order_dao();
		//当前页面
		int pagenow = 0;		
		//每页条数
		int pagesize = 3;	
		//总数据数
		int count = eod.selectcount();
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
			int pageint = new Integer(request.getParameter("pagenow"));
			if(pageint>=0 && pageint <pageall){
				pagenow = pageint;
			}	
		}
		
		
		page +="<li><a href='order_result?pagenow="+(pagenow-1)+"'>上一页</a></li>";
		for (int i = 0; i <= pageall-1; i++) {
			if(i==pagenow){
				page+="<li class='current'>"+(i+1)+"</li>";
			}else{
				page+="<li><a href='order_result?pagenow="+i+"'>"+(i+1)+"</a></li>";
			}
		}
		page +="<li><a href='order_result?pagenow="+(pagenow+1)+"'>下一页</a></li>";
		
		
		ArrayList<easybuy_order> orderlist =  eod.selectall(pagenow, pagesize);
		request.setAttribute("orderlist", orderlist);
		request.setAttribute("page", page);
		request.getRequestDispatcher("order.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
