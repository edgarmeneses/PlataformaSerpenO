-- Nombre del archivo: cthistorial_rol
-- Descripcion: archivo para la creacion de la tabla HISTORIAL_ROL
-- Creado por: Eliana Ayala, Diana Gonzales, Edgar Meneses, Daniela Blanco
-- Fecha creacion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Ultima Revision:
CREATE TABLE HISTORIAL_ROL (
id                    INT(5)             NOT NULL      AUTO_INCREMENT,
rol                   INT(2)             NOT NULL,     
nombre                VARCHAR(15)        NOT NULL,
PRIMARY KEY (id)
);