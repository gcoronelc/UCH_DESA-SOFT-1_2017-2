USE MICONDOMINIO
GO


-- =============================================
-- Creaci�n de tablas
-- =============================================

CREATE TABLE TIPOOBLIGACION
(
	TIPOOBLIGACION        INTEGER IDENTITY(1,1),
	NOMBRE               VARCHAR(50) NOT NULL,
	CONSTRAINT PK_TOBLIGACION PRIMARY KEY(TIPOOBLIGACION)
) 
GO



CREATE TABLE RECIBO
(
	RECIBO             VARCHAR(20) NOT NULL,
	TIPOOBLIGACION        INTEGER NOT NULL,
	ANIO                 INTEGER NOT NULL,
	MES                  INTEGER NOT NULL,
	FVENCE               DATE NULL,
	IMPORTE              INTEGER NULL,
	DESCRIPCION          VARCHAR(200) NOT NULL,
	CONSTRAINT PK_RECIBO PRIMARY KEY(RECIBO),
	CONSTRAINT FK_RECIBO_TOBLIGACION FOREIGN KEY(TIPOOBLIGACION) REFERENCES TIPOOBLIGACION
) 
GO



CREATE TABLE OBLIGACION
(
	OBLIGACION         VARCHAR(20) NOT NULL,
	TIPOOBLIGACION        INTEGER NOT NULL,
	INMUEBLE           INTEGER NOT NULL,
	PERSONA         INTEGER NOT NULL,
	ANIO                 INTEGER NULL,
	MES                  INTEGER NULL,
	FVENCE               DATE NULL,
	IMPORTE              DECIMAL(18,2) NULL,
	FECHA                DATE NOT NULL,
	REALIZADO       INTEGER NOT NULL DEFAULT 0 CHECK ( REALIZADO IN (0,1) ),
	CONSTRAINT PK_OBLIGACION PRIMARY KEY(OBLIGACION),
	CONSTRAINT FK_OBLIGACION_TOBLIGACION  FOREIGN KEY(TIPOOBLIGACION) REFERENCES TIPOOBLIGACION,
	CONSTRAINT FK_OBLIGACION_INMUEBLE FOREIGN KEY(INMUEBLE) REFERENCES INMUEBLE,
	CONSTRAINT FK_OBLIGACION_PERSONA FOREIGN KEY(PERSONA) REFERENCES PERSONA
) 
GO


-- =============================================
-- Datos
-- =============================================


-- Tabla TIPOOBLIGACION

INSERT INTO TIPOOBLIGACION(NOMBRE) VALUES
('AGUA'),
('MANTENIMIENTO'),
('PERSONAL'),
('PROVEEDOR'),
('OTROS')
GO

-- Tabla RECIBO

INSERT INTO RECIBO(RECIBO,TIPOOBLIGACION,ANIO,MES,FVENCE,IMPORTE,DESCRIPCION) VALUES
('RAGUA-0001',1,2017,01,'2017-01-01',28000,'4 tanques de agua de 7000 litros'),
('RAGUA-0002',1,2017,02,'2017-02-01',28000,'4 tanques de agua de 7000 litros'),
('RAGUA-0003',1,2017,03,'2017-03-01',28000,'4 tanques de agua de 7000 litros'),
('RAGUA-0004',1,2017,04,'2017-04-01',28000,'4 tanques de agua de 7000 litros'),
('RAGUA-0005',1,2017,05,'2017-05-01',28000,'4 tanques de agua de 7000 litros'),
('RAGUA-0006',1,2017,06,'2017-06-01',28000,'4 tanques de agua de 7000 litros')
--('RAGUA-0007',1,2017,07,'2017-07-01',28000,'4 tanques de agua de 7000 litros',1),
--('RAGUA-0008',1,2017,08,'2017-08-01',28000,'4 tanques de agua de 7000 litros',1),
--('RAGUA-0009',1,2017,09,'2017-09-01',28000,'4 tanques de agua de 7000 litros',1),
--('RAGUA-0010',1,2017,10,'2017-10-01',28000,'4 tanques de agua de 7000 litros',1),
--('RAGUA-0011',1,2017,11,'2017-11-01',28000,'4 tanques de agua de 7000 litros',1),
--('RAGUA-0012',1,2017,12,'2017-12-01',28000,'4 tanques de agua de 7000 litros',1)
GO
-- Tabla OBLIGACION

