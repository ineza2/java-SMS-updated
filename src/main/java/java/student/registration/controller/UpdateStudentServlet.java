package java.student.registration.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.student.registration.dao.StudentDao;
import java.student.registration.model.Student;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //add  logic to fetch students and forward to updateStudents.jsp
    	List<Student> students=studentDao.getAllStudents();
    	request.setAttribute("students", students);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/updateStudents.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve student details from the edit form
        int studentCode = Integer.parseInt(request.getParameter("code"));

        String updatedName = request.getParameter("name");
        String updatedSchool = request.getParameter("school");

        // Parse the date string from the form
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dobParam = request.getParameter("dob");
        Date updatedDob = null;
        if (dobParam != null && !dobParam.isEmpty()) {
            try {
                updatedDob = dateFormat.parse(dobParam);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        String updatedEmail = request.getParameter("email");
        String updatedMobile = request.getParameter("mobile");

        // Fetch student details based on studentCode
        Student student = studentDao.getStudentByCode(studentCode);

        if (student != null) {
            // Set student as an attribute in the request
            request.setAttribute("student", student);

            // Update only non-null and non-empty fields
            if (updatedName != null && !updatedName.isEmpty()) {
                student.setName(updatedName);
            }
            if (updatedSchool != null && !updatedSchool.isEmpty()) {
                student.setSchool(updatedSchool);
            }
            if (updatedDob != null) {
                student.setDob(updatedDob);
            }
            if (updatedEmail != null && !updatedEmail.isEmpty()) {
                student.setEmail(updatedEmail);
            }
            if (updatedMobile != null && !updatedMobile.isEmpty()) {
                student.setMobile(updatedMobile);
            }

            // Update the student in the database
            studentDao.updateStudent(student);
        }

        // Forward to the page where you can update the details of that student
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editstudent.jsp");
        dispatcher.forward(request, response);
    }
}
