package com.kudos.kudosManager.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 */
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String firstName;

    @Column(name = "kudo_points")
    private int kudoPoints;

    private String lastName;

    @Column(name = "login_password")
    private String loginPassword;

    private Long roleid;

    //bi-directional many-to-one association to ProjectUser
    @OneToMany(mappedBy = "user")
    private List<ProjectUserEntity> projectUsers;

    //bi-directional many-to-one association to Project
    @OneToMany(mappedBy = "user")
    private List<ProjectEntity> projects;

    public UserEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getKudoPoints() {
        return this.kudoPoints;
    }

    public void setKudoPoints(int kudoPoints) {
        this.kudoPoints = kudoPoints;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Long getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public List<ProjectUserEntity> getProjectUsers() {
        return this.projectUsers;
    }

    public void setProjectUsers(List<ProjectUserEntity> projectUsers) {
        this.projectUsers = projectUsers;
    }

    public ProjectUserEntity addProjectUser(ProjectUserEntity projectUser) {
        getProjectUsers().add(projectUser);
        projectUser.setUser(this);

        return projectUser;
    }

    public ProjectUserEntity removeProjectUser(ProjectUserEntity projectUser) {
        getProjectUsers().remove(projectUser);
        projectUser.setUser(null);

        return projectUser;
    }

    public List<ProjectEntity> getProjects() {
        return this.projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }

    public ProjectEntity addProject(ProjectEntity project) {
        getProjects().add(project);
        project.setUser(this);

        return project;
    }

    public ProjectEntity removeProject(ProjectEntity project) {
        getProjects().remove(project);
        project.setUser(null);

        return project;
    }

}
