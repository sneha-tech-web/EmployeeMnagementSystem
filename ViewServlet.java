import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM employee_db";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            out.println("<table border='1' style='width:95%;margin:auto;border-collapse:collapse;'>");
            out.println("<tr>" +
                    "<th>ID</th><th>Name</th><th>Position</th><th>Department</th>" +
                    "<th>Email</th><th>Phone</th><th>Address</th>" +
                    "<th>Education</th><th>Aadhar</th><th>Salary</th><th>Paid</th>" +
                    "</tr>");

            while (rs.next()) {

                out.println("<tr>");

                out.println("<td>" + rs.getString("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("position") + "</td>");
                out.println("<td>" + rs.getString("department") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("education") + "</td>");
                out.println("<td>" + rs.getString("aadhar") + "</td>");
                out.println("<td>" + rs.getDouble("salary") + "</td>");
                out.println("<td>" + rs.getString("paid") + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error loading employees");
        }
    }
}
