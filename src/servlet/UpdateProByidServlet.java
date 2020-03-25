package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.Product_categoryDao;
import entity.Product;
import entity.product_category;

/**
 * Servlet implementation class UpdateProByidServlet
 */
public class UpdateProByidServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idstr = request.getParameter("epid");
		int id = Integer.parseInt(idstr);
		ArrayList<product_category> pcatelist = new Product_categoryDao().select();
		request.setAttribute("pcatelist", pcatelist);
		Product pro = new ProductDao().selectbyid(id);
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("../manage/product-modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
