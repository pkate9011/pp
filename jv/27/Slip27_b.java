
import java.io.*;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Slip27_b
 */
public class Slip27_b extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Slip27_b() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		out.println("<html><head><title>SessionTimer</title></head>");

		out.println("<body><h1>Session timer<</h1>");
		out.println("the previous timeout was" + session.getMaxInactiveInterval());
		out.println("<br>");
		session.setMaxInactiveInterval(2*60*60);
		out.println("the newly assigned timeout is" + session.getMaxInactiveInterval());
		out.println("</body></html>");
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

}
