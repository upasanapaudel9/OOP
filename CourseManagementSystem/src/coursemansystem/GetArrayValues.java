package coursemansystem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetArrayValues {
	public static String courses[], modules[];
	private int len;
	public GetArrayValues() throws SQLException {
		
		try {
			Connect c2 = new Connect();
			String s = "SELECT COUNT(*) FROM courses";
			ResultSet rs  = c2.s.executeQuery(s);
			while(rs.next()){
				len = rs.getInt("COUNT(*)");
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		courses = new String [len];
		
		
		 Connect c1;
			try {
				c1 = new Connect();
		        String s = "SELECT courseName FROM courses";
	            ResultSet rs  = c1.s.executeQuery(s);
	            int i=0;
	            while(rs.next()){
	                courses[i]=rs.getString("courseName");
	                i++;
	            }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	public static void main(String[] args) throws SQLException {
		new GetArrayValues();
		System.out.println(courses[1]);
		

	}
}
