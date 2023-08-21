package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.DbConnection;

public class Connect {
	
	public LoginBean validate(LoginBean obj) {
		DbConnection db=new DbConnection();
		Connection con=db.connect();
		LoginBean status=new LoginBean();
		int ck=0;
		
		String sql="SELECT * FROM customer WHERE email=? AND password=?";
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, obj.getEmail());
			ps.setString(2, obj.getPassword());
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ck=1;
				status.setEmail(rs.getString("email"));
				status.setName(rs.getString("name"));
				status.setMobile(rs.getString("mobile_number"));
				status.setPassword(rs.getString("password"));
			}
			if(ck==0)
				return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	

}
