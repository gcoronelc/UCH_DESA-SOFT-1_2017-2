USE MICONDOMINIO
GO


-- =============================================
-- Creación de tablas
-- =============================================


CREATE TABLE TIPOMOVIMIENTO
(
	TIPOMOVIMIENTO        INTEGER IDENTITY(1,1),
	NOMBRE               VARCHAR(50) NOT NULL CHECK ( NOMBRE IN ('INGRESO','EGRESO') ),
	CONSTRAINT PK_TMOVIMIENTO PRIMARY KEY(TIPOMOVIMIENTO)
) 
GO



CREATE TABLE MOVIMIENTO
(
	MOVIMIENTO         INTEGER IDENTITY(1,1),
	TIPOMOVIMIENTO        INTEGER NOT NULL,
	OBLIGACION         varchar(20) NULL,
	INMUEBLE           INTEGER NOT NULL,
	PERSONA         INTEGER NOT NULL,
	FECHA                DATE NOT NULL,
	IMPORTE              NUMERIC(12,2) NOT NULL,
	DESCRIPCION          VARCHAR(200) NOT NULL,
	CONSTRAINT PK_MOVIMIENTO PRIMARY KEY (MOVIMIENTO),
	CONSTRAINT FK_MOVIMIENTO_INMUEBLE FOREIGN KEY(INMUEBLE) REFERENCES INMUEBLE,
	CONSTRAINT FK_MOVIMIENTO_OBLIGACION FOREIGN KEY (OBLIGACION) REFERENCES OBLIGACION,
	CONSTRAINT FK_MOVIMIENTO_TMOVIMIENTO FOREIGN KEY (TIPOMOVIMIENTO) REFERENCES TIPOMOVIMIENTO,
	CONSTRAINT FK_MOVIMIENTO_PERSONA FOREIGN KEY (PERSONA) REFERENCES PERSONA
)
GO

-- =============================================
-- Datos
-- =============================================

-- Tabla tipoMovimiento

INSERT INTO TIPOMOVIMIENTO(NOMBRE) VALUES
('INGRESO'),
('EGRESO')

-- Tabla Movimiento

INSERT INTO MOVIMIENTO(TIPOMOVIMIENTO,OBLIGACION,INMUEBLE,PERSONA,FECHA,IMPORTE,DESCRIPCION) VALUES
-- AGUA
(2,'OAGUA-0001',1,6,'2017-01-02',28000,'Pago por servicio de agua Diciembre  2016'),
(2,'OAGUA-0002',1,6,'2017-02-02',28000,'Pago por servicio de agua Enero 2017'),
(2,'OAGUA-0003',1,6,'2017-03-02',28000,'Pago por servicio de agua Febrero 2017'),
(2,'OAGUA-0004',1,6,'2017-04-02',28000,'Pago por servicio de agua Marzo 2017'),
(2,'OAGUA-0005',1,6,'2017-05-02',28000,'Pago por servicio de agua Abril 2017'),
(2,'OAGUA-0006',1,6,'2017-06-02',28000,'Pago por servicio de agua Mayo 2017'),
--(2,'OAGUA-0007',1,6,'2017-07-02',28000,'Pago por servicio de agua Junio 2017'),
--(2,'OAGUA-0008',1,6,'2017-08-02',28000,'Pago por servicio de agua Julio 2017'),
--(2,'OAGUA-0009',1,6,'2017-09-02',28000,'Pago por servicio de agua Agosto 2017'),
--(2,'OAGUA-0010',1,6,'2017-10-02',28000,'Pago por servicio de agua Septiembre 2017'),
--(2,'OAGUA-0011',1,6,'2017-11-02',28000,'Pago por servicio de agua Octubre 2017'),
--(2,'OAGUA-0012',1,6,'2017-12-02',28000,'Pago por servicio de agua Noviembre 2017'),

