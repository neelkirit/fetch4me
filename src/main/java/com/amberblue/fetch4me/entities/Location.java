package com.amberblue.fetch4me.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Entity
@Table(name = "location")
public class Location {
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

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at", insertable = true, nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(name = "updated_at", insertable = true, nullable = false, updatable = true, columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date updatedAt;

    public Location() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (this.id == null){
            this.id = id;
        }
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
