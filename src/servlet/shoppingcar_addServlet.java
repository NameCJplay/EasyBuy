package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dao.shoppingcar_dao;

import entity.EASYBUY_USER;
import entity.Product;
import entity.t_shopping_car;

/**
 * Servlet implementation class shoppingcar_addServlet
 */
public class shoppingcar_addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingcar_addServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession sess = request.getSession();
		
		ProductDao pd = new ProductDao();
		shoppingcar_dao scd = new shoppingcar_dao();
		int uid=0;
		
			int epid = new Integer(request.getParameter("epid"));
			int count = new Integer(request.getParameter("count"));
			
			EASYBUY_USER user = (EASYBUY_USER)sess.getAttribute("user");
			uid= user.getEu_user_id();
			
			t_shopping_car scar = new t_shopping_car(0, epid, count, uid);
			
			int coum = scd.selectrepaly(epid, uid);
			
			if(coum>0){
				scd.updatecount(coum);
			}else{
				scd.add(scar);
			}

			PrintWriter pw = response.getWriter();
			pw.write("1");
			
		
		
		
		
	}

}
