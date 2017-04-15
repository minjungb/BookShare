package edu.pitt.is1017;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
// @WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PostFacade pf;
	private Integer count;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();

		String id = null;
		String username = null;

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("id")) {
				id = cookie.getValue();
			}
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
			}
		}

		// testing output
		// out.print(id);
		// out.print("\n");
		// out.print(username);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String title = request.getParameter("title");
		String isbn = request.getParameter("isbn");
		String author = request.getParameter("author");
		String edition = request.getParameter("edition");
		String desc = request.getParameter("desc");

		count = pf.getPostCount();

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		out.print(count);

		// Get an array of Cookies associated with this domain
		Cookie[] cookies = request.getCookies();

		String id = null;
		String username = null;

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("id")) {
				id = cookie.getValue();
			}
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
			}
		}

		// out.print(id);
		// out.print(username);

	}

}
