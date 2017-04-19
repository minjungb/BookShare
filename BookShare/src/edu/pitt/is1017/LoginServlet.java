package edu.pitt.is1017;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @EJB
    LoginFacade lf;
    private boolean loginSuccess;
    
    private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
                
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        String context = request.getContextPath();         
		PrintWriter out = response.getWriter();
                
                loginSuccess = lf.checkLogin(username, password);
                
                //RequestDispatcher view = request.getRequestDispatcher("index.html");
                
		if(loginSuccess){
                    
            // Send user name to userFacade, there it will be matched with the
			// corresponding ID from the database
			lf.setUserName(username);
			// Pull the user ID from the database
			String userID = lf.getUserID();

			// Create cookies for user and ID.
			Cookie userCookie = new Cookie("username", request.getParameter("username"));
			Cookie idCookie = new Cookie("id", userID);

			// Set expiry date after 24 Hrs for both the cookies.
			userCookie.setMaxAge(60 * 60 * 24);
			idCookie.setMaxAge(60 * 60 * 24);

			response.addCookie(userCookie);
			response.addCookie(idCookie);
                        
                        
                     response.sendRedirect("userpage.html");
		}else{
                    out.println("Wrong password/username");
		}
                   
                  
		
	}

}