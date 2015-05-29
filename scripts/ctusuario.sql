-- Nombre del archivo: ctusuario
-- Descripcion: archivo para la creacion de la tabla USUARIO
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 27 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE USUARIO (
nickname              INT(12)            NOT NULL,     
pasword               VARCHAR(20)        NOT NULL, 
estado                CHAR(1)            DEFAULT 'A' NOT NULL,
respuesta             VARCHAR(50)        NOT NULL,
nombre                VARCHAR(15)        NOT NULL,
apellido              VARCHAR(15)        NOT NULL,
direccion             VARCHAR(25)        NULL,
telefono              VARCHAR(15)        NOT NULL,
empresa               VARCHAR(20)        NOT NULL,
salario               NUMERIC(9,2)       NOT NULL,
afiliado              CHAR(1)            NOT NULL,
rol		      INT(2)             NOT NULL,
fondo                 VARCHAR(11)        NOT NULL,
entidad_salud	      VARCHAR(11)        NOT NULL,
PRIMARY KEY (nickname)
);