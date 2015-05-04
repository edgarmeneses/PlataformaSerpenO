-- Nombre del archivo: ctentidad
-- Descripcion: creacion de la tabla ENTIDAD
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 28 de abril del 2015
-- Ultima modificacion por: Diana Gonzalez
-- Fecha ultima modificacion: 28 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE ENTIDAD(
id		   INT(11)        NOT NULL AUTO_INCREMENT,
nit	        VARCHAR(11)	 NOT NULL,
conneccion	   INT(2)		 NULL, 
nombre 	   VARCHAR(15)			NOT NULL,
tipo_entidad	CHAR(1)		    	NOT NULL,	
descripcion 	VARCHAR(30) 		NOT NULL,
PRIMARY KEY(id)
);