--MANTENIMIENTO
--Samuel
(1,'OMANTE-0001',2,2,'2017-01-01',80,'Cuota de mantenimiento departamento Enero 2017'),
(1,'OMANTE-0002',3,2,'2017-01-01',30,'Cuota de mantenimiento cochera Enero 2017'),
(1,'OMANTE-0003',4,2,'2017-01-02',100,'Cuota de mantenimiento oficina Enero 2017'),
(1,'OMANTE-0004',2,2,'2017-02-01',80,'Cuota de mantenimiento departamento Febrero 2017'),
(1,'OMANTE-0005',3,2,'2017-02-01',30,'Cuota de mantenimiento cochera Febrero 2017'),
(1,'OMANTE-0006',4,2,'2017-02-02',100,'Cuota de mantenimiento oficina Febrero 2017'),
(1,'OMANTE-0007',2,2,'2017-03-01',80,'Cuota de mantenimiento departamento Marzo 2017'),
(1,'OMANTE-0008',3,2,'2017-03-01',30,'Cuota de mantenimiento cochera Marzo 2017'),
(1,'OMANTE-0009',4,2,'2017-03-02',100,'Cuota de mantenimiento oficina Marzo 2017'),
(1,'OMANTE-0010',2,2,'2017-04-01',80,'Cuota de mantenimiento departamento Abril 2017'),
(1,'OMANTE-0011',3,2,'2017-04-01',30,'Cuota de mantenimiento cochera Abril 2017'),
(1,'OMANTE-0012',4,2,'2017-04-02',100,'Cuota de mantenimiento oficina Abril 2017'),
(1,'OMANTE-0013',2,2,'2017-05-01',80,'Cuota de mantenimiento departamento Mayo 2017'),
(1,'OMANTE-0014',3,2,'2017-05-01',30,'Cuota de mantenimiento cochera Mayo 2017'),
(1,'OMANTE-0015',4,2,'2017-05-02',100,'Cuota de mantenimiento oficina Mayo 2017'),
(1,'OMANTE-0016',2,2,'2017-06-01',80,'Cuota de mantenimiento departamento Junio 2017'),
(1,'OMANTE-0017',3,2,'2017-06-01',30,'Cuota de mantenimiento cochera Junio 2017'),
(1,'OMANTE-0018',4,2,'2017-06-02',100,'Cuota de mantenimiento oficina Junio 2017'),

--David
(1,'OMANTE-0019',6,7,'2017-01-01',60,'Cuota de mantenimiento departamento Enero 2017'),
(1,'OMANTE-0020',7,7,'2017-01-01',30,'Cuota de mantenimiento cochera Enero 2017'),
(1,'OMANTE-0022',6,7,'2017-02-01',60,'Cuota de mantenimiento departamento Febrero 2017'),
(1,'OMANTE-0023',7,7,'2017-02-01',30,'Cuota de mantenimiento cochera Febrero 2017'),
(1,'OMANTE-0025',6,7,'2017-03-01',60,'Cuota de mantenimiento departamento Marzo 2017'),
(1,'OMANTE-0026',7,7,'2017-03-01',30,'Cuota de mantenimiento cochera Marzo 2017'),

--ALQUILER AUDITORIO
(1,NULL,5,2,'2017-04-20',150,'Alquiler de Auditorio'),
(1,NULL,5,2,'2017-04-21',30,'Limpieza de Auditorio'),

--PERSONAL
(2,'OPERSO-0001',1,6,'2017-01-02',500,'Pago a la Secretaria Diciembre 2016'),
(2,'OPERSO-0002',1,6,'2017-01-17',500,'Pago a la Secretaria quincena Enero 2017'),
(2,'OPERSO-0003',1,6,'2017-02-02',500,'Pago a la Secretaria Enero 2017'),
(2,'OPERSO-0004',1,6,'2017-02-17',500,'Pago a la Secretaria quincena Febrero 2017'),
(2,'OPERSO-0005',1,6,'2017-03-02',500,'Pago a la Secretaria Febrero 2017'),
(2,'OPERSO-0006',1,6,'2017-03-17',500,'Pago a la Secretaria quincena Marzo 2017'),
(2,'OPERSO-0007',1,6,'2017-04-02',500,'Pago a la Secretaria Marzo 2017'),
(2,'OPERSO-0008',1,6,'2017-04-17',500,'Pago a la Secretaria quincena Abril 2017'),
(2,'OPERSO-0009',1,6,'2017-05-02',500,'Pago a la Secretaria Abril 2017'),
(2,'OPERSO-0010',1,6,'2017-05-17',500,'Pago a la Secretaria quincena Mayo 2017'),
(2,'OPERSO-0011',1,6,'2017-06-02',500,'Pago a la Secretaria Mayo 2017'),
(2,'OPERSO-0012',1,6,'2017-06-17',500,'Pago a la Secretaria quincena Junio 2017')