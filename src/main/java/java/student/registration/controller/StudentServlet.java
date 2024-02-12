package java.student.registration.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.student.registration.dao.StudentDao;
import java.student.registration.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentRegister")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDao studentDao = new StudentDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Studentregister.jsp");
		    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String codeStr = request.getParameter("code");
    String name = request.getParameter("name");
    String dobStr = request.getParameter("dob");
    String school = request.getParameter("school");
    String email=request.getParameter("email");
    String mobile=request.getParameter("mobile");
    		
    		

    // Convert code to an integer
    int code = Integer.parseInt(codeStr);

    // Parse the dob string to a Date object
    Date dob = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the date format as needed

    try {
        dob = sdf.parse(dobStr);

        // Calculate age by subtracting dob from the current date
        Calendar dobCal = Calendar.getInstance();
        dobCal.setTime(dob);
        Calendar currentCal = Calendar.getInstance();

        int age = currentCal.get(Calendar.YEAR) - dobCal.get(Calendar.YEAR);

        // Check if the birthday has occurred this year
        if (currentCal.get(Calendar.DAY_OF_YEAR) < dobCal.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        // Create a new Student object
        Student student = new Student();
        student.setCode(code);
        student.setName(name);
        student.setAge(age);
        student.setSchool(school);
        student.setDob(dob);
        student.setEmail(email);
        student.setMobile(mobile);

        // Call the DAO to register the student
        try {
            studentDao.registerStudent(student);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Get the list of all students after registration
        List<Student> allStudents = null;
       
            allStudents = studentDao.getAllStudents();
        

        // Set the list of students as an attribute in the request
        request.setAttribute("students", allStudents);

        // Forward to the response.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/response.jsp");
        dispatcher.forward(request, response);
    } catch (ParseException e) {
        e.printStackTrace();
    }}
}
