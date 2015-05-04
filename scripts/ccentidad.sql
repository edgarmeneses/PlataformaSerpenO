-- Nombre del archivo: ccentidades
-- Descripcion: archivo restricciones de la tabla ENTIDADES
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 28 de abril del 2015
-- Ultima modificacion por: Diana Gonzalez 
-- Fecha ultima modificacion: 28 de abril del 2015
-- Revisado por:
-- Fecha Revision: 

ALTER TABLE ENTIDAD ADD (

CONSTRAINT ent_fk_id FOREIGN KEY (conneccion) REFERENCES coneccion(id),
CONSTRAINT ent_ck_tipoe CHECK (tipo_entidad IN ('E' /*educacion*/, 'V' /*vivienda*/, 'T' /*turismo*/ ))

);