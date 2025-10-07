CREATE TABLE service_order
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    description VARCHAR(255) NOT NULL,
    status      VARCHAR(50)  NOT NULL,
    vehicle_id  UUID         NOT NULL,

    CONSTRAINT fk_service_order_vehicle
        FOREIGN KEY (vehicle_id)
            REFERENCES vehicle (id)
            ON DELETE CASCADE
);