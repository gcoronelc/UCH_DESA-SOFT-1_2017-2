/*
Navicat MySQL Data Transfer

Source Server         : Servidor MySQL
Source Server Version : 50141
Source Host           : localhost:3306
Source Database       : db_adonde

Target Server Type    : MYSQL
Target Server Version : 50141
File Encoding         : 65001

Date: 2013-11-30 15:26:41
*/


-- ----------------------------
-- Records of administrador
-- ----------------------------
INSERT INTO `administrador` VALUES ('1', '1', '1');
INSERT INTO `administrador` VALUES ('2', '2', '2');
INSERT INTO `administrador` VALUES ('3', '1', '2');


-- ----------------------------
-- Records of condominio
-- ----------------------------
INSERT INTO `condominio` VALUES ('1', 'Condominio 1', 'TEST');
INSERT INTO `condominio` VALUES ('2', 'Condominio 2', 'TEST');
INSERT INTO `condominio` VALUES ('3', 'Condominio 3', 'TEST');
INSERT INTO `condominio` VALUES ('4', 'Condominio 4', 'TEST');
INSERT INTO `condominio` VALUES ('5', 'Condominio 5', 'TEST');


-- ----------------------------
-- Records of cuota
-- ----------------------------
INSERT INTO `cuota` VALUES ('1', '1', '150', '2013-12-31 16:11:42');
INSERT INTO `cuota` VALUES ('2', '2', '250', '2013-12-31 16:11:55');
INSERT INTO `cuota` VALUES ('3', '1', '450', '2013-11-30 14:53:38');

-- 
-- ----------------------------
-- Records of departamento
-- ----------------------------
INSERT INTO `departamento` VALUES ('1', '1', '100', 'TEST');
INSERT INTO `departamento` VALUES ('2', '1', '101', 'TEST');
INSERT INTO `departamento` VALUES ('3', '1', '102', 'TEST');
INSERT INTO `departamento` VALUES ('4', '1', '103', 'TEST');
INSERT INTO `departamento` VALUES ('5', '1', '104', 'TEST');
INSERT INTO `departamento` VALUES ('6', '9', '105', 'TEST');


-- ----------------------------
-- Records of edificio
-- ----------------------------
INSERT INTO `edificio` VALUES ('1', '1', 'Edificio 1', 'TEST');
INSERT INTO `edificio` VALUES ('2', '1', 'Edificio 2', 'TEST');
INSERT INTO `edificio` VALUES ('6', '1', 'Edificio 3', 'TEST');
INSERT INTO `edificio` VALUES ('7', '2', 'Edificio 4', 'TEST');
INSERT INTO `edificio` VALUES ('8', '3', 'Edificio 5', 'TEST');
INSERT INTO `edificio` VALUES ('9', '4', 'Edificio 6', 'TEST');
INSERT INTO `edificio` VALUES ('10', '4', 'Edificio 7', 'TEST');
INSERT INTO `edificio` VALUES ('11', '3', 'Edificio 8', 'TEST');
INSERT INTO `edificio` VALUES ('12', '3', 'Edificio 9', 'TEST');

-- ----------------------------
-- Records of evento
-- ----------------------------
INSERT INTO `evento` VALUES ('1', '1', 'EVENTO 1', 'TEST');
INSERT INTO `evento` VALUES ('2', '2', 'EVENTO 2', 'TEST');
INSERT INTO `evento` VALUES ('6', '6', 'EVENTO 3', 'TEST');
INSERT INTO `evento` VALUES ('7', '7', 'EVENTO 4', 'TEST');
---------
-- Records of pago
-- ----------------------------
INSERT INTO `pago` VALUES ('1', '1', '1');
INSERT INTO `pago` VALUES ('2', '2', '1');

-
-- ----------------------------
-- Records of queja
-- ----------------------------
INSERT INTO `queja` VALUES ('1', '1', 'Queja 1', 'TEST', '2013-11-27 18:49:32');
INSERT INTO `queja` VALUES ('2', '1', 'Queja 2', 'TEST', '2013-11-27 18:49:32');
INSERT INTO `queja` VALUES ('3', '1', 'Queja 3', 'TEST', '2013-11-27 18:49:32');
INSERT INTO `queja` VALUES ('4', '1', 'Queja 4', 'TEST', '2013-11-27 18:49:32');
INSERT INTO `queja` VALUES ('6', '1', 'Queja 5', 'TEST', '2013-11-27 18:49:32');
INSERT INTO `queja` VALUES ('7', '1', 'Queja 6', 'TEST', '2013-11-30 11:10:04');

-- ----------------------------
-- Records of residente
-- ----------------------------
INSERT INTO `residente` VALUES ('1', '1', '1');
INSERT INTO `residente` VALUES ('2', '2', '2');
INSERT INTO `residente` VALUES ('3', '6', '2');

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('1', 'jpari18@gmail.com', '123456', 'Julio', 'Pari', 'Alegre', '42979660');
INSERT INTO `usuario` VALUES ('2', 'julio@java.pe', '123456', 'Alan', 'Garcia', 'Perez', '45612358');
----------------
-- Records of visita
-- ----------------------------
INSERT INTO `visita` VALUES ('1', '1', 'Visita 1', 'TEST', 'TEST', '456789', '2013-11-27 18:51:56');
INSERT INTO `visita` VALUES ('2', '1', 'Visita 2', 'TEST', 'TEST', '123456', '2013-11-27 18:51:56');
