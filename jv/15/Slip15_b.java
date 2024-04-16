

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Cookiee
 */
public class Cookiee extends HttpServlet {
	private static final long serialVersionUID = 1L;
     static int i;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookiee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();

		response.setContentType("text/html");
		Cookie c=new Cookie("visit",String.valueOf(i));
		response.addCookie(c);
		int j=Integer.parseInt(c.getValue());
		if(j==1)
		{
			
			out.println("wellcome user");
			
		}
		else
		{
			out.println(" You have visited the website"+j+"times");
			
		}
		i++;
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
