/*
Empresa        :  EGCC
Software       :  Sistema de Condominios
DBMS           :  MySQL Server
Base de Datos  :  MICONDOMINIO
Script         :  Crea el esquema OBLIGACIONES
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Telefono       :  (511) 9966-64457
Email          :  gcoronelc@gmail.com
Sitio Web      :  http://www.desarrollasoftware.com
Blog           :  http://gcoronelc.blogspot.com
*/

-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE MICONDOMINIO;
SET NAMES "UTF8";


-- =============================================
-- Creación de tablas
-- =============================================

CREATE TABLE TOBLIGACION
(
	IDTOBLIGACION        INTEGER NOT NULL,
	NOMBRE               VARCHAR(50) NOT NULL,
	PRIMARY KEY PK_TOBLIGACION (IDTOBLIGACION)
) ENGINE = 'INNODB';



CREATE TABLE RECIBO
(
	IDRECIBO             INTEGER AUTO_INCREMENT,
	IDTOBLIGACION        INTEGER NOT NULL,
	ANIO                 INTEGER NOT NULL,
	MES                  INTEGER NOT NULL,
	FVENCE               DATE NULL,
	IMPORTE              INTEGER NULL,
	DESCRIPCION          VARCHAR(200) NOT NULL,
	PRIMARY KEY PK_RECIBO (IDRECIBO),
	FOREIGN KEY FK_RECIBO_TOBLIGACION(IDTOBLIGACION) 
		REFERENCES TOBLIGACION (IDTOBLIGACION)
) ENGINE = 'INNODB';



CREATE TABLE OBLIGACION
(
	IDOBLIGACION         INTEGER AUTO_INCREMENT,
	IDTOBLIGACION        INTEGER NOT NULL,
	IDINMUEBLE           INTEGER NOT NULL,
	ANIO                 INTEGER NULL,
	MES                  INTEGER NULL,
	FVENCE               DATE NULL,
	IMPORTE              INTEGER NULL,
	FECHA                DATE NOT NULL,
	AUDIDPERSONA         INTEGER NOT NULL,
	PRIMARY KEY PK_OBLIGACION(IDOBLIGACION),
	FOREIGN KEY FK_OBLIGACION_TOBLIGACION (IDTOBLIGACION) 
		REFERENCES TOBLIGACION (IDTOBLIGACION),
	FOREIGN KEY FK_OBLIGACION_INMUEBLE(IDINMUEBLE) 
		REFERENCES INMUEBLE (IDINMUEBLE),
	FOREIGN KEY FK_OBLIGACION_PERSONA (AUDIDPERSONA) 
		REFERENCES PERSONA (IDPERSONA)
) ENGINE = 'INNODB';


-- =============================================
-- Datos
-- =============================================


- Tabla TOBLIGACION

INSERT INTO TOBLIGACION(IDTOBLIGACION,NOMBRE) VALUES
(1,'AGUA'),
(2,'MANTENIMIENTO'),
(3,'OTROS');




