package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import dao.ProductDao;

import entity.Product;
import entity.product_category;

/**
 * Servlet implementation class UpdateProServlet
 */
public class UpdateProServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setCharset("UTF-8");
		//上传图片
		try {
			
		
			su.upload();
			String path = this.getServletContext().getRealPath("/images/product");
			su.save(path);
			
			//修改
			String epidstr = su.getRequest().getParameter("productid");
			int epid = Integer.parseInt(epidstr);  
			
			
			String epdesc =	su.getRequest().getParameter("productdesc");
			
			String epcidStr = su.getRequest().getParameter("parentId");
			int epcid = Integer.parseInt(epcidStr);
			
			
			String epname=su.getRequest().getParameter("productName");
			
			String eppriceStr =	su.getRequest().getParameter("productPrice");
			double  epprice = Double.parseDouble(eppriceStr);
			
			String epspecialprice = su.getRequest().getParameter("producttejia");
			
			String epspecialbuy = su.getRequest().getParameter("producttemai");
			
			String epstockStr = su.getRequest().getParameter("productstock");
			int epstock = Integer.parseInt(epstockStr);
			
			String epcchildidStr = su.getRequest().getParameter("productchildid");
			int epcchildid = Integer.parseInt(epcchildidStr);
			// 2-2 获取图片的名字，就是上传文件的名字
			// su.getFiles()：获取所有上传的文件
			// su.getFiles().getFile(0):获取所有上传文件中的第一个文件
			// getFileName():获取文件名称
			String filename =  su.getFiles().getFile(0).getFileName();
			
			product_category pcate = new product_category(epcid, null, 0);
			
			//做修改
			Product pro = new Product(epid, epname, epdesc, epprice, epstock, epcchildid, filename, epspecialprice, epspecialbuy, pcate);
			new ProductDao().update(pro);
			
			
			// 跳到查询所有用户信息的servlet
			response.sendRedirect("ProductServlet");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
