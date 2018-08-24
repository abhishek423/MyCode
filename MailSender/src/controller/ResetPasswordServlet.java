package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
       
		Date timeNow = new Date();
        String expTime = request.getParameter("expTime");
        System.out.println("expTime in reseturl string "+expTime);
        SimpleDateFormat formatter1=new SimpleDateFormat("dd-MMM-yyy.HH:mm:ss");  
        
        try {
        	Date deadline= formatter1.parse(expTime);
			PrintWriter out = response.getWriter();

			if(deadline.after(timeNow)) {
				System.out.println("You r on time");
				
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Reset Password Confirmation link</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<b>Link Verified</b>");
				out.println("</body>");
				out.println("</html>");
			}
			else{
				System.out.println("You r late");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Reset Password Confirmation link</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<b>Link Expired</b>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
		} 
        catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
	}

}
