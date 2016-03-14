package com.amberblue.fetch4me.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Entity
@Table(name = "shipment")
public class Shipment {

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

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "drop_address")
    private String dropAddress;

    @Column(name = "drop_proof")
    private String dropProof;

    @Column(name = "pickup_time")
    private Date pickupTime;

    @Column(name = "drop_time")
    private Date dropTime;

    @Column(name = "item_price")
    private Double itemPrice;

    @Column(name = "urgent")
    private boolean urgent;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "processed")
    private boolean processed;

    @Transient
    private int transientStatusType;

    @Column(name = "created_at", insertable = true, nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(name = "updated_at", insertable = true, nullable = false, updatable = true, columnDefinition = "datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipper")
    private Shipper shipper;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipment_type")
    private ShipmentType shipmentType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pickup_guest")
    private Guest pickupGuest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dropoff_guest")
    private Guest dropoffGuest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pickup_location")
    private Location pickupLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dropoff_location")
    private Location dropoffLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipment_status")
    private ShipmentStatus shipmentStatus;

    public Shipment() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (this.id == null){
            this.id = id;
        }
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
    }

    public String getDropProof() {
        return dropProof;
    }

    public void setDropProof(String dropProof) {
        this.dropProof = dropProof;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Date getDropTime() {
        return dropTime;
    }

    public void setDropTime(Date dropTime) {
        this.dropTime = dropTime;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public int getTransientStatusType() {
        return transientStatusType;
    }

    public void setTransientStatusType(int transientStatusType) {
        this.transientStatusType = transientStatusType;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public ShipmentType getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
    }

    public Guest getPickupGuest() {
        return pickupGuest;
    }

    public void setPickupGuest(Guest pickupGuest) {
        this.pickupGuest = pickupGuest;
    }

    public Guest getDropoffGuest() {
        return dropoffGuest;
    }

    public void setDropoffGuest(Guest dropoffGuest) {
        this.dropoffGuest = dropoffGuest;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(Location dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Shipment)){
            return false;
        } else {
            return ((Shipment) obj).getId().equals(id);
        }
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
