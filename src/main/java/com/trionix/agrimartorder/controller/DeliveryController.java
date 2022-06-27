package com.trionix.agrimartorder.controller;

import com.trionix.agrimartorder.dto.DeliveryDto;
import com.trionix.agrimartorder.entity.Delivery;
import com.trionix.agrimartorder.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequiredArgsConstructor

public class DeliveryController {
    private final DeliveryService deliveryService;
    @PostMapping("/delivery")
    public ResponseEntity<Delivery> addDelivery(@RequestBody DeliveryDto deliveryDto) {
        var delivery = deliveryService.addDelivery(deliveryDto);
        return ResponseEntity.ok(delivery);
    }

    @GetMapping("/delivery")
    public List<Delivery> getAllDelivery (String id){
        return deliveryService.findAll(id);
    }

    @GetMapping("/delivery/{deliveryid}")
    public Delivery getOneDelivery( @PathVariable String deliveryid){
        return deliveryService.findOne(deliveryid);
    }

    @DeleteMapping("/delivery/{deliveryid}")
    public void deleteDelivery( @PathVariable String deliveryid){
        deliveryService.deleteOne(deliveryid);
    }
    @PutMapping("/delivery/{deliveryid}")
    public Delivery updateDelivery(@RequestBody DeliveryDto body, @PathVariable String deliveryid){
        return deliveryService.updateOne(deliveryid, body);
    }

}
