-- Nombre del archivo: ctentidad_salud
-- Descripcion: archivo para la creacion de la tabla servicios
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 22 de Mayo del 2015
-- Ultima modificacion por: Eliana Ayala
-- Fecha ultima modificacion: 
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE entidad_salud(
nit    		 VARCHAR(11)   	NOT NULL,
nombre    	 VARCHAR(30)  	NOT NULL,
direccion   	 VARCHAR(25)    NOT NULL,  
telefono         VARCHAR(15)    NOT NULL,
catalogo         INT            NOT NULL,
PRIMARY KEY(nit)
);