INSERT INTO admins (email, name)
VALUES ('admin@unicauca.edu.co', 'Admin Principal')
    ON CONFLICT (email) DO NOTHING;