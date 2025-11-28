-- Insert initial admin user (password: admin123)
-- BCrypt hash for 'admin123' with strength 10
INSERT INTO "user" (id, fullname, email, password, role) 
VALUES (
    gen_random_uuid(),
    'Administrator',
    'admin@garage.com',
    '$2a$10$N.zmdr9k7uOIQQP4fkBOKOxEJDmxqOpXdHM6ty6SuoTGGZqff2eim',
    'ADMIN'
) ON CONFLICT (email) DO NOTHING;