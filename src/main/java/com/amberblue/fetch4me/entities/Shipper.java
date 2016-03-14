package com.amberblue.fetch4me.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Entity
@Table(name = "shipper")
public class Shipper {

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

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "profile_pic")
    private String profilePic;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "security_deposit")
    private Double securityDeposit;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "starting_point_latitude")
    private Double startPointLatitude;

    @Column(name = "starting_point_longitude")
    private Double startPointLongitude;

    @Column(name = "end_point_latitude")
    private Double endPointLatitude;

    @Column(name = "end_point_longitude")
    private Double endPointLongitude;

    @Column(name = "rating_count")
    private Integer ratingCount;

    @Column(name = "is_online")
    private boolean isOnline;

    @Column(name = "identity_proof")
    private String identityProof;

    @Column(name = "created_at", insertable = true, nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(name = "updated_at", insertable = true, nullable = false, updatable = true, columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_type")
    private Address vehicleType;

    public Shipper() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (this.id == null){
            this.id = id;
        }
    }

    public  void setStartPointLatitude(Double startPointLatitude){
        this.startPointLatitude = startPointLatitude;
    }

    public double getStartPointLatitude(){
        return startPointLatitude;
    }

    public  void setStartPointLongitude(Double startPointLongitude){
        this.startPointLongitude = startPointLongitude;
    }

    public double getStartPointLongitude(){
        return startPointLongitude;
    }

    public  void setEndPointLatitude(Double endPointLatitude){
        this.endPointLatitude = endPointLatitude;
    }

    public double getEndPointLatitude(){
        return endPointLatitude;
    }

    public  void setEndPointLongitude(Double endPointLongitude){
        this.endPointLongitude = endPointLongitude;
    }

    public double getEndPointLongitude(){
        return endPointLongitude;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Double getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(Double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getIdentityProof() {
        return identityProof;
    }

    public void setIdentityProof(String identityProof) {
        this.identityProof = identityProof;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Address getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Address vehicleType) {
        this.vehicleType = vehicleType;
    }
}
