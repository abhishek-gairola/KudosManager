package com.kudos.kudosManager.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
public class RoleEntity implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "roledescription")
	private String roledescription;

	@Column(name = "rolename")
	private String rolename;

	public RoleEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoledescription() {
		return this.roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
