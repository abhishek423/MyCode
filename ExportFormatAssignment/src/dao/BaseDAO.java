package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//import com.mysql.jdbc.ResultSetMetaData;

public class BaseDAO {

	String userName;
	String password;
	String host;
	String dbName;
	
	public BaseDAO() {
		super();
		this.userName = "root";
		this.password = "";
		this.host = "localhost:3306";
		this.dbName = "tracking";
	}
	
	public Connection createConnection()/*String userName, String password, String host, String dbName)*/{
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.dbName , this.userName,this.password);
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Database is not connected properly","Error",JOptionPane.WARNING_MESSAGE);
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeConnection(Connection conn) {
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> showDatabases(Connection conn) {
		
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {			
			
			Statement stmt = conn.createStatement();
			rs=((Statement) stmt).executeQuery("show DATABASES");
			
				while(rs.next()){
					list.add(rs.getString(1));
				}

		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (NumberFormatException e) {

			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> showTables(Connection conn,String databaseName) {
		
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {			
			
			Statement stmt = conn.createStatement();
			rs=((Statement) stmt).executeQuery("show tables from "+databaseName);
			
				while(rs.next()){
					list.add(rs.getString(1));
				}

		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (NumberFormatException e) {

			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getTableHeads(Connection conn,String tableName,String databaseName) {
		
		ResultSet rs = null;
		
		//ArrayList<String> cols = new ArrayList<String>();
		ArrayList<String> tableHeads = new ArrayList<String>();

		try {			
			int i=0,j,k=1;
			Statement stmt = conn.createStatement();
			rs=((Statement) stmt).executeQuery("desc "+databaseName+"."+tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int col = rsmd.getColumnCount();
			
			while(rs.next()) {
				
				tableHeads.add(rs.getString(1));
					
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (NumberFormatException e) {

			e.printStackTrace();
		}
		return tableHeads;
	}
	
	public ArrayList<ArrayList<String>> getTableDetails(Connection conn,String tableName,String databaseName) {
		
		ResultSet rs = null;
		
		//ArrayList<String> cols = new ArrayList<String>();
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		try {			
			int i=0,j,k=1;
			Statement stmt = conn.createStatement();
			rs=((Statement) stmt).executeQuery("SELECT * FROM "+databaseName+"."+tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int col = rsmd.getColumnCount();
		
			
			while(rs.next()) {
				
				ArrayList<String> rows = new ArrayList<String>();
				
				for(j=1;j<=col;j++) {
					
					rows.add(rs.getString(j));
					
				}table.add(rows);//System.out.println("\n");
			}
			System.out.println(table);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (NumberFormatException e) {

			e.printStackTrace();
		}
		return table;
	}
}
