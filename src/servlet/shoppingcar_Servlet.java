package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.shoppingcar_dao;
import entity.EASYBUY_USER;
import entity.Product;
import entity.t_shopping_car;

/**
 * Servlet implementation class shoppingcar_Servlet
 */
public class shoppingcar_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingcar_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		
		shoppingcar_dao scd = new shoppingcar_dao();
		
		ArrayList<t_shopping_car> carlist = new ArrayList<t_shopping_car>();
		
		try {
			EASYBUY_USER user = (EASYBUY_USER)sess.getAttribute("user");
			carlist = scd.selectByUid(user.getEu_user_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("carlist", carlist);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
