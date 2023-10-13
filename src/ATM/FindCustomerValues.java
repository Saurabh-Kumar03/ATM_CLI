package ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FindCustomerValues {
	
	public static String select(int id) {
		String a="";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","Mysql@7890");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM Trans where id='"+id+"'");
			while(rs.next()) {  
			//System.out.println(rs.getString(2));
				a=rs.getString(2);
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}	
		return a;
	}
}

