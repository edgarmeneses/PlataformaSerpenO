-- Nombre del archivo: ccconeccion
-- Descripcion: archivo restricciones de la tabla coneccion
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 27 de abril del 2015
-- Ultima modificacion por: Eliana Ayala
-- Fecha ultima modificacion: 
-- Revisado por:
-- Fecha Revision: 
ALTER TABLE CONECCION ADD (
CONSTRAINT con_fk_entidad FOREIGN KEY (nit) REFERENCES  entidad(id)
);