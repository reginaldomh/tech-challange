package com.fiapchallenge.garage.adapters.inbound.controller.vehicle;

import com.fiapchallenge.garage.application.vehicle.CreateVehicleUseCase;
import com.fiapchallenge.garage.domain.vehicle.Vehicle;
import com.fiapchallenge.garage.domain.vehicle.VehicleRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController implements VehicleControllerOpenApiSpec {

    private final CreateVehicleUseCase createVehicleUseCase;

    public VehicleController(CreateVehicleUseCase createVehicleUseCase) {
        this.createVehicleUseCase = createVehicleUseCase;
    }

    @PostMapping
    @Override
    public ResponseEntity<Vehicle> create(@Valid @RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = createVehicleUseCase.create(vehicleRequestDTO);
        return ResponseEntity.ok(vehicle);
    }
}
