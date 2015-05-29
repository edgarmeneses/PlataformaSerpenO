-- Nombre del archivo: ccentidad_salud
-- Descripcion: archivo restricciones de la tabla entidad_salud
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 22 de mayo del 2015
-- Ultima modificacion por: 
-- Fecha ultima modificacion: 
-- Revisado por:
-- Fecha Revision: 
ALTER TABLE ENTIDAD_SALUD ADD (
  CONSTRAINT us_fk_cat     FOREIGN KEY (catalogo)        REFERENCES  catalogo(id)
);