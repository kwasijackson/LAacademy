package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd = null;
		
		try {	
			loginServlet loginObj = new loginServlet();
			if(loginObj.userLogin(username, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60);
				rd=request.getRequestDispatcher("/Dashboard.html");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);	
			out.print("<center><span style='color:red'>"+e.getMessage()+"</span></center>");
		}
	}
			
			
			
			
			boolean userLogin(String username, String password) throws Exception {
			if(!username.isEmpty() && !password.isEmpty()){
				if(username.matches("admin") && password.matches("admin"))
					return true;
				else {throw new Exception("Invalid Credentials");}
			}
			else {throw new Exception("Username, Password cannot be null");}
	}

}
