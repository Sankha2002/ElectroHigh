package registration;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String ph=request.getParameter("mn");
		String name=request.getParameter("name");
		
		Member member=new Member(name,ph,pass,email);

		Connect con=new Connect();
		boolean ch=con.insert(member);
		response.getWriter().println(ch);
		 if(con.insert(member)) {
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
			Cookie c2=new Cookie("mobile_number",member.getMn());
			response.addCookie(c2);
			Cookie c3=new Cookie("password",member.getPassword());
			response.addCookie(c3);
			Cookie c4=new Cookie("email",member.getEmail());
			response.addCookie(c4);
			response.sendRedirect("profile.jsp");
		 }
		 else {
			 request.setAttribute("error", "Account with this Email id alreday exist");
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
		 }
	}
	

}
