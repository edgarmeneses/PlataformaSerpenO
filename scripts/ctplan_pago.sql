-- Nombre del archivo: ctArchivo
-- Descripcion: archivo para la creacion de la tabla @Table
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE PLAN_PAGO (
numero_cuota          INT(3)          NOT NULL AUTO_INCREMENT,
fecha_pago            DATE            NOT NULL,
monto                 NUMERIC(9,2)    NOT NULL,
credito               INT(5)          NOT NULL,
PRIMARY KEY(numero_cuota)
);