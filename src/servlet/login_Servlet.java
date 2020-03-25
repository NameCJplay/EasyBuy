package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import dao.easybuy_user_dao;
import entity.EASYBUY_USER;
import entity.Product;

/**
 * Servlet implementation class login_Servlet
 */
public class login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession sess = request.getSession();
		
		String name = request.getParameter("userName");
		String pwd = request.getParameter("passWord");
		String code = request.getParameter("veryCode");
		
		easybuy_user_dao eud = new easybuy_user_dao();
		String mycode = (String)sess.getAttribute("mycode");
		
		if(code.equalsIgnoreCase(mycode)){
			EASYBUY_USER user =  eud.login(name, pwd);
			if(user!=null){			
				sess.setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("login.html");
			}
			
		}else{
			response.sendRedirect("login.html");
		}
		
	}

}
