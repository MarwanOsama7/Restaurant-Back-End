package com.global.UserManage.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.global.RestaurantManage.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sec_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String email;
	
	private String userName ; 
	
	private String password;
	
	private int active;
	
	@ManyToMany
	@JoinTable(name = "sec_user_roles",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	@OrderColumn(name = "id")
	private Set<Role> roles = new HashSet<>();
	
	
	public AppUser(Long id) {
		super();
		this.id = id;
	}
}
