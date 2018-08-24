package writer;

import java.util.ArrayList;

public interface IWriter {

	public void tableGeneration(ArrayList<ArrayList<String>> tableRows, ArrayList<String> tableHeader,String tableName,String databaseName);

}
