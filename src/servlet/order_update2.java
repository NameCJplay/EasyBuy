package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.easybuy_order_dao;

import entity.easybuy_order;

/**
 * Servlet implementation class order_update2
 */
public class order_update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order_update2() {
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
		//
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		easybuy_order_dao eod = new easybuy_order_dao();
		
		int eo_id = new Integer(request.getParameter("orderId"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		double cost = Double.parseDouble(request.getParameter("cost"));
		int status = new Integer(request.getParameter("status"));
		
		easybuy_order order = new easybuy_order(eo_id, 0, name, address, null, cost, status, 0,null);
		if(eod.update(order)>0){
			response.sendRedirect("manage-result.jsp");
		}	
	}
}
