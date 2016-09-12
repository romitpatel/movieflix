package io.egen.api_module.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name="User.findAll",query="SELECT e from User e ORDER	BY e.email"),
		@NamedQuery(name="User.findByEmail",query="SELECT e from User e WHERE e.email=:pemail")
})
public class User {
	
	
	@Id
	private String userid;
	
	
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String email;
	private String password;
	
	private boolean isAdmin;
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public User(){
		userid = UUID.randomUUID().toString();
	}
	
	
	public String getUserId() {
		return userid;
	}
	public void setUserId(String userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}

