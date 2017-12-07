use MICONDOMINIO
GO

SELECT * FROM INMUEBLE;
SELECT * FROM PISO;
SELECT * FROM TIPOINMUEBLE;
SELECT * FROM PERSONA;  
SELECT * FROM MOVIMIENTO;    

--insert into INMUEBLE(TIPOINMUEBLE,PERSONA,PISO,CODIGO,DESCRIPCION,
--ACTIVO) values (5,1,6,'ADITORIO-01','En Alquiler',1)

--delete from INMUEBLE
--where INMUEBLE=12

SELECT distinct  i.CODIGO FROM INMUEBLE i 
inner join TIPOINMUEBLE ti ON ti.TIPOINMUEBLE=i.TIPOINMUEBLE  
where ti.NOMBRE = 'AUDITORIO' 
group by i.CODIGO 
having sum(ACTIVO)=0

SELECT distinct  T.NOMBRE TORRE,p.DESCRIPCION PISO FROM INMUEBLE i 
inner join TIPOINMUEBLE ti ON ti.TIPOINMUEBLE=i.TIPOINMUEBLE  
inner join PISO p ON p.PISO = i.PISO 
inner join TORRE t ON t.TORRE = p.TORRE 
where ti.NOMBRE = 'AUDITORIO' and i.CODIGO = 'ADITORIO-04'  
group by T.NOMBRE,p.DESCRIPCION 
having sum(ACTIVO)=0
                                                                                                          