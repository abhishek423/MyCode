package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvWriter implements IWriter {

public void tableGeneration(ArrayList<ArrayList<String>> tableRows, ArrayList<String> tableHeader,String tableName ,String databaseName) {
		

		System.out.println("in csv");
		int rows = tableRows.size();
		int cols = tableHeader.size();
		String content="";
		try {
			FileWriter fw = new FileWriter(tableName+".csv");
			File f = new File(tableName+".csv");
	        System.out.println(f.getAbsolutePath());
	        
	        String tableHeaderFields = "";

			for(int j=0;j<cols;j++ ) {
				tableHeaderFields +=tableHeader.get(j)+",";
			}
			
			//trimming the last comma in header fields
			content +=tableHeaderFields.substring(0, tableHeaderFields.length()-1);
			content +="\n";
			
			for(int i=0;i<rows;i++ ) {
		       
				String tableDataFields = "";

				for(int j=0;j<cols;j++ ) {
					tableDataFields +=tableRows.get(i).get(j)+",";
				}
				
				//trimming the last comma in header fields
				content +=tableDataFields.substring(0, tableDataFields.length()-1);
				content +="\n";
			}
			fw.write(content);
			fw.close();      
			   
				
			// System.out.println(fw.getAbsolutePath());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}
