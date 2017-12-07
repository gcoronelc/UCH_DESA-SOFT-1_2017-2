USE MICONDOMINIO
GO


-- =============================================
-- Creaci�n de tablas
-- =============================================

CREATE TABLE TIPOINMUEBLE
(
	TIPOINMUEBLE          INTEGER IDENTITY(1,1),
	NOMBRE               VARCHAR(50) NOT NULL,
	MANTENIMIENTO        DECIMAL(10,2) NOT NULL,
	AGUA                 INTEGER NULL DEFAULT 1 CHECK (AGUA IN (0,1)),
	CONSTRAINT PK_TINMUEBLE  PRIMARY KEY (TIPOINMUEBLE)
) 
GO



CREATE TABLE TORRE
(
	TORRE              INTEGER IDENTITY(1,1),
	NOMBRE               VARCHAR(50) NOT NULL,
	CONSTRAINT PK_TORRE PRIMARY KEY(TORRE)
) 
GO

CREATE TABLE PISO
(
	PISO      INTEGER IDENTITY(1,1),
	TORRE     INTEGER NOT NULL,
	DESCRIPCION  VARCHAR(20) NOT NULL,

	CONSTRAINT PK_PISO PRIMARY KEY(PISO),
	CONSTRAINT FK_PISO FOREIGN KEY(TORRE) REFERENCES TORRE
)
GO



CREATE TABLE INMUEBLE
(
	INMUEBLE           INTEGER IDENTITY(1,1),
	TIPOINMUEBLE          INTEGER NOT NULL,
	PERSONA            INTEGER NOT NULL,
	PISO                 INTEGER NOT NULL,
	CODIGO               VARCHAR(20) NOT NULL,
	DESCRIPCION          VARCHAR(200) NOT NULL,
	ACTIVO               INTEGER NOT NULL DEFAULT 1 CHECK ( ACTIVO IN (0,1) ),
	CONSTRAINT PK_INMUEBLE PRIMARY KEY(INMUEBLE),
	CONSTRAINT FK_INMUEBLE_PERSONA FOREIGN KEY (PERSONA) REFERENCES PERSONA,
	CONSTRAINT FK_INMUEBLE_TINMUEBLE FOREIGN KEY(TIPOINMUEBLE) REFERENCES TIPOINMUEBLE,
	CONSTRAINT FK_INMUEBLE_PISO FOREIGN KEY(PISO) REFERENCES PISO 
) 
GO

-- =============================================
-- DATOS
-- =============================================

-- Tabla TINMUEBLE

insert into TIPOINMUEBLE(NOMBRE,MANTENIMIENTO,AGUA) 
values
('CONDOMINIO',0.0,1),
('DEPARTAMENTO',80.0,1),
('COCHERA',30.0,0),
('OFICINA',100.0,1),
('AUDITORIO',0.0,0)
GO


-- Tabla TORRE

insert into TORRE(NOMBRE) values
('TORRE 1'),
('TORRE 2'),
('TORRE 3'),
('TORRE 4'),
('TORRE VIRTUAL')
GO


-- Tabla Piso

insert into PISO(TORRE,DESCRIPCION) values
(5,'CONDOMINIO'),
(1,'T1-SOTANO 1'),
(1,'T1-PISO 1'),
(1,'T1-PISO 2'),
(1,'T1-PISO 3'),
(1,'T1-PISO 4'),
(1,'T1-PISO 5'),
(2,'T2-SOTANO 1'),
(2,'T2-PISO 1'),
(2,'T2-PISO 2'),
(2,'T2-PISO 3'),
(2,'T2-PISO 4'),
(2,'T2-PISO 5'),
(3,'T3-SOTANO 1'),
(3,'T3-PISO 1'),
(3,'T3-PISO 2'),
(3,'T3-PISO 3'),
(3,'T3-PISO 4'),
(3,'T3-PISO 5'),
(4,'T4-SOTANO 1'),
(4,'T4-PISO 1'),
(4,'T4-PISO 2'),
(4,'T4-PISO 3'),
(4,'T4-PISO 4'),
(4,'T4-PISO 5');


-- Tabla INMUEBLE

insert into INMUEBLE(TIPOINMUEBLE,PERSONA,PISO,CODIGO,DESCRIPCION,
ACTIVO) values
(1,1,1,'IN-001','CONDOMINIO',1),
(2,2,3,'DE1-101','Departamento de Samuel',1),
(3,2,2,'S1-102','Cochera de Samuel',1),
(4,2,3,'OF1-101','Oficina de Samuel',1),
(5,2,21,'ADITORIO-04','Alquiler auditorio a Samuel',0),
(2,7,4,'DE1-202','Departamento de David',0),
(3,7,2,'S1-105','Cochera de David',0),
(5,1,6,'ADITORIO-01','En Alquiler',0),
(5,1,9,'ADITORIO-02','En Alquiler',0),
(5,1,15,'ADITORIO-03','En Alquiler',0),
(5,1,21,'ADITORIO-04','En Alquiler',0)
GO



