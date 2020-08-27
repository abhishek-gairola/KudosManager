package com.kudos.kudosManager.model;


import com.kudos.kudosManager.entity.ProjectUserEntity;
import com.kudos.kudosManager.entity.UserEntity;

import javax.persistence.*;
import java.util.List;


public class Project {
    private Long id;
    private String description;
    private int durationHrs;
    private int kudoPoints;
    private String name;
    private String status;
    private String typeOfTech;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationHrs() {
        return durationHrs;
    }

    public void setDurationHrs(int durationHrs) {
        this.durationHrs = durationHrs;
    }

    public int getKudoPoints() {
        return kudoPoints;
    }

    public void setKudoPoints(int kudoPoints) {
        this.kudoPoints = kudoPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeOfTech() {
        return typeOfTech;
    }

    public void setTypeOfTech(String typeOfTech) {
        this.typeOfTech = typeOfTech;
    }

}
