import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private final String url = "jdbc:mysql://localhost:3306/Lab8";
    private final String user = "root";
    private final String password = "root123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //Gets all employees.
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getInt("address_id"),
                        rs.getInt("dept_id")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    //Gets an employee
    public Employee findById(int empId) {
        String sql = "SELECT * FROM Employee WHERE emp_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(rs.getInt("emp_id"), rs.getString("name"),
                            rs.getDouble("salary"), rs.getInt("address_id"),
                            rs.getInt("dept_id"));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    //Inserts a new employee
    public void create(Employee employee) {
        String sql = "INSERT INTO Employee (emp_id, name, salary, address_id, dept_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employee.getEmpId());
            pstmt.setString(2, employee.getName());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.setInt(4, employee.getAddressId());
            pstmt.setInt(5, employee.getDeptId());
            pstmt.executeUpdate();
            System.out.println("Created employee: " + employee.getName());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    //Updates an employee
    public void update(Employee employee) {
        String sql = "UPDATE Employee SET name = ?, salary = ? WHERE emp_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setDouble(2, employee.getSalary());
            pstmt.setInt(3, employee.getEmpId());
            pstmt.executeUpdate();
            System.out.println("Updated employee ID: " + employee.getEmpId());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    //Deletes an employee
    public void delete(int empId) {
        String sql = "DELETE FROM Employee WHERE emp_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empId);
            pstmt.executeUpdate();
            System.out.println("Deleted employee ID: " + empId);
        } catch (SQLException e) { e.printStackTrace(); }
    }
}