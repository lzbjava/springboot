package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

	@ManyToMany
	@JoinColumn(name = "did")
	@JsonBackReference
	private Department department;

	@ManyToMany(cascade = {},fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "roles_id")})
	private List<Role> roles;

}
