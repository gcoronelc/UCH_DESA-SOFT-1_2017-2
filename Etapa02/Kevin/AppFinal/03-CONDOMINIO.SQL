/*
Empresa        :  EGCC
Software       :  Sistema de Condominios
DBMS           :  MySQL Server
Base de Datos  :  MICONDOMINIO
Script         :  Crea el esquema INMUEBLE
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

CREATE TABLE TINMUEBLE
(
	IDTINMUEBLE          INTEGER NOT NULL,
	NOMBRE               VARCHAR(50) NOT NULL,
	MANTENIMIENTO        NUMERIC(10,2) NOT NULL,
	AGUA                 INTEGER NULL DEFAULT 0 CHECK ( AGUA IN (0,1) ),
	PRIMARY KEY PK_TINMUEBLE (IDTINMUEBLE)
) ENGINE = 'INNODB';



CREATE TABLE TORRE
(
	IDTORRE              INTEGER NOT NULL,
	NOMBRE               VARCHAR(50) NOT NULL,
	PRIMARY KEY PK_TORRE(IDTORRE)
) ENGINE = 'INNODB';



CREATE TABLE INMUEBLE
(
	IDINMUEBLE           INTEGER AUTO_INCREMENT,
	PISO                 INTEGER NOT NULL,
	CODIGO               VARCHAR(20) NOT NULL,
	DESCRIPCION          VARCHAR(200) NOT NULL,
	IDPERSONA            INTEGER NOT NULL,
	IDTINMUEBLE          INTEGER NOT NULL,
	IDTORRE              INTEGER NOT NULL,
	ACTIVO               INTEGER NOT NULL DEFAULT 1 CHECK ( ACTIVO IN (0,1) ),
	PRIMARY KEY PK_INMUEBLE (IDINMUEBLE),
	FOREIGN KEY FK_INMUEBLE_PERSONA (IDPERSONA) REFERENCES PERSONA (IDPERSONA),
	FOREIGN KEY FK_INMUEBLE_TINMUEBLE (IDTINMUEBLE) REFERENCES TINMUEBLE (IDTINMUEBLE),
	FOREIGN KEY FK_INMUEBLE_TORRE (IDTORRE) REFERENCES TORRE (IDTORRE)
) ENGINE = 'INNODB';

-- =============================================
-- DATOS
-- =============================================

-- Tabla TINMUEBLE

insert into TINMUEBLE(IDTINMUEBLE,NOMBRE,MANTENIMIENTO,AGUA) 
values
(1,'CONDOMINIO',0.0,1),
(2,'DEPARTAMENTO',60.0,1),
(3,'COCHERA',30,0),
(4,'OFICINA',100.0,1),
(5,'AUDITORIO',0,0);


-- Tabla TORRE

insert into TORRE(IDTORRE,NOMBRE) values
(1,'TORRE 1'),
(2,'TORRE 2'),
(3,'TORRE 3'),
(99,'TORRE VIRTUAL');


-- Tabla INMUEBLE

insert into INMUEBLE(IDINMUEBLE,PISO,CODIGO,DESCRIPCION,
IDPERSONA,IDTINMUEBLE,IDTORRE,ACTIVO) values
(1,0,'IN-001','CONDOMINIO',1,1,99,1),
(2,1,'OF-101','Oficina de Gustavo',1,4,1,1),
(3,2,'DE-201','Departamento de Gustavo',1,2,1,1),
(4,-1,'S1-102','Cochera de Gustavo',1,2,1,1);







