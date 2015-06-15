-- Nombre del archivo: nombreArchivo
-- Descripcion: archivo restricciones de la tabla @TABLA
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Revision: 

ALTER TABLE CUENTA ADD (
CONSTRAINT cue_FK_us FOREIGN KEY (usuario) REFERENCES usuario(nickname),
CONSTRAINT cue_FK_enfin FOREIGN KEY (banco) REFERENCES entidad_financiera(nit),
CONSTRAINT cue_CK_tipcue CHECK(tipo_cuenta IN ('CDT'/*certificado de depocito*/,'COR'/*cuenta corriente*/,'AHO'/*cuenta de ahorros*/,'COL'/*cuenta de cartera colctiva*/))
);