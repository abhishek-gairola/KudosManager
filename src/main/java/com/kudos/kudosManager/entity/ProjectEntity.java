package com.kudos.kudosManager.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="projects")
public class ProjectEntity implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(name="duration_hrs")
	private int durationHrs;

	@Column(name="kudo_points")
	private int kudoPoints;

	private String name;

	private String status;

	@Column(name="type_of_tech")
	private String typeOfTech;

	//bi-directional many-to-many association to Techstack
	@ManyToMany(mappedBy="projects")
	private List<TechstackEntity> techstacks;

	//bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy="project")
	private List<ProjectUserEntity> projectUsers;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="project_manager_id")
	private UserEntity user;

	public ProjectEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationHrs() {
		return this.durationHrs;
	}

	public void setDurationHrs(int durationHrs) {
		this.durationHrs = durationHrs;
	}

	public int getKudoPoints() {
		return this.kudoPoints;
	}

	public void setKudoPoints(int kudoPoints) {
		this.kudoPoints = kudoPoints;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypeOfTech() {
		return this.typeOfTech;
	}

	public void setTypeOfTech(String typeOfTech) {
		this.typeOfTech = typeOfTech;
	}

	public List<TechstackEntity> getTechstacks() {
		return this.techstacks;
	}

	public void setTechstacks(List<TechstackEntity> techstacks) {
		this.techstacks = techstacks;
	}

	public List<ProjectUserEntity> getProjectUsers() {
		return this.projectUsers;
	}

	public void setProjectUsers(List<ProjectUserEntity> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public ProjectUserEntity addProjectUser(ProjectUserEntity projectUser) {
		getProjectUsers().add(projectUser);
		projectUser.setProject(this);

		return projectUser;
	}

	public ProjectUserEntity removeProjectUser(ProjectUserEntity projectUser) {
		getProjectUsers().remove(projectUser);
		projectUser.setProject(null);

		return projectUser;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
