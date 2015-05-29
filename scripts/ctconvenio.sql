-- Nombre del archivo: ctconvenios
-- Descripcion: creacion de la tabla CONVENIOS
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 28 de abril del 2015
-- Ultima modificacion por: Diana Gonzalez
-- Fecha ultima modificacion: 28 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE CONVENIO(
id                  INT(4)              NOT NULL,    
fondo			    VARCHAR(11)			NOT NULL,
entidad				INT(11)			NOT NULL,
beneficio 			NUMERIC(3,1)		NOT NULL,
PRIMARY KEY(id)
);