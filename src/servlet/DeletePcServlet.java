package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Product_categoryDao;

public class DeletePcServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String EPC_IDstr=request.getParameter("id");
		int EPC_ID=Integer.parseInt(EPC_IDstr);
		new Product_categoryDao().delete(EPC_ID);
		PrintWriter pw=response.getWriter();
		pw.write("1");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
