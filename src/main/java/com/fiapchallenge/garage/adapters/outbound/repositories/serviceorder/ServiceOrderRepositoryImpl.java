package com.fiapchallenge.garage.adapters.outbound.repositories.serviceorder;

import com.fiapchallenge.garage.adapters.outbound.entities.ServiceOrderEntity;
import com.fiapchallenge.garage.adapters.outbound.entities.ServiceOrderServiceTypeEntity;
import com.fiapchallenge.garage.adapters.outbound.repositories.customer.JpaServiceOrderServiceTypeRepository;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderRepository;
import com.fiapchallenge.garage.domain.servicetype.ServiceType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ServiceOrderRepositoryImpl implements ServiceOrderRepository {

    private final JpaServiceOrderRepository jpaServiceOrderRepository;
    private final JpaServiceOrderServiceTypeRepository jpaServiceOrderServiceTypeRepository;

    public ServiceOrderRepositoryImpl(JpaServiceOrderRepository jpaServiceOrderRepository, JpaServiceOrderServiceTypeRepository jpaServiceOrderServiceTypeRepository) {
        this.jpaServiceOrderRepository = jpaServiceOrderRepository;
        this.jpaServiceOrderServiceTypeRepository = jpaServiceOrderServiceTypeRepository;
    }

    public ServiceOrder save(ServiceOrder serviceOrder) {
        ServiceOrderEntity serviceOrderEntity = new ServiceOrderEntity(serviceOrder);
        serviceOrderEntity = jpaServiceOrderRepository.save(serviceOrderEntity);

        for (ServiceType serviceType : serviceOrder.getServiceTypeList()) {
            saveOrderType(serviceOrderEntity.getId(), serviceType.getId());
        }

        return convertFromEntity(serviceOrderEntity);
    }

    private void saveOrderType(UUID serviceOrderId, UUID serviceTypeId) {
        ServiceOrderServiceTypeEntity entity = new ServiceOrderServiceTypeEntity(serviceOrderId, serviceTypeId);
        jpaServiceOrderServiceTypeRepository.save(entity);
    }

    private ServiceOrder convertFromEntity(ServiceOrderEntity serviceOrderEntity) {
        List<ServiceType> serviceTypeList = serviceOrderEntity.getServiceTypeList().stream().map(it ->
                new ServiceType(it.getId(), it.getValue(), it.getDescription())
        ).toList();

        return new ServiceOrder(
                serviceOrderEntity.getId(),
                serviceOrderEntity.getObservations(),
                serviceOrderEntity.getVehicleId(),
                serviceOrderEntity.getStatus(),
                serviceTypeList
        );
    }
}
