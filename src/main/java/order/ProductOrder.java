package order;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProductOrder
 */
@WebServlet("/ProductOrder")
public class ProductOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductOrder() {
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
		String pname=request.getParameter("pname");
		String city=request.getParameter("city");
		String pin=request.getParameter("pin");
		int price=Integer.parseInt(request.getParameter("price"));
		int nop=Integer.parseInt(request.getParameter("noi"));
		
		LocalDateTime currentLocalDateTime = LocalDateTime.now();
        // Create DateTimeFormatter instance with specified format
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        // Format LocalDateTime to String
        String id = currentLocalDateTime.format(dateTimeFormatter);
        
      
        Cookie ck[]=request.getCookies();
		String email=ck[3].getValue();
		Order order=new Order(id,pname,city,pin,nop,price);
		
		Connect con=new Connect();
		con.insert(order,email);
		
		response.getWriter().print("<html><h2>Order placed Sucessfully</h2></html>");
		response.setHeader("Refresh","1;url=http://localhost:8080/final_project/profile.jsp");
		
		
	}

}
