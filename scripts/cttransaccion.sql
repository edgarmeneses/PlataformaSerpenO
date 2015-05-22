-- Nombre del archivo: cttransaccion
-- Descripcion: archivo para la creacion de la tabla @Table
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE TRANSACCION(
id                    INT(12)        NOT NULL,
tipo_transccion       VARCHAR(1)     NOT NULL,
monto                 NUMERIC(9,2)   NOT NULL,
fecha                 DATE           NOT NULL,
cuenta                NUMERIC(15)    NOT NULL,
PRIMARY KEY(id)
);