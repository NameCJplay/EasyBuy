package servlet;

import java.io.IOException;
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
 * Servlet implementation class shoppingServlet
 */
public class shoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession sess = request.getSession();	
		easybuy_order_dao eod = new easybuy_order_dao();
		
		String[] pricearr = request.getParameterValues("price");
		String[] numberarr = request.getParameterValues("number");
		String[] idarr = request.getParameterValues("id");
		String[] caridarr = request.getParameterValues("carid");
		double num = 0;
		for (int i = 0; i < pricearr.length; i++) {
			int number = Integer.parseInt(numberarr[i]);
			double price = Double.parseDouble(pricearr[i]);
			num += (number*price);
		}
		sess.getServletContext().setAttribute("numberarr", numberarr);
		sess.getServletContext().setAttribute("pricearr", pricearr);
		sess.getServletContext().setAttribute("idarr", idarr);
		sess.getServletContext().setAttribute("caridarr", caridarr);
		
		
		Map<String,String> map = 
			MyAlipayUtil.createQrCode("Ò×ÂôÍø", num+"", null, "http://yxjk8e.natappfree.cc/easybuy2/PayInfoServlet", request,  "qrCode");
		String img = map.get("qrCode");
		String id = map.get("outTradeNo");
		
		EASYBUY_USER user = (EASYBUY_USER)sess.getAttribute("user");
		
		easybuy_order order = new easybuy_order(0, user.getEu_user_id(),
				user.getEu_user_name(), user.getEu_address(), null, num, 0, 1,id);
	
		eod.add(order);
		
		request.setAttribute("img", img);
		request.setAttribute("id", id);
		request.getRequestDispatcher("pay.jsp").forward(request, response);
	}

}
