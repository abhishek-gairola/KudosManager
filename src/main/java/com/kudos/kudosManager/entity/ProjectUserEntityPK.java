package com.kudos.kudosManager.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the project_user database table.
 */
@Embeddable
public class ProjectUserEntityPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final Long serialVersionUID = 1L;

    @Column(insertable = false, updatable = false)
    private Long projectid;

    @Column(insertable = false, updatable = false)
    private Long userid;

    public ProjectUserEntityPK() {
    }

    public Long getProjectid() {
        return this.projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public Long getUserid() {
        return this.userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProjectUserEntityPK)) {
            return false;
        }
        ProjectUserEntityPK castOther = (ProjectUserEntityPK) other;
        return
                (this.projectid == castOther.projectid)
                        && (this.userid == castOther.userid);
    }
}
