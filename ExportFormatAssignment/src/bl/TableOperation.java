package bl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import dao.BaseDAO;
import writer.HtmlWriter;
import writer.IWriter;
import writer.WriterFactory;

public class TableOperation {
	
	public ArrayList<String> showTables(String databaseName) {
		
		BaseDAO obj = new BaseDAO();
		Connection conn =  obj.createConnection();
		ArrayList<String> list = obj.showTables(conn,databaseName); // obj.showDatabases(conn);
		
		obj.closeConnection(conn);
		return list;
	}
	
	public void generateTableDetails(ArrayList<String> list , String databaseName,String exportFormat) {
		
		BaseDAO obj = new BaseDAO();
		Connection conn =  obj.createConnection();
		//System.out.println("get");
		System.out.println(list.size()+"tables");

		for(int i=0;i<list.size();i++) {
			String tableName=list.get(i);
			System.out.println(tableName+" creating....");
			ArrayList<String> tableHeader = obj.getTableHeads(conn,tableName,databaseName); // obj.showDatabases(conn);
	
			ArrayList<ArrayList<String>> tableRows = obj.getTableDetails(conn,tableName,databaseName); // obj.showDatabases(conn);
			//String c = exportFormat+"Writer";
			IWriter wf = new WriterFactory().getWiterObject(exportFormat);
			wf.tableGeneration(tableRows, tableHeader, tableName, databaseName);
			
			
			System.out.println(tableName+" done....");
		}
		obj.closeConnection(conn);
	}
	
	public ArrayList<String> exportFormatConfigReader(){
		
		try {
	         
	        // The text file location of your choice
	        String filename = "C:/Users/AB/Desktop/javaproject2/ExportFormatAssignment/WebContent/config.txt";
			/*FileReader fr;
			fr = new FileReader("C:/Users/AB/Desktop/javaproject2/ExportFormatAssignment/WebContent/config.txt");//("D:\\testout.txt");
			ArrayList<String> format = new ArrayList<String>();
			int i;    
		        while((i=fr.read())!=-1) {    
		        	format = char(i); //System.out.print((char)i);
		        } 
		        System.out.print((char)i);
		        fr.close(); */
			
	        FileReader fileReader = new FileReader(filename);
	         
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        ArrayList<String> lines = new ArrayList<String>();
	        String line = null;
	         
	        while ((line = bufferedReader.readLine()) != null) 
	        {
	            lines.add(line);
	        }
	         
	        bufferedReader.close();
	         
	        lines.toArray(new String[lines.size()]);
	        for(int i=0;i<lines.size();i++) {
	        	System.out.println(lines.get(i));
	        }
			return lines;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;    
         
	}

}
