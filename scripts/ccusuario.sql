-- Nombre del archivo: ccusuario
-- Descripcion: archivo restricciones de la tabla USUARIO
-- Creado por: Eliana Ayala, Diana Gonzalez,Edgar Meneses, Daniela Blanco 
-- Fecha cracion: 26 de marzo del 2015
-- Ultima modificacion por: Edgar Meneses
-- Fecha ultima modificacion: 03 de abril del 2015
-- Revisado por:
-- Fecha Revision: 
ALTER TABLE USUARIO ADD (

CONSTRAINT us_fk_id     FOREIGN KEY (rol)      REFERENCES  rol(id),

CONSTRAINT us_fk_fon    FOREIGN KEY (fondo)   REFERENCES  fondo(nit),
CONSTRAINT us_fk_en     FOREIGN KEY (entidad_salud)      REFERENCES  entidad_salud(nit),

CONSTRAINT us_ck_est    CHECK (estado IN ('A'/*Activo*/, 'I'/*Inactivo*/)),
CONSTRAINT us_ck_tipaf  CHECK (afiliacion IN ('C'/*Cotizante*/, 'P'/*Pensionado*/))
);