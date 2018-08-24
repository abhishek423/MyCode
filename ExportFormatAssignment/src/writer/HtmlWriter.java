package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HtmlWriter implements IWriter{

	public void tableGeneration(ArrayList<ArrayList<String>> tableRows, ArrayList<String> tableHeader,String tableName ,String databaseName) {
		

		System.out.println("in html");
		int rows = tableRows.size();
		int cols = tableHeader.size();
		String content="";
		String fileDestination = "C:/Users/AB/Desktop/javaproject2/ExportFormatAssignment/";
		try {
			FileWriter fw = new FileWriter(tableName+".html");
			File f = new File(fileDestination,tableName+".html");
	        System.out.println(f.getAbsolutePath());
			
			content ="<html>\n";

			content +="<head>\n"; 
			content +="\t<title>HTML Tables</title>\n";    

			content +="</head>\n";    
			content +="<body>\n";    
			content +="\t<table border = \"1\">\n";    
			
			content +="\t\t<tr>\n";

			for(int j=0;j<cols;j++ ) {
				content +="\t\t\t<td>"+tableHeader.get(j)+"</td>\n";
			}
			
			content +="\t\t</tr>\n";

			for(int i=0;i<rows;i++ ) {
				content +="\t\t<tr>\n";
				
				for(int j=0;j<cols;j++ ) {
					content +="\t\t\t<td>"+tableRows.get(i).get(j)+"</td>\n";
				}
				
			}
			content +="\t\t</tr>\n";    
			content +="\t</table>\n";    
			content +="</body>\n";    
			content +="</html>\n";
			fw.write(content);
			fw.close();      
			   
				
			// System.out.println(fw.getAbsolutePath());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}