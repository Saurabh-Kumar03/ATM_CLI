package ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAccountDetails {
static boolean getDetail(int account) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","Mysql@7890");
			Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Trans where id='"+account+"' "); 
            // Extract data from result set
            while (rs.next()) {
               // Retrieve by column name
               if(rs.getInt("id")==account);
               return true;
            }
            return false;
			}catch(Exception e){ System.out.println(e);
			return false;
			}
           
           	
}
}
