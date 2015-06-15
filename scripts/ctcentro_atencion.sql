-- Nombre del archivo: ctcentro_atencion
-- Descripcion: archivo para la creacion de la tabla CENTRO_ATENCION
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 22 de mayo del 2015
-- Ultima modificacion por: 
-- Fecha ultima modificacion: 
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE centro_atencion(
nit                   VARCHAR(11)        NOT NULL,     
nombre                VARCHAR(30)        NOT NULL, 
direccion             VARCHAR(25)        NOT NULL,
telefono              VARCHAR(15)        NOT NULL,
PRIMARY KEY (nit)
);