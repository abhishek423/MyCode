package writer;

import java.util.ArrayList;

public class WriterFactory {
	

	public IWriter getWiterObject(String params) {

		if(params.equalsIgnoreCase("html")) {
			//System.out.println("html option");
			return new HtmlWriter();
		}else if(params.equalsIgnoreCase("xml")) {
			return new XMLWriter();
		}else if(params.equalsIgnoreCase("csv")) {
			return new CsvWriter();
		}
		
		return null;
	}


}
