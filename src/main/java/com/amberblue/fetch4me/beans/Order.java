package com.amberblue.fetch4me.beans;

import com.amberblue.fetch4me.entities.Guest;

/**
 * Created by akash.mercer on 20-02-2016.
 */
public class Order {

    private String userId;

    private String pickupTime;

    private String deliveryTime;

    private String pickupAddress;

    private String dropoffAddress;

    private int orderType;

    private double productPrice;

    private boolean urgent;

    private Guest pickupGuest;

    private Guest dropoffGuest;

    public Order(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDropoffAddress() {
        return dropoffAddress;
    }

    public void setDropoffAddress(String dropoffAddress) {
        this.dropoffAddress = dropoffAddress;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
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
}
