package com.fiapchallenge.garage.application.vehicle;

import com.fiapchallenge.garage.domain.customer.CustomerRepository;
import com.fiapchallenge.garage.domain.vehicle.Vehicle;
import com.fiapchallenge.garage.domain.vehicle.VehicleRepository;
import com.fiapchallenge.garage.domain.vehicle.command.CreateVehicleCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateVehicleService implements CreateVehicleUseCase {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    public CreateVehicleService(VehicleRepository vehicleRepository, CustomerRepository customerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Vehicle handle(CreateVehicleCommand command) {
        Vehicle vehicle = new Vehicle(command);

        if (!customerRepository.exists(vehicle.getCustomerId())) {
            throw new IllegalArgumentException("Necessário informar um cliente válido.");
        }

        return vehicleRepository.save(vehicle);
    }
}
