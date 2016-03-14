package com.amberblue.fetch4me.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Entity
@Table(name = "guest")
public class Guest {

    @PrePersist
    private void ensureId(){
        this.setId(UUID.randomUUID().toString());

        if(getCreatedAt() == null){
            setCreatedAt(new Date());
        }

        if(getUpdatedAt() == null){
            setUpdatedAt(new Date());
        }
    }

    @Id
    @Column(name="id", insertable=true, unique=true, nullable=false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "relation")
    private String relation;

    @Column(name = "created_at", insertable = true, nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(name = "updated_at", insertable = true, nullable = false, updatable = true, columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date updatedAt;

    public Guest() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (this.id == null){
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
