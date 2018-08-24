package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.TableOperation;

@WebServlet("/GetTableData")
public class GetTableData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String[] tables =request.getParameterValues("values");
		String[] database = request.getParameterValues("databaseName");
		String[] exportFormat = request.getParameterValues("exportFormat");
		
		String format = exportFormat[0];
		String databaseName = database[0];
		System.out.println(exportFormat);
		//tables[0].;
		
		String words2[] = tables[0].split(",");
		ArrayList<String> list = new ArrayList<String>();

		for(int i=0; i<words2.length; i++ ) {
			list.add(words2[i]); 
		}
		new TableOperation().generateTableDetails(list,databaseName,format);
		//ArrayList<Object> tf ;
		//tf = new TableOperation().fetchTableDetails(list);
		PrintWriter out = response.getWriter();
		//System.out.println(tf);
		//out.println(x);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
