package com.trionix.agrimartorder.entity;

import org.springframework.data.annotation.Id;

public class Delivery {
    @Id
    private String deliveryId;
    private String orderId;
    private String estimatedTime;
    private String Dstatus;

    public Delivery() {
    }

    public Delivery(String deliveryId,String orderId,  String estimatedTime, String dStatus) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.estimatedTime = estimatedTime;
        this.Dstatus = Dstatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getDstatus() {
        return Dstatus;
    }

    public void setDstatus(String Dstatus) {
        this.Dstatus = Dstatus;
    }
}
