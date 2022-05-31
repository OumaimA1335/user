package com.professeur.oumaima.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.JoinColumn;
@Entity
public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long user_id;
	private String username;
	private String password;
	private Boolean enabled;
	
	 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns= @JoinColumn(name="role_id")) 
	private List<Role> roles = new ArrayList<>();
	 
	 
	 
	public User(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
		
		
	}
	
	public User() {
		super();
		
	}

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	} 
	
	
	public void addRole(Role role) {
        this.roles.add(role);
}
	 
	 
}
