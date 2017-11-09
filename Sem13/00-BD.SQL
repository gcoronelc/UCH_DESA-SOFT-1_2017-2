/*
Empresa        :  EGCC
Software       :  Sistema de Condominios
DBMS           :  SQL SERVER
Esquema        :  NINGUNO
Script         :  Crea la base de datos
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Email          :  gcoronelc@gmail.com
Blog           :  http://gcoronelc.blogspot.com
Creado el      :  14-OCT-2017
*/



-- =============================================
-- Creación de la Base de Datos
-- =============================================

USE master;
go

IF( EXISTS ( SELECT name FROM master.sys.databases WHERE name = 'BDCONDOMINIO' ) )
BEGIN
	DROP DATABASE BDCONDOMINIO;
END;
go

CREATE DATABASE BDCONDOMINIO;
go


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE BDCONDOMINIO;


