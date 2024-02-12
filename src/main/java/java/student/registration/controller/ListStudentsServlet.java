package java.student.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListStudentsServlet
 */
@WebServlet("/Students")
public class ListStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final StudentDao studentDao;
    public ListStudentsServlet() {
        super();
        this.studentDao = new StudentDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the list of all students from the database
        List<Student> allStudents = null;
        
            allStudents = studentDao.getAllStudents();
        

        // Set the list of students as an attribute in the request
        request.setAttribute("students", allStudents);

        // Forward to a JSP page for displaying the list
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/response.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
