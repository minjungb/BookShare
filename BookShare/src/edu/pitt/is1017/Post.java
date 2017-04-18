package edu.pitt.is1017;

import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PostEntity
 *
 */
@Entity
@Table (name="post")
public class Post{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="postID")
	private int ID;

	@Column (name="title")
	private String title;
	@Column (name="isbn")
	private String isbn;
	@Column (name="author")
	private String author;
	@Column (name="edition")
	private String edition;
	@Column (name="description")
	private String desc;   


	public Post() {
		super();
	} 

	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}   
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}   
	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}   
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}   
	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
   
}
