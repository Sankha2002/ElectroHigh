package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import common.DbConnection;

public class Connect {

	public void insert(Order order,String email) {
		DbConnection db=new DbConnection();
		Connection con=db.connect();
		
		String sql="insert into porder values(?,?,?,?,?,?,?)";
		String sql2="insert into coj values(?,?)";
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		
		PreparedStatement ps;
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, order.getOrder_id());
			ps.setString(2, order.getProduct_name());
			ps.setInt(3, order.getNop());
			ps.setInt(4, order.getPrice());
			ps.setString(5, order.getCity());
			ps.setString(6, order.getPostal_code());
			ps.setDate(7, date);
			
			ps.executeUpdate();
			
			ps=con.prepareStatement(sql2);
			ps.setString(1, order.getOrder_id());
			ps.setString(2, email);
			
			ps.executeUpdate();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public boolean deleteAccount(String email) {
		DbConnection db=new DbConnection();
		Connection con=db.connect();
		boolean result=false;String sql3;
		String sql1="select order_id from coj where email=?";
		String sql2="delete from coj where email=?";
		sql3="delete from porder where order_id=?";
		
		PreparedStatement ps;
		
		try {
			//storing order_id in ResultSet rs
			ps=con.prepareStatement(sql1);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			
			//delete the records from coj table
			ps=con.prepareStatement(sql2);
			ps.setString(1, email);
			ps.executeUpdate();
			
			//delete the records from porder table
			while(rs.next()) {
				
				ps=con.prepareStatement(sql3);
				ps.setString(1, rs.getString("order_id"));
				ps.executeUpdate();
			}
			result=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
}


	




