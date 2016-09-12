package io.egen.api_module.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "UserComments.findByMovieID", query = "Select u from UserComments u where u.imdbID=:pID order by u.commentOn desc"),
		}
)
public class UserComments {
		
	@Id
	private String cID;
	private String userName;

	private String comment;
	private String imdbID;
	@Column(name = "commentOn", updatable = false)
	private Date commentOn;

	@PrePersist
	protected void onCreate() {
		commentOn = new Date();
	    }
	
	public UserComments(){
		cID = UUID.randomUUID().toString();
	}

	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
	}
	
	@JsonProperty("UserName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("Comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	
	@JsonProperty("CommentOn")
	public Date getCommentOn() {
		return commentOn;
	}

	public void setCommentOn(Date commentOn) {
		this.commentOn = commentOn;
	}
	
	
}
