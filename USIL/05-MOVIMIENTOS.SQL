/*
Empresa        :  EGCC
Software       :  Sistema de Condominios
DBMS           :  MySQL Server
Base de Datos  :  MICONDOMINIO
Script         :  Crea el esquema MOVIMIENTOS
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


CREATE TABLE TMOVIMIENTO
(
	IDTMOVIMIENTO        INTEGER NOT NULL,
	NOMBRE               VARCHAR(50) NOT NULL,
	ACCION               VARCHAR(20) NOT NULL CHECK ( ACCION IN ('INGRESO','SALIDA') ),
	PRIMARY KEY PK_TMOVIMIENTO(IDTMOVIMIENTO)
) ENGINE = 'INNODB';



CREATE TABLE MOVIMIENTO
(
	IDMOVIMIENTO         INTEGER AUTO_INCREMENT,
	IDINMUEBLE           INTEGER NOT NULL,
	IDOBLIGACION         INTEGER NULL,
	IDTMOVIMIENTO        INTEGER NOT NULL,
	FECHA                DATE NOT NULL,
	IMPORTE              NUMERIC(12,2) NOT NULL,
	DESCRIPCION          VARCHAR(200) NOT NULL,
	AUDIDPERSONA         INTEGER NOT NULL,
	PRIMARY KEY (IDMOVIMIENTO),
	FOREIGN KEY FK_MOVIMIENTO_INMUEBLE(IDINMUEBLE) 
		REFERENCES INMUEBLE (IDINMUEBLE),
	FOREIGN KEY FK_MOVIMIENTO_OBLIGACION(IDOBLIGACION) 
		REFERENCES OBLIGACION (IDOBLIGACION),
	FOREIGN KEY FK_MOVIMIENTO_TMOVIMIENTO (IDTMOVIMIENTO) 
		REFERENCES TMOVIMIENTO (IDTMOVIMIENTO),
	FOREIGN KEY FK_MOVIMIENTO_PERSONA (AUDIDPERSONA) 
		REFERENCES PERSONA (IDPERSONA)
) ENGINE = 'INNODB';