INSERT INTO OBLIGACION(OBLIGACION,TIPOOBLIGACION,INMUEBLE,PERSONA,ANIO,MES,FVENCE,IMPORTE,FECHA,REALIZADO) VALUES
-- AGUA
('OAGUA-0001',1,1,6,2017,01,'2017-01-15',28000,'2017-01-01',1),
('OAGUA-0002',1,1,6,2017,02,'2017-02-15',28000,'2017-02-01',1),
('OAGUA-0003',1,1,6,2017,03,'2017-03-15',28000,'2017-03-01',1),
('OAGUA-0004',1,1,6,2017,04,'2017-04-15',28000,'2017-04-01',1),
('OAGUA-0005',1,1,6,2017,05,'2017-05-15',28000,'2017-05-01',1),
('OAGUA-0006',1,1,6,2017,06,'2017-06-15',28000,'2017-06-01',1),
--('OAGUA-0007',1,1,6,2017,07,'2017-07-02',28000,'2017-07-01',1),
--('OAGUA-0008',1,1,6,2017,08,'2017-08-02',28000,'2017-08-01',1),
--('OAGUA-0009',1,1,6,2017,09,'2017-09-02',28000,'2017-09-01',1),
--('OAGUA-0010',1,1,6,2017,10,'2017-10-02',28000,'2017-10-01',1),
--('OAGUA-0011',1,1,6,2017,11,'2017-11-02',28000,'2017-11-01',1),
--('OAGUA-0012',1,1,6,2017,12,'2017-12-02',28000,'2017-12-01',1),

-- MANTENIMIENTO
-- Samuel
('OMANTE-0001',2,2,2,2017,01,'2017-01-31',80,'2017-01-01',0),
('OMANTE-0002',2,3,2,2017,01,'2017-01-31',30,'2017-01-01',0),
('OMANTE-0003',2,4,2,2017,01,'2017-01-31',100,'2017-01-01',0),
('OMANTE-0004',2,2,2,2017,02,'2017-02-28',80,'2017-02-01',0),
('OMANTE-0005',2,3,2,2017,02,'2017-02-28',30,'2017-02-01',0),
('OMANTE-0006',2,4,2,2017,02,'2017-02-28',100,'2017-02-01',0),
('OMANTE-0007',2,2,2,2017,03,'2017-03-31',80,'2017-03-01',0),
('OMANTE-0008',2,3,2,2017,03,'2017-03-31',30,'2017-03-01',0),
('OMANTE-0009',2,4,2,2017,03,'2017-03-31',100,'2017-03-01',0),
('OMANTE-0010',2,2,2,2017,04,'2017-04-30',80,'2017-04-01',0),
('OMANTE-0011',2,3,2,2017,04,'2017-04-30',30,'2017-04-01',0),
('OMANTE-0012',2,4,2,2017,04,'2017-04-30',100,'2017-04-01',0),
('OMANTE-0013',2,2,2,2017,05,'2017-05-31',80,'2017-05-01',0),
('OMANTE-0014',2,3,2,2017,05,'2017-05-31',30,'2017-05-01',0),
('OMANTE-0015',2,4,2,2017,05,'2017-05-31',100,'2017-05-01',0),
('OMANTE-0016',2,2,2,2017,06,'2017-06-30',80,'2017-06-01',0),
('OMANTE-0017',2,3,2,2017,06,'2017-06-30',30,'2017-06-01',0),
('OMANTE-0018',2,4,2,2017,06,'2017-06-30',100,'2017-06-01',0),

-- David
('OMANTE-0019',2,6,7,2017,01,'2017-01-31',80,'2017-01-01',0),
('OMANTE-0020',2,7,7,2017,01,'2017-01-31',30,'2017-01-01',0),
('OMANTE-0022',2,6,7,2017,02,'2017-02-28',80,'2017-02-01',0),
('OMANTE-0023',2,7,7,2017,02,'2017-02-28',30,'2017-02-01',0),
('OMANTE-0025',2,6,7,2017,03,'2017-03-31',80,'2017-03-01',0),
('OMANTE-0026',2,7,7,2017,03,'2017-03-31',30,'2017-03-01',0),

-- PERSONAL
('OPERSO-0001',3,1,6,2017,01,'2017-01-14',500,'2017-01-01',0),
('OPERSO-0002',3,1,6,2017,01,'2017-01-31',500,'2017-01-15',0),
('OPERSO-0003',3,1,6,2017,02,'2017-02-14',500,'2017-02-01',0),
('OPERSO-0004',3,1,6,2017,02,'2017-02-28',500,'2017-02-15',0),
('OPERSO-0005',3,1,6,2017,03,'2017-03-14',500,'2017-03-01',0),
('OPERSO-0006',3,1,6,2017,03,'2017-03-31',500,'2017-03-15',0),
('OPERSO-0007',3,1,6,2017,04,'2017-04-14',500,'2017-04-01',0),
('OPERSO-0008',3,1,6,2017,04,'2017-04-30',500,'2017-04-15',0),
('OPERSO-0009',3,1,6,2017,05,'2017-05-14',500,'2017-05-01',0),
('OPERSO-0010',3,1,6,2017,05,'2017-05-31',500,'2017-05-15',0),
('OPERSO-0011',3,1,6,2017,06,'2017-06-14',500,'2017-06-01',0),
('OPERSO-0012',3,1,6,2017,06,'2017-06-30',500,'2017-06-15',0)