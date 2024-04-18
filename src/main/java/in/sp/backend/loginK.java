package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginK")
public class loginK extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7090198205101902231L;

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		// resp.setContentType("text/html");
		 PrintWriter out=resp.getWriter();
		//String myemail=req.getParameter("email1");
		//String mypass=req.getParameter("pass1");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root","@Kundan02");
			String n=req.getParameter("txtName");
			String p=req.getParameter("txtPwd");
			PreparedStatement ps= con.prepareStatement("select uname from login1 where uname=? password=?");
			
			ps.setString(1,n);
			ps.setString(2,p);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
				rd.forward(req,resp);
				
				
				//HttpSession session=req.getSession();
				//session.setAttribute("session_name", rs.getString("EMAIL_ID"));
				
				//RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
				//rd.include(req, resp);
			}
			else
			{
				out.println("<font color=red size=20>Login Failed!!<br>");
				out.println("<a href=login.jsp>Try Again!!</a>");
				
				//out.print("<h3 style='color:red'> Email id and password didn't matched </h3>");
				
			//	RequestDispatcher rd=req.getRequestDispatcher("/loginKB.jsp");
			//	rd.include(req, resp);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			
			out.print("<h3 style='color:red'> "+e.getMessage()+"</h3>");
			
			RequestDispatcher rd=req.getRequestDispatcher("/loginKB.jsp");
			rd.include(req, resp);
		}
	}

}
