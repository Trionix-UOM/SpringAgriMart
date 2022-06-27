package com.trionix.agrimartorder.service;

import com.trionix.agrimartorder.dto.DeliveryDto;
import com.trionix.agrimartorder.dto.NewOrderDto;
import com.trionix.agrimartorder.entity.Delivery;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface DeliveryService {

    Delivery addDelivery(DeliveryDto deliveryDto);

    void delete(String id);

    Delivery updateOne(String id, DeliveryDto body);

    void deleteOne(String id);

    Delivery findOne(String id);

    List<Delivery> findAll(String id);





}
