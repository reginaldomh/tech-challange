ALTER TABLE quote ADD COLUMN customer_id UUID;

-- Update existing quotes with customer_id from vehicle
UPDATE quote 
SET customer_id = v.customer_id 
FROM service_order so 
JOIN vehicle v ON so.vehicle_id = v.id 
WHERE quote.service_order_id = so.id;

-- Make customer_id NOT NULL after updating existing data
ALTER TABLE quote ALTER COLUMN customer_id SET NOT NULL;