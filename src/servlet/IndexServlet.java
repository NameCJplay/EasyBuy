package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Product_categoryDao;

import entity.product_category;


public class IndexServlet extends HttpServlet {

     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<product_category>pc=new Product_categoryDao().select();
//		request.setAttribute("product", pc);
//		request.getRequestDispatcher("index.jsp")
//		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
