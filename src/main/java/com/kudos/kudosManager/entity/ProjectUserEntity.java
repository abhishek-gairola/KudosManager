package com.kudos.kudosManager.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_user database table.
 * 
 */
@Entity
@Table(name="project_user")
@NamedQuery(name="ProjectUser.findAll", query="SELECT p FROM ProjectUserEntity p")
public class ProjectUserEntity implements Serializable {
	private static final Long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectUserEntityPK id;

	private String status;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectid", insertable = false, updatable = false)
	private ProjectEntity project;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid", insertable = false, updatable = false)
	private UserEntity user;

	public ProjectUserEntity() {
	}

	public ProjectUserEntityPK getId() {
		return this.id;
	}

	public void setId(ProjectUserEntityPK id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProjectEntity getProject() {
		return this.project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
