import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Validate password
        if (!password.equals(confirmPassword)) {
            out.println("<script>alert('Passwords do not match');window.location='register.html';</script>");
            return;
        }

        // Store in session (TEMPORARY - demo only)
        HttpSession session = request.getSession();
        session.setAttribute("regUser", username);
        session.setAttribute("regPass", password);

        // Success message
        out.println("<script>alert('Registration Successful! Please login');window.location='login.html';</script>");
    }
}
