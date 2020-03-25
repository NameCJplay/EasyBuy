package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

import dao.ProductDao;

import entity.Product;
import entity.product_category;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setCharset("UTF-8");
		try {
			su.upload();
			String path = this.getServletContext().getRealPath("images/product");
			su.save(path);
			String name = su.getRequest().getParameter("productName");
			String ePCIdstr = su.getRequest().getParameter("parentId");
			int ePCID = Integer.parseInt(ePCIdstr);
			
			String pricestr = su.getRequest().getParameter("productPrice");
			double price = Double.parseDouble(pricestr);
			String stockstr = su.getRequest().getParameter("stock");
			int stock = Integer.parseInt(stockstr);
			String epcchildidstr = su.getRequest().getParameter("epcchildid");
			int epcchildid = Integer.parseInt(epcchildidstr);
			String filename =  su.getFiles().getFile(0).getFileName();
			product_category cate = new product_category(ePCID, null, 0);
			Product pro = new Product(0, name, null, price, stock, epcchildid, filename, null, null, cate);
			new ProductDao().add(pro);
			response.sendRedirect("ProductServlet");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
