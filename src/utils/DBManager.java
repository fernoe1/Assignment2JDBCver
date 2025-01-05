package utils;

import entities.Employee;
import entities.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection con = null;
    public void connect(String connectionUrl, String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, user, pass);
            System.out.println("Connection successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM employees");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String position = rs.getString("position");
                double salary = rs.getDouble("Salary");

                Employee employee = new Employee(id, name, surname, position, salary);
                employees.add(employee);
            }

            return employees;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                double gpa = rs.getDouble("gpa");

                Student student = new Student(id, name, surname, gpa);
                students.add(student);
            }

            return students;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
