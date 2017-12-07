/*
Empresa        :  EGCC
Software       :  Sistema de Condominios
DBMS           :  MySQL Server
Base de Datos  :  MICONDOMINIO
Script         :  Crea el esquema SEGURIDAD
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

CREATE TABLE ROL
(
	IDROL                INTEGER NOT NULL,
	NOMBRE               VARCHAR(40) NOT NULL,
	DESCRIPCION          VARCHAR(200) NOT NULL,
	CONSTRAINT PK_ROL PRIMARY KEY (IDROL)
) ENGINE = 'INNODB';



CREATE TABLE USUARIO
(
    IDPERSONA            INTEGER NOT NULL,
	IDROL                INTEGER NOT NULL,
	USUARIO              VARCHAR(20) NOT NULL,
	CLAVE                VARCHAR(50) NOT NULL,
	ESTADO               SMALLINT NOT NULL 
	                     DEFAULT 0 
						 CHECK ( ESTADO IN (0,1) ),
	CONSTRAINT PK_USUARIO PRIMARY KEY (IDPERSONA),
	FOREIGN KEY FK_USUARIO_ROL (IDROL) 
	    REFERENCES ROL (IDROL),
	FOREIGN KEY FK_USUARIO_PERSONA (IDPERSONA) 
	    REFERENCES PERSONA (IDPERSONA)
) ENGINE = 'INNODB';


-- =============================================
-- Datos
-- =============================================

-- Tabla: ROL

insert into rol(idrol, nombre, descripcion) values
(1, 'Propietario', 'Consulta datos de sus propiedades.'),
(2, 'Administrador', 'Realiza tareas administrativas.'),
(3, 'Directivo', 'Desarrolla tareas de administración.'),
(4, 'Secreataria', 'Consulta datos de cualquier propiedad.');


-- Tabla: USUARIO

insert into usuario(IDPERSONA,IDROL,USUARIO,CLAVE,ESTADO) VALUES
(2,1,'gustavo',SHA('gustavo'),1),
(4,4,'karla',SHA('karla'),1),
(3,3,'claudia',SHA('claudia'),1),
(9,3,'carlos',SHA('carlos'),1);





