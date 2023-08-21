package login;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		LoginBean obj=new LoginBean();
		obj.setPassword(pass);
		obj.setEmail(email);
		
		Connect con=new Connect();
		LoginBean member=con.validate(obj);
		if(member!=null) {
			Cookie ck[]=request.getCookies();
			if(ck!=null) {
				for(Cookie cookie:ck) {response.getWriter().println(cookie.getName()+" "+cookie.getValue());
					cookie.setValue(null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			Cookie c1=new Cookie("name",member.getName()); 
			response.addCookie(c1);
			Cookie c2=new Cookie("mobile_number",member.getMobile());
			response.addCookie(c2);
			Cookie c3=new Cookie("password",member.getPassword());
			response.addCookie(c3);
			Cookie c4=new Cookie("email",member.getEmail());
			response.addCookie(c4);
		
			response.sendRedirect("profile.jsp");
		}
		else {
			request.setAttribute("error", "INVALID CREDENTIALS");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

}
