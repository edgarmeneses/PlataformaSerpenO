-- Nombre del archivo: ctservicios
-- Descripcion: archivo para la creacion de la tabla servicios
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 21 de Mayo del 2015
-- Ultima modificacion por: Eliana Ayala
-- Fecha ultima modificacion: 
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE servicio(
id     		 INT    	NOT NULL    AUTO_INCREMENT,
nombre    	 VARCHAR(30)  	NOT NULL,
costo    	 NUMERIC(9,2)   NOT NULL,
descripcion      VARCHAR(100)   NOT NULL,
PRIMARY KEY(id)
);