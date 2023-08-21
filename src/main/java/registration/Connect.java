package registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import common.DbConnection;

public class Connect {
		
		public boolean insert(Member member) {
			DbConnection db=new DbConnection();
			Connection con=db.connect();
			if(con==null)
			{
				return false;
			}
			boolean result=true; 
			PreparedStatement ps;
			String sql="select * from customer where email=?";
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, member.getEmail());
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					return false;
				}
				else {
					sql="insert into customer values(?,?,?,?)";
					
					ps=con.prepareStatement(sql);
					ps.setString(1, member.getName());
					ps.setString(2, member.getMn());
					ps.setString(3, member.getPassword());
					ps.setString(4, member.getEmail());
					
					ps.executeUpdate();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				result=false;
			}
			return true;
			
			
		}
		
	}


