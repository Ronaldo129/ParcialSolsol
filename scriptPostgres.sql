-- Crear la base de datos
CREATE DATABASE bd_articulo;

-- Conectarse a la base (solo si lo ejecutas en psql manualmente)
\c bd_articulo;

-- Crear la tabla articulo
CREATE TABLE articulo (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

-- Insertar algunos datos iniciales
INSERT INTO articulo (nombre, precio) VALUES 
('Laptop Lenovo', 4500.50),
('Mouse Logitech', 120.00),
('Monitor Samsung', 900.00);
