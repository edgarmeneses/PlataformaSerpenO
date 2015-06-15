-- Nombre del archivo: cctransaccion
-- Descripcion: archivo restricciones de la tabla @TABLA
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Revision: 

ALTER TABLE TRANSACCION ADD (
CONSTRAINT tran_FK_cue FOREIGN KEY (cuenta) REFERENCES cuenta(numero),
CONSTRAINT tran_CK_tip CHECK (tipo_transaccion IN ('R'/*retiro*/, 'I'/*ingreso*/))
);