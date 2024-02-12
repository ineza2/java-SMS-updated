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

import java.student.registration.dao.UserDao;
import java.student.registration.model.User;
import java.student.registration.util.ValidationUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final UserDao userDao;

    public RegisterServlet() {
        super();
        this.userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the registration form JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userregister.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = "Guest"; // Default role for registered users, you can change this as needed

        // Validate input fields
        if (username == null || email == null || password == null || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            forwardToFailurePage(request, response, null);
            return;
        }

        // Validate email format
        if (!ValidationUtils.isValidEmail(email)) {
            forwardToFailurePage(request, response, null);
            return;
        }

        // Validate password format
        if (!ValidationUtils.isValidPassword(password)) {
            forwardToFailurePage(request, response, null);
            return;
        }

        // Hash the password before storing it
        String hashedPassword = hashPassword(password);

        // Create a new User object
        User newUser = new User(0, username, email, hashedPassword, role);

        // Insert the user into the database
        try {
            userDao.insertUser(newUser);
            forwardToSuccessPage(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            forwardToFailurePage(request, response, e);
        }
    }

    private void forwardToSuccessPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration-success.jsp");
        dispatcher.forward(request, response);
    }

    private void forwardToFailurePage(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws ServletException, IOException {
        // Log the exception to the console if it's not null
        if (e != null) {
            e.printStackTrace();
        }

        // Forward the request to the failure page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration-failure.jsp");
        dispatcher.forward(request, response);
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
