package com.fiapchallenge.garage.adapters.outbound.repositories.serviceorder;

import com.fiapchallenge.garage.adapters.outbound.entities.ServiceOrderEntity;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderRepository;
import org.springframework.stereotype.Component;

@Component
public class ServiceOrderRepositoryImpl implements ServiceOrderRepository {

    private final JpaServiceOrderRepository jpaServiceOrderRepository;

    public ServiceOrderRepositoryImpl(JpaServiceOrderRepository jpaServiceOrderRepository) {
        this.jpaServiceOrderRepository = jpaServiceOrderRepository;
    }

    @Override
    public ServiceOrder save(ServiceOrder serviceOrder) {
        ServiceOrderEntity serviceOrderEntity = new ServiceOrderEntity(serviceOrder);
        serviceOrderEntity = jpaServiceOrderRepository.save(serviceOrderEntity);

        return new ServiceOrder(
                serviceOrderEntity.getId(),
                serviceOrderEntity.getVehicleId(),
                serviceOrderEntity.getDescription(),
                serviceOrderEntity.getStatus()
        );
    }
}
