import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String position = request.getParameter("position");
            String department = request.getParameter("department");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String education = request.getParameter("education");
            String aadhar = request.getParameter("aadhar");
            String salary = request.getParameter("salary");
            String paid = request.getParameter("paid");

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO employees_db VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, position);
            ps.setString(4, department);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, address);
            ps.setString(8, education);
            ps.setString(9, aadhar);

            double sal = 0;
            if (salary != null && !salary.isEmpty()) {
                sal = Double.parseDouble(salary);
            }
            ps.setDouble(10, sal);

            if (paid == null) {
                paid = "no";
            }
            ps.setString(11, paid);

            ps.executeUpdate();

            System.out.println("Employee Added Successfully!");

            response.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error adding employee");
        }
    }
}
