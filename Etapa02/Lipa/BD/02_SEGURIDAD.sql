USE MICONDOMINIO
GO


-- =============================================
-- Creación de tablas
-- =============================================

CREATE TABLE ROL
(
	ROL                INTEGER IDENTITY(1,1),
	NOMBRE               VARCHAR(40) NOT NULL,
	DESCRIPCION          VARCHAR(200) NOT NULL,
	CONSTRAINT PK_ROL PRIMARY KEY (ROL)
) 
GO



CREATE TABLE USUARIO
(
    PERSONA            INTEGER NOT NULL,
	ROL                INTEGER NOT NULL,
	USUARIO              VARCHAR(20) NOT NULL,
	CLAVE                VARCHAR(50) NOT NULL,
	ESTADO               SMALLINT NOT NULL 
	                     DEFAULT 0 
						 CHECK ( ESTADO IN (0,1) ),
	CONSTRAINT PK_USUARIO PRIMARY KEY (PERSONA),
	CONSTRAINT FK_USUARIO_ROL FOREIGN KEY (ROL) REFERENCES ROL,
	CONSTRAINT FK_USUARIO_PERSONA FOREIGN KEY (PERSONA) REFERENCES PERSONA
) 
GO


-- =============================================
-- Datos
-- =============================================

-- Tabla: ROL

insert into rol(nombre, descripcion) values
('PROPIETARIO', 'Consulta datos de sus propiedades.'),
('ADMINISTRADOR', 'Realiza tareas administrativas.'),
('DIRECTIVO', 'Desarrolla tareas de administración.'),
('SECRETARIA', 'Consulta datos de cualquier propiedad.')
GO


-- Tabla: USUARIO

insert into usuario(PERSONA,ROL,USUARIO,CLAVE,ESTADO) VALUES
(2,1,'samuel',HashBytes('SHA1','leon'),1),
(3,2,'oscar',HashBytes('SHA1','trinidad'),1),
(4,2,'alonso',HashBytes('SHA1','lipa'),1),
(5,3,'gustavo',HashBytes('SHA1','coronel'),1),
(6,4,'joaquin',HashBytes('SHA1','antonio'),1),
(7,1,'david',HashBytes('SHA1','rivera'),0)
GO

--select * from USUARIO