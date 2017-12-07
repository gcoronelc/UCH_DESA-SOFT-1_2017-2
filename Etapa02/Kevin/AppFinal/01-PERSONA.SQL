/*
Empresa        :  EGCC
Software       :  Sistema de Condominios
DBMS           :  MySQL Server
Base de Datos  :  MICONDOMINIO
Script         :  Crea el esquema PERSONA
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

CREATE TABLE TPERSONA
(
	IDTPERSONA           INTEGER AUTO_INCREMENT,
	NOMBRE               VARCHAR(30) NOT NULL,
	CONSTRAINT PK_TPERSONA PRIMARY KEY (IDTPERSONA)
) ENGINE = 'INNODB';



CREATE TABLE PERSONA
(
	IDPERSONA            INTEGER AUTO_INCREMENT,
	IDTPERSONA           INTEGER NOT NULL,
	NOMBRE               VARCHAR(50) NOT NULL,
	APELLIDO             VARCHAR(50) NOT NULL,
	DNI                  VARCHAR(15) NOT NULL,
	TELEFONO             VARCHAR(50) NOT NULL,
	DIRECCION            VARCHAR(100) NOT NULL,
	EMAIL                VARCHAR(60) NOT NULL,
	CONSTRAINT PK_PERSONA PRIMARY KEY (IDPERSONA),
	CONSTRAINT PK_PERSONA 
		FOREIGN KEY FK_PERSONA_TPERSONA (IDTPERSONA) 
		REFERENCES TPERSONA (IDTPERSONA)
) ENGINE = 'INNODB';


-- =============================================
-- Carga de Datos
-- =============================================

-- TIPOS DE PERSONAS
INSERT INTO TPERSONA(IDTPERSONA,NOMBRE) VALUES
(1,'INMUEBLE'),
(2,'PROPIETARIO'),
(3,'USUARIO'),
(4,'EX-PROPIETARIO');

-- PERSONAS
INSERT INTO PERSONA(IDPERSONA,IDTPERSONA,NOMBRE,APELLIDO,DNI,
TELEFONO,DIRECCION,EMAIL)VALUES
(1,1,'INMUEBLE','INMUEBLE','11111111','222222222','MI CASA','MI CORREO'),
(2,2,'GUSTAVO','CORONEL','45768934','784356093','MI CASA','MI CORREO'),
(3,3,'CLAUDIA','TORRES','78435678','784356093','MI CASA','MI CORREO'),
(4,4,'KARLA','CASTILLO','09436756','784356093','MI CASA','MI CORREO'),
(5,2,'JULIO','GALVAN','78436723','784356093','MI CASA','MI CORREO'),
(6,3,'PEDRO','MOJINO','86254814','784356093','MI CASA','MI CORREO'),
(7,4,'MANUEL','ARBIETO','69245874','784356093','MI CASA','MI CORREO'),
(8,2,'ALEJANDRA','CHAPIAMA','36954871','784356093','MI CASA','MI CORREO'),
(9,3,'CARLOS','JAVA','45879631','784356093','MI CASA','MI CORREO');




