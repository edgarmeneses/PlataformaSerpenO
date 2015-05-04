-- Nombre del archivo: ccconvenios
-- Descripcion: archivo restricciones de la tabla CONVENIOS
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 28 de abril del 2015
-- Ultima modificacion por: Diana Gonzalez 
-- Fecha ultima modificacion: 28 de abril del 2015
-- Revisado por:
-- Fecha Revision: 

ALTER TABLE CONVENIO ADD (

CONSTRAINT con_fk_nit FOREIGN KEY (fondo) REFERENCES fondo(nit),
CONSTRAINT con_fk_nite FOREIGN KEY (entidad) REFERENCES entidad(id)
);