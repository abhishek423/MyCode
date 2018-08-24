package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.PasswordResetOperation;

/**
 * Servlet implementation class MailSendServlet
 */
@WebServlet("/MailSendServlet")
public class MailSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String toEmail = request.getParameter("email");
		String body = "Click the link below to reset your password(the link is valid for 2 minutes).\n";
		String sub = "Test mail";
		
		//String guid = g.ToString();
		Date d = new java.util.Date();
		//string s = "insert into tblForgotPassword(Email, ActivationCode, TimeDuration,Status) values('"+txtemail.Text+"','"+guid+"','"+d.ToString()+"','Pending')";
		//da1 = new SqlDataAdapter(s,con);
		//ds1 = new DataSet();
		//da1.Fill(ds1);

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy.HH:mm:ss");  
        Date date = new Date();  
        System.out.println(formatter.format(date)); 

        date.setTime(date.getTime() + (((1 * 60) + 59)* 1000));

        System.out.println(formatter.format(date)); 
        String expTime = formatter.format(date);
        System.out.println(expTime);
		//body += "http://localhost:8080/MailSender/ResetPassword.aspx?uid=" + g.ToString();
        //"http://maps.google.at/maps?saddr=4714&daddr=Marchtrenk&hl=de"
		//body += "http://localhost:8080/MailSender/ResetPasswordServlet?expTime=" + expTime;

		body += "http://192.168.0.105:8080/MailSender/ResetPasswordServlet?expTime=" + expTime;
		new PasswordResetOperation().execute(sub,body,toEmail); 

	}

}
