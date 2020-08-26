package com.kudos.kudosManager.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the techstack database table.
 * 
 */
@Entity
@NamedQuery(name="Techstack.findAll", query="SELECT t FROM TechstackEntity t")
public class TechstackEntity implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String techstack;

	//bi-directional many-to-many association to Project
	@ManyToMany
	@JoinTable(
		name="project_techstack"
		, joinColumns={
			@JoinColumn(name="techstackid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="projectid")
			}
		)
	private List<ProjectEntity> projects;

	public TechstackEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTechstack() {
		return this.techstack;
	}

	public void setTechstack(String techstack) {
		this.techstack = techstack;
	}

	public List<ProjectEntity> getProjects() {
		return this.projects;
	}

	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}

}
