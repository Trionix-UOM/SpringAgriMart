package com.trionix.agrimartorder.dto;

import org.springframework.data.annotation.Id;

public class DeliveryDto {
    @Id
    private String deliveryId;
    private String orderId;
    private String estimatedTime;
    private String Dstatus;

    public DeliveryDto() {
    }

    public DeliveryDto(String deliveryId,String orderId,  String estimatedTime, String dStatus) {
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