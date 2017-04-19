/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.is1017;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoginFacade {
    @PersistenceContext(unitName="BookShare")
    private EntityManager em;
    private String username;
    
    public LoginFacade(){
        super();
    }
    
    public boolean checkLogin(String username, String password){
        List<Login> result;
        Query query = em.createQuery("SELECT u FROM Login u WHERE u.username= " + "'" + username + "'" + " AND u.password= " + "'" + password + "'");     
        try{
            result = query.getResultList();
            
        }catch(NoResultException e){
            System.out.println(query.toString());
            return false;
            
        }
        
        if(result.size() == 1){
            return true;
        }
        
        return false;
    }
    
    public String getUserID() {
		String userID = null;
		Query query = em.createQuery("select p from Login p");
		List<Login> users = (List<Login>) query.getResultList();

		for (Login u : users) {
			if (u.getUser().equals(username)) {
				userID = Integer.toString(u.getID());
				System.out.println(userID);
				return userID;
			}
		}
		return userID;
	}

	public String setUserName(String username) {
		this.username = username;
		System.out.println(username);
		return username;
	}
   
}