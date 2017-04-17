package edu.pitt.is1017;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	@EJB
	LoginFacade lf;
	@EJB
	UserFacade uf;
	private boolean loginSuccess;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		// Grab username and password from index.html
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		loginSuccess = lf.checkLogin(username, password);

		System.out.println("username: " + username);
		System.out.println("Password: " + password);

		if (loginSuccess) {

//			// Send user name to userFacade, there it will be matched with the
//			// corresponding ID from the database
//			uf.setUserName(username);
//			// Pull the user ID from the database
//			String userID = uf.getUserID();
//
//			// Create cookies for user and ID.
//			Cookie userCookie = new Cookie("username", request.getParameter("username"));
//			Cookie idCookie = new Cookie("id", userID);
//
//			// Set expiry date after 24 Hrs for both the cookies.
//			userCookie.setMaxAge(60 * 60 * 24);
//			idCookie.setMaxAge(60 * 60 * 24);
//
//			// Add both the cookies in the response header.
//			response.addCookie(userCookie);
//			response.addCookie(idCookie);

			response.sendRedirect("userpage.html");

		} else {
			out.println("Incorrect Username or Password");
		}

		// TESTING AREA
		// out.print(userCookie.getValue() + " - " + idCookie.getValue() );

	}

}
