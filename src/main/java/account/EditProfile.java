package account;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
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
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String ph=request.getParameter("mn");
		
		Cookie ck[]=request.getCookies();
		String email=ck[3].getValue();String password=ck[2].getValue();
		
		Connect con=new Connect();
		 if(con.editProfile(name,ph,email)) {
			 request.setAttribute("error", "Profile Update Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("account.jsp");
			rd.include(request, response);
			if(ck!=null) {
					for(Cookie cookie:ck) {
						cookie.setValue(null);
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
				Cookie c1=new Cookie("name",name); 
				response.addCookie(c1);
				Cookie c2=new Cookie("mobile_number",ph);
				response.addCookie(c2);
				Cookie c3=new Cookie("password",password);
				response.addCookie(c3);
				Cookie c4=new Cookie("email",email);
				response.addCookie(c4);
			
				response.getWriter().print("<script>alert('Profile Update Successfully!')</script>");
				response.setHeader("Refresh","0;url=http://localhost:8080/final_project/profile.jsp");
		 }
		 else {
			 response.getWriter().print("<script>alert('Something went wrong!')</script>");
			response.setHeader("Refresh","0;url=http://localhost:8080/final_project/profile.jsp");
		 }
	}

}
