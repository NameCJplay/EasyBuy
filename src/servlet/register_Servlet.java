package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.easybuy_user_dao;
import entity.EASYBUY_USER;

/**
 * Servlet implementation class register_Servlet
 */
public class register_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register_Servlet() {
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
		easybuy_user_dao userdao = new easybuy_user_dao();
		
		
		String name = request.getParameter("userName");
		String pwd = request.getParameter("rePassWord");
		String verycode = request.getParameter("veryCode");
		
		String code = (String)sess.getAttribute("mycode");
		
		
		
		if(code.equalsIgnoreCase(verycode)){
			EASYBUY_USER user = new EASYBUY_USER(0, name, pwd, null, null, null, null, null, null, 1);
			int count = userdao.register(user);
			if(count>0){
				response.sendRedirect("login.html");
			}else{
				response.sendRedirect("register.html");
			}
		}else{
			response.sendRedirect("register.html");
		}
		
	}

}
