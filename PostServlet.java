package edu.pitt.is1017;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();

		String id = null;
		String username = null;

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("id")) {
				id = cookie.getValue();
				System.out.println("ID Cookie in Post Servlet: " + id);
			}
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
				System.out.println("username Cookie in Post Servlet: " + username);
			}
		}

		String title = request.getParameter("title");
		String isbn = request.getParameter("isbn");
		String author = request.getParameter("author");
		String edition = request.getParameter("edition");
		String desc = request.getParameter("desc");
		String funct = request.getParameter("funct");

		if (funct.equals("create")) {
			pf.createPost(id, title, isbn, author, edition, desc);
			PrintWriter out = response.getWriter();
			out.print("good");
			
		} else if (funct.equals("fill")) {
			count = pf.getPostCount();
			List<Post> posts = pf.getPosts();

			JsonObjectBuilder builder = Json.createObjectBuilder();
			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

			for (Post p : posts) {

				int pID = p.getID();
				String pTitle = p.getTitle();
				String pIsbn = p.getIsbn();
				String pAuthor = p.getAuthor();
				String pEdition = p.getEdition();
				String pDescription = p.getDesc();
				if (pTitle == null) {
					pTitle = "";
				}
				if (pIsbn == null) {
					pIsbn = "";
				}
				if (pAuthor == null) {
					pAuthor = "";
				}
				if (pEdition == null) {
					pEdition = "";
				}
				if (pDescription == null) {
					pDescription = "";
				}

				JsonObjectBuilder postBuilder = Json.createObjectBuilder();
				JsonObject postJson = postBuilder.add("id", pID).add("title", pTitle).add("isbn", pIsbn)
						.add("author", pAuthor).add("edition", pEdition).add("description", pDescription).build();

				arrayBuilder.add(postJson);
			}

			JsonObject object = builder.add("count", count).add("posts", arrayBuilder).build();

			PrintWriter out = response.getWriter();
			out.print(object);
		}

	}

}
