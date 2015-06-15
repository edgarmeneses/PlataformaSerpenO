-- Nombre del archivo: ctcuenta
-- Descripcion: archivo para la creacion de la tabla @Table
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE CUENTA (
numero             NUMERIC(15)           NOT NULL,
tipo_cuenta        VARCHAR(3)            NOT NULL,
usuario            INT(12)               NOT NULL,
banco              VARCHAR(11)           NOT NULL,
PRIMARY KEY(numero)
);