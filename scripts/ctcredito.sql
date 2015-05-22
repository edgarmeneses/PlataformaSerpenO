-- Nombre del archivo: ctcredito
-- Descripcion: archivo para la creacion de la tabla HISTORIAL_ROL
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE CREDITO (
id           INT(5)            NOT NULL,
monto        NUMERIC(9,2)      NOT NULL,
cuotas       INT(3)            NOT NULL,
usuario      INT(12)           NOT NULL,
banco        VARCHAR(11)       NOT NULL,
PRIMARY KEY(id)
);