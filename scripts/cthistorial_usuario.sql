-- Nombre del archivo: cthistorial_usuario
-- Descripcion: archivo para la creacion de la tabla cthistorial_usuario
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Daniela Blanco
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:

CREATE TABLE HISTORIAL_USUARIO(

nickname                INT(6)          NOT NULL,
estado                  CHAR(1)         NOT NULL,
nombre                  VARCHAR(15)     NOT NULL,
apellido                VARCHAR(15)     NOT NULL,
telefono                VARCHAR(25)     NOT NULL, 
empresa                 VARCHAR(20)     NOT NULL,
salario                 NUMERIC(9,2)    NOT NULL,
afiliado                CHAR(1)         NOT NULL,
rol                     INT(2)          NOT NULL,
fondo                   VARCHAR(11)     NOT NULL,
PRIMARY KEY (nickname)
);