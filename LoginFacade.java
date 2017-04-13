/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.is1017;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoginFacade {
    @PersistenceContext(unitName="IS1017")
    private EntityManager em;
    
    public LoginFacade(){
        super();
    }
    
    public boolean checkLogin(String username, String password){
        Query check = em.createQuery("SELECT username, password FROM user WHERE username = :login AND password = :password LIMIT 1;");
        check.setParameter("login", username);
        check.setParameter("password", password);
        try{
            Login loginResult = (Login)check.getResultList();
            if(loginResult != null){
                return true;
            }
        }catch(NoResultException e){
            System.out.println(check.toString());
            return false;
        }
        
        
        
        return false;
    }
    
}
