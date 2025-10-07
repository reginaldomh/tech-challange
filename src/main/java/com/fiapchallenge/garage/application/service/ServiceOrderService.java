package com.fiapchallenge.garage.application.service;

import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderService {

    public void save(ServiceOrderRequestDTO serviceOrderRequestDTO) {
        ServiceOrder serviceOrder = new ServiceOrder(serviceOrderRequestDTO);


    }
}
