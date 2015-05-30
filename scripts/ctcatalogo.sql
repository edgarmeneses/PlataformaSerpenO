-- Nombre del archivo: ctcatalogo
-- Descripcion: archivo para la creacion de la tabla catalogo
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 24 de Mayo del 2015
-- Ultima modificacion por: Eliana Ayala
-- Fecha ultima modificacion: 
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE catalogo(
id     		 INT    	NOT NULL    AUTO_INCREMENT,
descuento    	 NUMERIC(3,1)  	NOT NULL,
servicio         INT		NOT NULL,
centro_atencion  VARCHAR(11)    NOT NULL,
PRIMARY KEY(id)
);