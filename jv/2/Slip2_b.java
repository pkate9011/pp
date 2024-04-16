
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Slip2_b
 */
public class Slip2_b extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Slip2_b() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");

		PrintWriter out=res.getWriter();

		out.println("<html><body><h2>Information about HTTPRequest<h2>");

		out.println("<br> Server name:"+req.getServerName());

		out.println("<br> Server Port:"+req.getServerPort()); 
		out.println("<br> IP Address:"+req.getRemoteAddr());

		out.println("</body></html>");

		out.close();
		
	}

}
