package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.easybuy_order_dao;
import dao.easybuy_orderdetail_dao;
import dao.shoppingcar_dao;

import entity.easybuy_order;
import entity.easybuy_orderdetail;
import entity.t_shopping_car;

/**
 * Servlet implementation class PayInfoServlet
 */
public class PayInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		easybuy_order_dao eod = new easybuy_order_dao();
		easybuy_orderdetail_dao eodd = new easybuy_orderdetail_dao();
		shoppingcar_dao scd = new shoppingcar_dao();
		
		
		String stauts = 
			request.getParameter("trade_status");
		if(stauts.equals("TRADE_SUCCESS")){
			// 说明支付宝支付成功
			// 将该订单修改为已支付
			// 获取订单号
			String oid = 
				request.getParameter("out_trade_no");		
			//1--已发货
			//2--待发货
			//3--审批中
			//4--买家已付款
			//0--买家待付款
			eod.update_status(oid, 4);
			
			//创建订单详情
			
			
			String[] numberarr = (String[])sess.getServletContext().getAttribute("numberarr");
			String[] pricearr = (String[])sess.getServletContext().getAttribute("pricearr");
			String[] idarr = (String[])sess.getServletContext().getAttribute("idarr");
			String[] caridarr = (String[])sess.getServletContext().getAttribute("caridarr");
			
			for (int i = 0; i < idarr.length; i++) {
				int carid = Integer.parseInt(caridarr[i]);
				int id = Integer.parseInt(idarr[i]);
				int number = Integer.parseInt(numberarr[i]);
				double price = Double.parseDouble(pricearr[i]);
				double num = number*price;
				
				easybuy_orderdetail det = new easybuy_orderdetail(0, oid, id, number, num);
				eodd.add(det);
				scd.delete(carid);
			}
			
			System.out.println("回掉了");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
