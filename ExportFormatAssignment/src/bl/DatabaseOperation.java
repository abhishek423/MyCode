package bl;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BaseDAO;

public class DatabaseOperation {
	
	public ArrayList<String> showDatabases() {
		
		BaseDAO obj = new BaseDAO();
		Connection conn =  obj.createConnection();
		ArrayList<String> list = obj.showDatabases(conn); // obj.showDatabases(conn);
		
		obj.closeConnection(conn);
		return list;
	}
}
