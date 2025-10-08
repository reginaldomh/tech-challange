package com.fiapchallenge.garage.application.vehicle;

import com.fiapchallenge.garage.domain.vehicle.Vehicle;
import com.fiapchallenge.garage.domain.vehicle.VehicleRequestDTO;

public interface CreateVehicleUseCase {

    Vehicle create(VehicleRequestDTO vehicleRequestDTO);
}
