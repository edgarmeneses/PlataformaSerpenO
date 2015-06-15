-- Nombre del archivo: cccredito
-- Descripcion: archivo restricciones de la tabla @TABLA
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Revision: 

ALTER TABLE CREDITO ADD (
CONSTRAINT cre_FK_us    FOREIGN KEY (usuario) REFERENCES usuario(nickname),
CONSTRAINT cre_FK_ent   FOREIGN KEY (banco) REFERENCES entidad_financiera(nit)
);