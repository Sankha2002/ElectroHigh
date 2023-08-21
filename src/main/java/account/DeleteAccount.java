package account;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck[]=request.getCookies();
		
		order.Connect con2=new order.Connect();
		boolean r2=con2.deleteAccount(ck[3].getValue());
		
		Connect con1=new Connect();
		boolean r1=con1.deleteAccount(ck[3].getValue());
		
		if(r1 && r2) {
			response.getWriter().println("Deleted account sucessfully");
			for(Cookie cookie:ck) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			response.sendRedirect("http://localhost:8080/final_project/index.jsp");
		}
		else
			response.getWriter().println("something went wrong");
	}

}
