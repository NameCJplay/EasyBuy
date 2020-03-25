package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.easybuy_user_dao;
import entity.EASYBUY_USER;

/**
 * Servlet implementation class user_update2
 */
public class user_update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_update2() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		easybuy_user_dao eud = new easybuy_user_dao();
		
		int id = new Integer(request.getParameter("userid"));
		String name = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthday = request.getParameter("birthday");
		String date = birthyear+"-"+birthmonth+"-"+birthday;
		
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		EASYBUY_USER user = new EASYBUY_USER(id, name, passWord, sex, date, null, null, mobile, address, 1);
		
		if(eud.update(user)>0){
			response.sendRedirect("user_result");
		}
	}

}
