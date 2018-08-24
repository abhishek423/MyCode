package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLWriter implements IWriter {
	
	public void tableGeneration(ArrayList<ArrayList<String>> tableRows, ArrayList<String> tableHeader,String tableName,String databaseName) {
	
		System.out.println("in xml");
		int rows = tableRows.size();
		int cols = tableHeader.size();
		String content="";
		try {
			FileWriter fw = new FileWriter(tableName+".xml");
			File f = new File(tableName+".xml");
			 content = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
			 content += "<database name=\""+databaseName+"\">\n";
			 
			 for(int i=0;i<rows;i++) {
					content +="\t<table name=\""+tableName+"\">\n";
					
					for(int j=0;j<cols;j++ ) {
						content +="\t\t<column name=\""+tableHeader.get(j)+"\">"+tableRows.get(i).get(j)+"</column>\n";
					}
					 content += "\t</table>\n";
				}
			 content += "<database>\n";

		 fw.write(content);
			fw.close();      
			   
				
			// System.out.println(fw.getAbsolutePath());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
