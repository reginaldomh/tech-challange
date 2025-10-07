package com.fiapchallenge.garage.integration;

import com.fiapchallenge.garage.adapters.outbound.entities.CustomerEntity;
import com.fiapchallenge.garage.adapters.outbound.entities.ServiceOrderEntity;
import com.fiapchallenge.garage.adapters.outbound.entities.VehicleEntity;
import com.fiapchallenge.garage.adapters.outbound.repositories.customer.JpaCustomerRepository;
import com.fiapchallenge.garage.adapters.outbound.repositories.serviceorder.JpaServiceOrderRepository;
import com.fiapchallenge.garage.adapters.outbound.repositories.vehicle.JpaVehicleRepository;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceOrderIntegrationTest extends BaseIntegrationTest {

    private final MockMvc mockMvc;
    private final JpaVehicleRepository vehicleRepository;
    private final JpaCustomerRepository customerRepository;
    private final JpaServiceOrderRepository serviceOrderRepository;

    @Autowired
    public ServiceOrderIntegrationTest(MockMvc mockMvc, JpaVehicleRepository vehicleRepository, JpaCustomerRepository customerRepository, JpaServiceOrderRepository serviceOrderRepository) {
        this.mockMvc = mockMvc;
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
        this.serviceOrderRepository = serviceOrderRepository;
    }

    @Test
    @DisplayName("Deve criar uma ordem de serviço vinculada a um cliente e persistir")
    void shouldCreateVehicleAndPersistToDatabase() throws Exception {
        UUID customerId = createCustomer();
        UUID vehicleId = createVehicle(customerId);

        String serviceOrderJson = """
            {
              "description": "Troca de óleo e filtro",
              "vehicleId": "%s"
            }
        """.formatted(vehicleId.toString());

        mockMvc.perform(post("/service-orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(serviceOrderJson)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Troca de óleo e filtro"))
                .andExpect(jsonPath("$.vehicleId").value(vehicleId.toString()));

        ServiceOrderEntity savedServiceOrder = serviceOrderRepository.findAll().getLast();
        assertThat(savedServiceOrder.getDescription()).isEqualTo("Troca de óleo e filtro");
        assertThat(savedServiceOrder.getStatus()).isEqualTo(ServiceOrderStatus.CREATED);
        assertThat(savedServiceOrder.getVehicleId()).isEqualTo(vehicleId);
        assertThat(savedServiceOrder.getId()).isNotNull();
    }

    private UUID createVehicle(UUID customerId) throws Exception {
        String vehicleJson = """
            {
              "model": "Civic",
              "brand": "Honda",
              "licensePlate": "ABC1D23",
              "color": "Prata",
              "year": 2020,
              "observations": "Troca de óleo recente",
              "customerId": "%s"
            }
        """.formatted(customerId.toString());

        mockMvc.perform(post("/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vehicleJson)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("Civic"))
                .andExpect(jsonPath("$.brand").value("Honda"))
                .andExpect(jsonPath("$.licensePlate").value("ABC1D23"));

        VehicleEntity savedVehicle = vehicleRepository.findAll().getLast();
        assertThat(savedVehicle.getModel()).isEqualTo("Civic");
        assertThat(savedVehicle.getBrand()).isEqualTo("Honda");
        assertThat(savedVehicle.getLicensePlate()).isEqualTo("ABC1D23");
        assertThat(savedVehicle.getColor()).isEqualTo("Prata");
        assertThat(savedVehicle.getYear()).isEqualTo(2020);
        assertThat(savedVehicle.getObservations()).isEqualTo("Troca de óleo recente");
        assertThat(savedVehicle.getCustomerId()).isEqualTo(customerId);
        assertThat(savedVehicle.getId()).isNotNull();

        return savedVehicle.getId();
    }

    private UUID createCustomer() throws Exception {
        String customerJson = """
                {
                  "name": "Pix JR",
                  "email": "pixjr@example.com",
                  "phone": "9871111"
                }
                """;

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pix JR"))
                .andExpect(jsonPath("$.email").value("pixjr@example.com"))
                .andExpect(jsonPath("$.phone").value("9871111"));

        CustomerEntity savedCustomer = customerRepository.findAll().getLast();
        assertThat(savedCustomer.getName()).isEqualTo("Pix JR");
        assertThat(savedCustomer.getEmail()).isEqualTo("pixjr@example.com");
        assertThat(savedCustomer.getPhone()).isEqualTo("9871111");
        assertThat(savedCustomer.getId()).isNotNull();

        return savedCustomer.getId();
    }
}
