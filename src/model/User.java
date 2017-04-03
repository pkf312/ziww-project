package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "USERS",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"firstname", "lastname"})}
)

public class User {

	private String firstName;
	private String lastName;
	private String UserName;
	private String password;//va visto??..........................
	private String userId;
	 // poi cosa cazzo volete metterci più??......................
	
	
	public User(String firstName, String lastName, String userName, String password, String userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.UserName = userName;
		this.password = password;
		this.userId = userId;
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


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
