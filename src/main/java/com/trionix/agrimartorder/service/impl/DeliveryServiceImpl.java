package com.trionix.agrimartorder.service.impl;

import com.trionix.agrimartorder.dto.DeliveryDto;
import com.trionix.agrimartorder.entity.Delivery;
import com.trionix.agrimartorder.repository.DeliveryRepository;
import com.trionix.agrimartorder.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Override
    public Delivery addDelivery(DeliveryDto deliveryDto) {
        Delivery delivery = new Delivery();

        delivery.setDeliveryId(deliveryDto.getDeliveryId());
        delivery.setOrderId(deliveryDto.getOrderId());
        delivery.setEstimatedTime(deliveryDto.getEstimatedTime());
        delivery.setDstatus(deliveryDto.getDstatus());
        return deliveryRepository.save(delivery);
    }
    @Override
    public void delete(String id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public Delivery updateOne(String id, DeliveryDto body) {
        return null;
    }

    @Override
    public void deleteOne(String id) {
    }

    @Override
    public Delivery findOne(String id) {
        var x = deliveryRepository.findById(id);
        if(x.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find order");
        return x.get();
    }

    @Override
    public List<Delivery> findAll(String id) {
        return null;
    }


}
