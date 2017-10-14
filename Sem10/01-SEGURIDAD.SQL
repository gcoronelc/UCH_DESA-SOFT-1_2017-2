/*
Empresa        :  EGCC
Software       :  Sistema de Condominios
DBMS           :  SQL SERVER
Esquema        :  SEGURIDAD
Script         :  Crea las tablas del esquema seguridad
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Email          :  gcoronelc@gmail.com
Blog           :  http://gcoronelc.blogspot.com
Creado el      :  14-OCT-2017
*/


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE BDCONDOMINIO;


-- =============================================
-- Creación de las tablas
-- =============================================

CREATE TABLE dbo.TPERSONA
( 
	IDTPERSONA           integer  NOT NULL ,
	NOMBRE               varchar(60)  NOT NULL ,
	CONSTRAINT XPKTPERSONA PRIMARY KEY (IDTPERSONA ASC)
)
go



CREATE TABLE dbo.PERSONA
( 
	IDPERSONA            integer  NOT NULL ,
	IDTPERSONA           integer  NOT NULL ,
	NOMBRE               varchar(60)  NOT NULL ,
	APELLIDO             varchar(60)  NOT NULL ,
	DNI                  varchar(10)  NOT NULL ,
	DIRECCION            varchar(100)  NOT NULL ,
	TELEFONO             varchar(20)  NOT NULL ,
	EMAIL                varchar(60)  NOT NULL ,
	CONSTRAINT XPKPERSONA PRIMARY KEY (IDPERSONA ASC),
	CONSTRAINT FK_PERSONA_TPERSONA FOREIGN KEY (IDTPERSONA) REFERENCES dbo.TPERSONA(IDTPERSONA)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE TABLE dbo.ROL
( 
	IDROL                integer  NOT NULL ,
	NOMBRE               varchar(60)  NOT NULL ,
	CONSTRAINT XPKROL PRIMARY KEY (IDROL ASC)
)
go



CREATE TABLE dbo.USUARIO
( 
	IDPERSONA            integer  NOT NULL ,
	IDROL                integer  NOT NULL ,
	USUARIO              varchar(20)  NOT NULL ,
	CLAVE                varbinary(100)  NOT NULL ,
	ESTADO               integer  NOT NULL 
	CONSTRAINT CHK_ESTADO_1793768912
		CHECK  ( ESTADO IN (0,1) ),
	CONSTRAINT XPKUSUARIO PRIMARY KEY (IDPERSONA ASC),
	CONSTRAINT FK_USUARIO_PERSONA FOREIGN KEY (IDPERSONA) REFERENCES dbo.PERSONA(IDPERSONA)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT FK_USUARIO_ROL FOREIGN KEY (IDROL) REFERENCES dbo.ROL(IDROL)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go


-- =============================================
-- Creación de las tablas
-- =============================================




