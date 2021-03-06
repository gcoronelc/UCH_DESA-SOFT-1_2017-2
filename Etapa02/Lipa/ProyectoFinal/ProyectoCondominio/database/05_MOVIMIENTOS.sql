USE MICONDOMINIO
GO


-- =============================================
-- Creaci�n de tablas
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

INSERT INTO TIPOMOVIMIENTO(NOMBRE) VALUES 
('INGRESO'),
('EGRESO')
go