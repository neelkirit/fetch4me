package com.amberblue.fetch4me.beans;

/**
 * Created by akash.mercer on 21-02-2016.
 */
public class ShipmentAccepted {

    private String shipperId;

    private String shipmentId;

    public ShipmentAccepted(){

    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }
}
