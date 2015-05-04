-- Nombre del archivo: ctArchivo
-- Descripcion: archivo para la creacion de la tabla @Table
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE FONDO (
nit              VARCHAR(11)        NOT NULL,
nombre           VARCHAR(15)        NOT NULL,
porcentaje       NUMERIC(2,1)       NOT NULL,
PRIMARY KEY(nit)   
);