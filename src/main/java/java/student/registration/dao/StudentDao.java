package java.student.registration.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	public int registerStudent(Student student) throws ClassNotFoundException {
        String INSERT_STUDENT_SQL = "INSERT INTO stud" +
            "  (code, name, age, school, dob, email, mobile) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/java", // Change to your PostgreSQL database URL
                "postgres", // Change to your PostgreSQL
                "12345"
            );

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {

            preparedStatement.setInt(1, student.getCode());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getSchool());
            preparedStatement.setDate(5, new java.sql.Date(student.getDob().getTime())); // Assuming dob is a Date
            preparedStatement.setString(6, student.getEmail());
            preparedStatement.setString(7, student.getMobile());
            
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
    
    public Student getStudentByCode(int studentCode) {
        Student student = null;
        String SELECT_STUDENT_BY_CODE = "SELECT * FROM student WHERE code = ?;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_CODE)) {

            preparedStatement.setInt(1, studentCode);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int code = resultSet.getInt("code");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String school = resultSet.getString("school");
                    Date dob = resultSet.getDate("dob");
                    String email = resultSet.getString("email");
                    String mobile = resultSet.getString("mobile");

                    student = new Student();
                    student.setCode(code);
                    student.setName(name);
                    student.setAge(age);
                    student.setSchool(school);
                    student.setDob(dob);
                    student.setEmail(email);
                    student.setMobile(mobile);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String school = resultSet.getString("school");
                Date dob = resultSet.getDate("dob");
                String email = resultSet.getString("email");
                String mobile = resultSet.getString("mobile");

                Student student = new Student();
                student.setCode(code);
                student.setName(name);
                student.setAge(age);
                student.setSchool(school);
                student.setDob(dob);
                student.setEmail(email);
                student.setMobile(mobile);

                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

   

    public void updateStudent(Student student) {
        String UPDATE_STUDENT_SQL = "UPDATE student SET name=?, age=?, school=?, dob=?, email=?, mobile=? WHERE code=?;";

        try {
            Class.forName("org.postgresql.Driver");
            String jdbcUrl = "jdbc:postgresql://localhost:5432/student";
            String username = "postgres";
            String password = "";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {

                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getAge());
                preparedStatement.setString(3, student.getSchool());
                preparedStatement.setDate(4, new java.sql.Date(student.getDob().getTime()));
                preparedStatement.setString(5, student.getEmail());
                preparedStatement.setString(6, student.getMobile());
                preparedStatement.setInt(7, student.getCode());

                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int studentId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE code = ?")) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error connecting to the database.", e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
