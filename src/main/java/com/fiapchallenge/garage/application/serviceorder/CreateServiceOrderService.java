package com.fiapchallenge.garage.application.serviceorder;

import com.fiapchallenge.garage.application.serviceorder.command.CreateServiceOrderCommand;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.servicetype.ServiceType;
import com.fiapchallenge.garage.domain.servicetype.ServiceTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CreateServiceOrderService implements CreateServiceOrderUseCase {

    ServiceTypeRepository serviceTypeRepository;

    public CreateServiceOrderService(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @Override
    public ServiceOrder handle(CreateServiceOrderCommand command) {
        List<ServiceType> serviceTypesList = command.serviceTypeIdList()
                .stream()
                .map(id -> serviceTypeRepository.findByIdOrThrow(id))
                .toList();


        ServiceOrder serviceOrder = new ServiceOrder(command);
        serviceOrder.setServiceTypeList(serviceTypesList);
        return serviceOrder;
    }
}
