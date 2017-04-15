package edu.pitt.is1017;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pitt.is1017.dto.User;
import edu.pitt.is1017.service.LoginService;

import java.io.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import javax.servlet.*;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// @EJB
	// BaseFacade bf;

	@EJB
	UserFacade uf;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null) {
			System.out.println("fail");
		} else if (username != null) {
			System.out.println("success");

			uf.setUserName(username);

			String userID = uf.getUserID();

			// Create cookies for user and ID.
			Cookie userCookie = new Cookie("username", request.getParameter("username"));
			Cookie idCookie = new Cookie("id", userID);

			// Set expiry date after 24 Hrs for both the cookies.
			userCookie.setMaxAge(60 * 60 * 24);
			idCookie.setMaxAge(60 * 60 * 24);

			// Add both the cookies in the response header.
			response.addCookie(userCookie);
			response.addCookie(idCookie);

			// response.sendRedirect("userpage.html");

		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null) {
			System.out.println("fail");
		} else if (username != null) {

			System.out.println(username);

			uf.setUserName(username);

			String userID = uf.getUserID();

			// Create cookies for user and ID.
			Cookie userCookie = new Cookie("username", request.getParameter("username"));
			Cookie idCookie = new Cookie("id", userID);

			// Set expiry date after 24 Hrs for both the cookies.
			userCookie.setMaxAge(60 * 60 * 24);
			idCookie.setMaxAge(60 * 60 * 24);

			// Add both the cookies in the response header.
			response.addCookie(userCookie);
			response.addCookie(idCookie);

			// response.sendRedirect("userpage.html");
		}

		response.setContentType("text/plain");

	}

	public String generateID() {
		UUID userID = UUID.randomUUID();
		return userID.toString();
	}

}
