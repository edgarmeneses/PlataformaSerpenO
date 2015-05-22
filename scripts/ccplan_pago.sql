-- Nombre del archivo: nombreArchivo
-- Descripcion: archivo restricciones de la tabla @TABLA
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Revision: 

ALTER TABLE PLAN_PAGO ADD (
CONSTRAINT plan_FK_cred FOREIGN KEY (credito) REFERENCES credito(id)
);