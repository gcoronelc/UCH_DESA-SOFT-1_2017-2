

-- =============================================
-- Creación de la Base de Datos
-- =============================================

DROP DATABASE IF EXISTS CONDOMINIO;

CREATE DATABASE CONDOMINIO;


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE CONDOMINIO;
SET NAMES 'utf8';


-- =============================================
-- Creación del Usuario
-- =============================================

USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'condominio'@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'condominio'@'localhost' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE CONDOMINIO;


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
(2,2,'JAN','PALOMO','45768934','784356093','MI CASA','MI CORREO'),
(3,3,'CLAUDIA','TORRES','78435678','784356093','MI CASA','MI CORREO'),
(4,4,'KARLA','CASTILLO','09436756','784356093','MI CASA','MI CORREO'),
(5,2,'JULIO','GALVAN','78436723','784356093','MI CASA','MI CORREO'),
(6,3,'PEDRO','MOJINO','86254814','784356093','MI CASA','MI CORREO'),
(7,4,'MANUEL','ARBIETO','69245874','784356093','MI CASA','MI CORREO'),
(8,2,'ALEJANDRA','CHAPIAMA','36954871','784356093','MI CASA','MI CORREO'),
(9,3,'CARLOS','JAVA','45879631','784356093','MI CASA','MI CORREO');

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
(2,1,'jan',SHA('jan'),1),
(4,4,'karla',SHA('karla'),1),
(3,3,'claudia',SHA('claudia'),1),
(9,3,'carlos',SHA('carlos'),1);


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
(2,1,'OF-101','Oficina de Jan',1,4,1,1),
(3,2,'DE-201','Departamento de Jan',1,2,1,1),
(4,-1,'S1-102','Cochera de Jan',1,3,1,1);



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


-- Tabla TOBLIGACION

INSERT INTO TOBLIGACION(IDTOBLIGACION,NOMBRE) VALUES
(1,'AGUA'),
(2,'MANTENIMIENTO'),
(3,'OTROS');


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

insert into tmovimiento(IDTMOVIMIENTO,NOMBRE,ACCION) values (1,'mantenimiento','INGRESO');


CREATE VIEW V_OBLIGACION(
id,inmueble,codigo,torre,piso,descripcion,
obligacion,nomobligacion,anio,mes,
vencimiento,importe,pagada
) AS
select 
  o.idobligacion, i.idinmueble, i.codigo,
  i.idtorre, i.piso, i.descripcion,
  t.idtobligacion, t.nombre, o.anio,
  o.mes, o.fvence, o.importe, 'none'
from inmueble i
join obligacion o on i.idinmueble = o.idinmueble
join tobligacion t on o.idtobligacion = t.idtobligacion;

insert into obligacion(IDTOBLIGACION,IDINMUEBLE,ANIO,MES,FVENCE,IMPORTE,FECHA,AUDIDPERSONA) values 
(2,3,2017,1,'2017-01-31',60,CURDATE(),2),
(2,4,2017,1,'2017-01-31',60,CURDATE(),2),
(2,2,2017,1,'2017-01-31',100,CURDATE(),2),
(2,3,2017,1,'2017-02-28',60,CURDATE(),2),
(2,4,2017,1,'2017-02-28',60,CURDATE(),2),
(2,2,2017,1,'2017-02-28',100,CURDATE(),2);

insert into movimiento(IDINMUEBLE,IDOBLIGACION,IDTMOVIMIENTO,FECHA,IMPORTE,DESCRIPCION,AUDIDPERSONA) values 
(3,1,1,CURDATE(),60,'algo',2),
(4,2,1,CURDATE(),60,'algo',2),
(2,3,1,CURDATE(),100,'algo',2),
(3,1,1,CURDATE(),60,'algo',2),
(4,2,1,CURDATE(),60,'algo',2),
(2,3,1,CURDATE(),100,'algo',2),
(3,4,1,CURDATE(),60,'algo',2),
(4,5,1,CURDATE(),60,'algo',2),
(2,6,1,CURDATE(),100,'algo',2);

/*select * from obligacion;

select * from movimiento;

SELECT tm.ACCION TIPOINMUEBLE, o.IDOBLIGACION OBLIGACION, i.DESCRIPCION INMUEBLE, m.IMPORTE PAGO, 
p.NOMBRE PROPIETARIO, m.FECHA FECHA FROM movimiento m 
inner join tmovimiento tm on tm.IDTMOVIMIENTO = m.IDTMOVIMIENTO and tm.ACCION = 'INGRESO' 
inner join obligacion o on o.IDOBLIGACION = m.IDOBLIGACION 
inner join tobligacion tob on tob.IDTOBLIGACION = o.IDTOBLIGACION 
inner join persona p on p.IDPERSONA = m.AUDIDPERSONA 
inner join inmueble i on i.IDINMUEBLE = m.IDINMUEBLE 
inner join tinmueble ti on ti.IDTINMUEBLE = i.IDTINMUEBLE 
where tob.IDTOBLIGACION = 2 and ti.NOMBRE = 'OFICINA';

SELECT NOMBRE FROM tinmueble 
where MANTENIMIENTO > 0 */
