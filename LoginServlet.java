package edu.pitt.is1017;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
	}

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
                
		String username = request.getParameter("username");
		String password = request.getParameter("password");
                String context = request.getContextPath();         
		PrintWriter out = response.getWriter();
              
                loginSuccess = lf.checkLogin(username, password);
		if(loginSuccess){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
                  
		
	}

}
