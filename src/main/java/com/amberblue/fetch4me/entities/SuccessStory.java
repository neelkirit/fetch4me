package com.amberblue.fetch4me.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Sagar Jain on 21-02-2016.
 */

@Entity
@Table(name = "success_story")
public class SuccessStory {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (this.id == null){
            this.id = id;
        }
    }

    @Column(name = "story_passage")
    private String storyPassage;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "shipper_name")
    private String shipperName;

    @Column(name = "created_at", insertable = true, nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(name = "updated_at", insertable = true, nullable = false, updatable = true, columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date updatedAt;

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

    public String getStoryPassage() {
        return storyPassage;
    }

    public void setStoryPassage(String storyPassage) {
        this.storyPassage = storyPassage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

}
