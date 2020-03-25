package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.recently_dao;

import entity.EASYBUY_USER;

/**
 * Servlet implementation class recentlyServlet
 */
public class recentlyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recentlyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		recently_dao rd = new recently_dao();
		int pid = new Integer(request.getParameter("epid"));
		
		EASYBUY_USER user = (EASYBUY_USER)sess.getAttribute("user");
		int uid = user.getEu_user_id();
		int count = rd.selectrepaly(uid, pid);
		if(count==1){
			response.sendRedirect("ProductviewServlet?epid="+pid);
		}else{
			rd.add(pid, uid);
		response.sendRedirect("ProductviewServlet?epid="+pid);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
