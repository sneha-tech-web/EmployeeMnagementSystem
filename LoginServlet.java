import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Demo validation (replace with DB logic)
        if ("admin".equals(username) && "1234".equals(password)) {

            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            // Redirect to dashboard
            response.sendRedirect("dashboard.html");

        } else {
            // Invalid login
            out.println("<script>alert('Invalid username or password');window.location='index.html';</script>");
        }
    }
}
