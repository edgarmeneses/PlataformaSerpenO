-- Nombre del archivo: ccrol
-- Descripcion: archivo restricciones de la tabla ROL
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Revision: 
ALTER TABLE rol ADD (
constraint rol_UQ_nom UNIQUE(nombre)
);