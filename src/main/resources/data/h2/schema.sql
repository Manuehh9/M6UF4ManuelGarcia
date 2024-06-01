-- src/main/resources/data/h2/schema.sql
CREATE TABLE topos (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    precio DOUBLE,
    familia VARCHAR(255),
    fecha_alta DATE,
    descatalogado BOOLEAN
);
