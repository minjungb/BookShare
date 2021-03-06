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
    
    public List<Post> getPosts(){
    	Query query = em.createQuery("select p from Post p");
    	List<Post> posts = (List<Post>) query.getResultList();
    	return posts;
    }
    
    public void createPost(String id, String title, String isbn, String author, String edition, String desc, String contact){
    	int userID = Integer.parseInt(id);
    	Post newPost = new Post();
    	newPost.setUserID(userID);
    	newPost.setTitle(title);
    	newPost.setIsbn(isbn);
    	newPost.setAuthor(author);
    	newPost.setEdition(edition);
    	newPost.setDesc(desc);
    	newPost.setContact(contact);
    	em.persist(newPost);
    }
    
}
