-- Nombre del archivo: ctconeccion
-- Descripcion: archivo para la creacion de la tabla coneccion
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 27 de abril del 2015
-- Ultima modificacion por: Eliana Ayala
-- Fecha ultima modificacion: 
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE coneccion(
id     		 INT(2)     	NOT NULL    AUTO_INCREMENT,
url     	 VARCHAR(50)  	NOT NULL,
puerto  	 INT(6)       	NOT NULL,
nombre_bd 	 VARCHAR(20) 	NOT NULL,
nit	   	 VARCHAR(11)	    NULL,
PRIMARY KEY(id)
);