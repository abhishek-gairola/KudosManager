package com.kudos.kudosManager.model;

import javax.persistence.Column;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int kudoPoints;
    private String loginPassword;
    private long roleid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getKudoPoints() {
        return kudoPoints;
    }

    public void setKudoPoints(int kudoPoints) {
        this.kudoPoints = kudoPoints;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }
}
