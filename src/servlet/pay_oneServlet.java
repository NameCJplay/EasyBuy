package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.easybuy_order_dao;
import dao.easybuy_orderdetail_dao;
import entity.easybuy_orderdetail;

/**
 * Servlet implementation class pay_oneServlet
 */
public class pay_oneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pay_oneServlet() {
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
			
			
			int count = (Integer)sess.getServletContext().getAttribute("count");
			double price = (Double)sess.getServletContext().getAttribute("price");
			int eid = (Integer)sess.getServletContext().getAttribute("eid");
			double num = count*price;
			easybuy_orderdetail det = new easybuy_orderdetail(0, oid, eid, count, num);
			eodd.add(det);
			System.out.println("回掉了");
	}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
