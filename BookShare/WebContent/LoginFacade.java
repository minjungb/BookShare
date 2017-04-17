/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.is1017;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
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

    
}
