package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import common.DbConnection;

/**
 * Servlet implementation class ForgetPass
 */
@WebServlet("/ForgetPass")
public class ForgetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPass() {
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
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");

		
		DbConnection db=new DbConnection();
		Connection con=db.connect();
		
		String sql="select * from customer where email=?";
		
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="update customer set password=? where email=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, pass);
				ps.setString(2, email);
				ps.executeUpdate();
				
				request.setAttribute("error", "Password Updated Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("forgetpass.jsp");
				rd.include(request, response);
				
				response.setHeader("Refresh","1;url=http://localhost:8080/final_project/login.jsp");
			}
			else {
				request.setAttribute("error", "INVALID CREDENTIALS");
				RequestDispatcher rd=request.getRequestDispatcher("forgetpass.jsp");
				rd.include(request, response);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
