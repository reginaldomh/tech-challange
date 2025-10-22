package com.fiapchallenge.garage.domain.customer;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerRepository {

    Customer save(Customer customer);

    boolean exists(UUID id);

    Optional<Customer> findById(UUID id);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByFilters(String name, String email, String cpfCnpj, Pageable pageable);

    void deleteById(UUID id);
}
