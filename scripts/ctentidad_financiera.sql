-- Nombre del archivo: ctentidad_financiera
-- Descripcion: archivo para la creacion de la tabla @Table
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE ENTIDAD_FINANCIERA (
nit          VARCHAR(11)        NOT NULL,
nombre       VARCHAR(15)        NOT NULL,
direccion    VARCHAR(25)        NOT NULL,
telefono     VARCHAR(15)        NOT NULL,
PRIMARY KEY(nit)
);