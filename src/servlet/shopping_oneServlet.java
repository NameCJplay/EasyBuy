package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dzkj.alipay.MyAlipayUtil;

import dao.easybuy_order_dao;
import entity.EASYBUY_USER;
import entity.easybuy_order;

/**
 * Servlet implementation class PayonceServlet
 */
public class shopping_oneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopping_oneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sess = request.getSession();	
		easybuy_order_dao eod = new easybuy_order_dao();
		
		double price = Double.parseDouble(request.getParameter("price"));
		int count = new Integer(request.getParameter("count"));
		int eid = new Integer(request.getParameter("epid"));
		
		double num = price*count;
		
		sess.getServletContext().setAttribute("count", count);
		sess.getServletContext().setAttribute("price", price);
		sess.getServletContext().setAttribute("eid", eid);
		
		
		
		Map<String,String> map = 
			MyAlipayUtil.createQrCode("Ò×ÂôÍø", num+"", null, "http://yxjk8e.natappfree.cc/easybuy2/pay_oneServlet", request,  "qrCode");
		
		if(map.get("status").equals("success")){
		
		String img = map.get("qrCode");
		String id = map.get("outTradeNo");
		
		EASYBUY_USER user = (EASYBUY_USER)sess.getAttribute("user");
		
		easybuy_order order = new easybuy_order(0, user.getEu_user_id(),
				user.getEu_user_name(), user.getEu_address(), null, num, 0, 1,id);
	
		eod.add(order);
		request.setAttribute("img", img);
		request.setAttribute("id", id);

		PrintWriter pw = response.getWriter();
		pw.write(img+" "+id);
	}	
	}

}
