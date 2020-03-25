package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Product_categoryDao;

import entity.product_category;

public class AddPcServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String EPC_NAME=request.getParameter("className");
		int parentId=Integer.parseInt(request.getParameter("parentId")) ;
		product_category pc=new product_category(0, EPC_NAME, parentId);
		new Product_categoryDao().add(pc);
		response.sendRedirect("SelectPcServlet");
		
	}

}
