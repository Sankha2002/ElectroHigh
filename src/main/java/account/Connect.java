package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import common.*;


public class Connect {
	
	public boolean editProfile(String name,String ph,String email) {
		DbConnection db=new DbConnection();
		Connection con=db.connect();
		String sql=("update customer set name=?,mobile_number=? where email=?" );
		boolean result=false;
		PreparedStatement ps;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, ph);
			ps.setString(3, email);
			
			ps.executeUpdate();
			result=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	
	public boolean deleteAccount(String email) {
		DbConnection db=new DbConnection();
		Connection con=db.connect();
		String sql=("delete from customer where email=?" );
		boolean result=false;
		PreparedStatement ps;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			ps.executeUpdate();
			result=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	
}
