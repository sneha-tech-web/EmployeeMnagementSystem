import java.io.IOException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String id = request.getParameter("id");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM employees_db WHERE id = ?"
            );

            ps.setString(1, id);

            ps.executeUpdate();

            // after delete redirect back to page
            response.sendRedirect("deleteEmployees");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error deleting employee");
        }
    }
}
