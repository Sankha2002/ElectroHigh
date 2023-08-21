package order;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import common.DbConnection;

/**
 * Servlet implementation class OrderDetails
 */
@WebServlet("/OrderDetails")
public class OrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie ck[]=request.getCookies();
		PrintWriter out = response.getWriter();
		out.print("<html>");
		if(ck!=null && ck[0].getName().equals("name")) {
			String email=ck[3].getValue();
			DbConnection db=new DbConnection();
			Connection con=db.connect();
		
			String sql="select * from porder where order_id in (select order_id from coj where email=?)";
			PreparedStatement ps;
			
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				
				//if(rs.next()) {
					out.println("<table border=1 width=50% height=50% border-collapse=collapse> <tr style='background-color:#ffffb3; color:red'> <th>Order Id</th> <th>Product Name</th> <th>Quantity</th> <th>Total price</th> <th>Address</th>  <th>Order Date</th> </tr>");
					out.print("<h2>Order Details </h2>");
					while(rs.next()) {
				
						out.print("<tr style='background-color:#b3ffd9;'> <td>"+rs.getString("order_id")+"</td>");
						out.print(" <td>"+rs.getString("product_name")+"</td>");
						out.print(" <td>"+rs.getInt("no_of_item")+"</td>");
						out.print(" <td>"+rs.getInt("price")+"</td>");
						out.print(" <td>"+rs.getString("city")+","+rs.getString("postal_code")+"</td>");
						out.print(" <td>"+rs.getDate("order_date")+"</td> </tr>");
				
					}
					out.print("</table>");
				}
			 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
		}
		else {
			request.setAttribute("error", "Please login first");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		out.print("</html>");
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
