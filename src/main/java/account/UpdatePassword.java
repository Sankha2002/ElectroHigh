package account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import common.DbConnection;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
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
		// TODO Auto-generated method stub
		String oldpass=request.getParameter("oldpass");
		String newpass=request.getParameter("pass");
		Cookie ck[]=request.getCookies();
		
		if(oldpass.equals(ck[2].getValue())) {
			DbConnection db=new DbConnection();
			Connection con=db.connect();
		
			String name=ck[0].getValue();String ph=ck[1].getValue();String email=ck[3].getValue();
		
			PreparedStatement ps;
			try {
				String sql="update customer set password=? where password=? and email=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, newpass);
				ps.setString(2, oldpass);
				ps.setString(3, email);
				ps.executeUpdate();
				
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
				Cookie c3=new Cookie("password",newpass);
				response.addCookie(c3);
				Cookie c4=new Cookie("email",email);
				response.addCookie(c4);
				
				response.getWriter().print("<script>alert('Password Update Successfully!')</script>");
				response.setHeader("Refresh","0;url=http://localhost:8080/final_project/profile.jsp");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			response.getWriter().print("<script>alert('Incorrent Password!')</script>");
			response.setHeader("Refresh","0;url=http://localhost:8080/final_project/profile.jsp");
		}
	}
	
	

}
