package edu.pitt.is1017;

import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PostEntity
 *
 */
@Entity
@Table(name="user")
public class Login{
	@Id
	@GeneratedValue
	@Column (name="userID")
	private int ID;

	@Column (name="username")
	private String username;
	@Column (name="password")
	private String password;
	@Column (name="email")
	private String email;
	@Column (name="firstName")
	private String fName;
	@Column (name="lastName")
	private String lName;   


	public Login() {
		super();
	}   
	public String getUser() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
        
	public String getfName() {
		return this.fName;
	}

	public String getlName(String author) {
		return this.lName;
	}   
	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
   
}