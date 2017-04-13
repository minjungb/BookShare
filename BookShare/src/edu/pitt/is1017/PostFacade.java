package edu.pitt.is1017;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class PostFacade
 */
@Stateless
public class PostFacade {
	@PersistenceContext (unitName = "BookShare")
	private EntityManager em;

    public PostFacade() {
        super();
    }
    
    public int getPostCount(){
    	int max = 0;
    	Query query = em.createQuery("select p from Post p");
    	List<Post> posts = (List<Post>) query.getResultList();
    	
    	for(Post p: posts){
    		if(p.getID() > max){
    			max = p.getID();
    		}
    	}
    	return max;
    }  
    
}
