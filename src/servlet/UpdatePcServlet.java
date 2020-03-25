package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Product_categoryDao;

import entity.product_category;

public class UpdatePcServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		int EPC_ID = new Integer(request.getParameter("id"));
		
		String EPC_IDstr=request.getParameter("parentId");
		int EPC_paren_ID=Integer.parseInt(EPC_IDstr);
		
		String EPC_NAME=request.getParameter("className");
		
		product_category pc=new product_category(EPC_ID, EPC_NAME,EPC_paren_ID);
		new Product_categoryDao().update(pc);
		response.sendRedirect("SelectPcServlet");
	}

}
