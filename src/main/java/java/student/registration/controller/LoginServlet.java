package java.student.registration.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.student.registration.dao.UserDao;
import java.student.registration.dao.StudentDao;
import java.student.registration.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final UserDao userDao;
    public LoginServlet() {
        super();
        this.userDao = new UserDao();
        new StudentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the login form JSP
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginuser.jsp");
//        dispatcher.forward(request, response);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginuser.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate input fields
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginuser.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Retrieve the user from the database based on email
        User user = userDao.selectUserByEmail(email);

        // Check if the user exists and the provided password matches
        if (user != null && verifyPassword(password, user.getPassword())) {
            // Set user details in session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect based on user role
            if ("admin".equalsIgnoreCase(user.getRole())) {
//                response.sendRedirect("http://localhost:8081/Student-Register-work/studentregister");
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminland.jsp");
                dispatcher.forward(request, response);
 
            } else {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
                dispatcher.forward(request, response);
            }
        } else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
            dispatcher.forward(request, response);
        }
    }

    private boolean verifyPassword(String enteredPassword, String hashedPassword) {
        // Example: Hash the entered password using SHA-256
        String hashedEnteredPassword = hashPassword(enteredPassword);

        // Compare the hashed entered password with the stored hashed password
        return hashedEnteredPassword.equals(hashedPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing the password.", e);
        }
    }

}
