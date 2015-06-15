-- Nombre del archivo: cccatalogo
-- Descripcion: archivo restricciones de la tabla centro_atencion
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 24 de mayo del 2015
-- Ultima modificacion por: 
-- Fecha ultima modificacion: 
-- Revisado por:
-- Fecha Revision: 
ALTER TABLE catalogo ADD (
CONSTRAINT us_fk_ser     FOREIGN KEY (servicio)        REFERENCES  servicio(id),

CONSTRAINT us_fk_cen    FOREIGN KEY (centro_atencion)  REFERENCES  centro_atencion(nit)

);