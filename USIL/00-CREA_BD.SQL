/*
Empresa        :  EGCC
Software       :  Sistema de Condominios
DBMS           :  MySQL Server
Base de Datos  :  MICONDOMINIO
Script         :  Crea la Base de Datos
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Telefono       :  (511) 9966-64457
Email          :  gcoronelc@gmail.com
Sitio Web      :  http://www.desarrollasoftware.com
Blog           :  http://gcoronelc.blogspot.com
*/

-- =============================================
-- Creación de la Base de Datos
-- =============================================

DROP DATABASE IF EXISTS MICONDOMINIO;
CREATE DATABASE MICONDOMINIO;


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE MICONDOMINIO;
SET NAMES "UTF8";

-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'gustavo'@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'gustavo'@'localhost' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE MICONDOMINIO;