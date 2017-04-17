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
public class UserFacade {
	@PersistenceContext(unitName = "BookShare")
	private EntityManager em;
	private String username;

	public UserFacade() {
		super();
	}

	public String getUserID() {
		String userID = null;
		Query query = em.createQuery("select p from User p");
		List<User> users = (List<User>) query.getResultList();

		for (User u : users) {
			if (u.getUsername().equals(username)) {
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