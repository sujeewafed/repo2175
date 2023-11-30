package DB;

import java.sql.*;
import java.util.jar.Attributes.Name;

public class DBApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement statement=null;
		ResultSet rs=null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Problem in loading the driver");
			e.printStackTrace();
		}
		
		try {
			String db="Database1.accdb";
			String dbURL="jdbc:ucanaccess://" + db;
			conn = DriverManager.getConnection(dbURL);
			statement =conn.createStatement();
			
			String query = "";
			/*
			query = " INSERT INTO EMP (ENAME,SALARY) "
					+ "CALUES ('SAHA', 500)";
			statement.executeUpdate(query);
			*/
			
			query = "Update emp SET SALARY = 120000 where Ename = 'Sujeewa'";
			statement.executeUpdate(query);
			
			query = "DELETE FROM Emp where EName = 'Sujeewa'";
			statement.executeUpdate(query);
			rs = statement.executeQuery("SELECT * FROM EMP");
			int id=0;
			String name="";
			double salary=0;
			
			while (rs.next()) {
				id= rs.getInt(1);
				name = rs.getString(2);
				salary = rs.getDouble(3);
				System.out.println("Id " + id + " Name " + name + " Salary " + salary);
				
			}
		}
		catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("Problem with DB" + ex.getMessage());
		}		
		finally {
			try {
				if(conn != null) {
					rs.close();
					statement.close();
					conn.close();
				}
				
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}

}
