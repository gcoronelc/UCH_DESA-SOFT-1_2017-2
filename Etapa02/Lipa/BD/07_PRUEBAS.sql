USE MICONDOMINIO
GO

create function meses(@mes int)
returns varchar(20)
as
begin
declare @nomMes varchar(20)
--select @nomMes = choose(@mes,'ENERO','FEBRERO','MARZO','ABRIL','MAYO','JUNIO','JULIO','AGOSTO','SEPTIEMBRE','OCTUBRE','NOVIEMBRE','DICIEMBRE') 
SELECT @nomMes =
CASE 
WHEN @mes = 1 THEN 'ENERO'
WHEN @mes = 2 THEN 'FEBRERO'
WHEN @mes = 3 THEN 'MARZO'
WHEN @mes = 4 THEN 'ABRIL'
WHEN @mes = 5 THEN 'MAYO'
WHEN @mes = 6 THEN 'JUNIO'
WHEN @mes = 7 THEN 'JULIO'
WHEN @mes = 8 THEN 'AGOSTO'
WHEN @mes = 9 THEN 'SEPTIEMBRE'
WHEN @mes = 10 THEN 'OCTUBRE'
WHEN @mes = 11 THEN 'NOVIEMBRE'
WHEN @mes = 12 THEN 'DICIEMBRE'
END
RETURN @nomMes
end

GO
-- INGRESOS O EGRESOS POR MES 
create view reporteMensual
as
SELECT dbo.meses(MONTH(m.FECHA)) MES,tm.NOMBRE 'CONTROL',m.FECHA 'FECHAPAGO',m.IMPORTE,i.DESCRIPCION INMUEBLE,
r.NOMBRE+' '+p.NOMBRE as 'PERSONA',m.DESCRIPCION FROM dbo.MOVIMIENTO m
inner join dbo.TIPOMOVIMIENTO tm on tm.TIPOMOVIMIENTO = m.TIPOMOVIMIENTO
inner join dbo.PERSONA p on p.PERSONA = m.PERSONA
inner join dbo.TIPOPERSONA tp on tp.TIPOPERSONA =  p.TIPOPERSONA
inner join dbo.USUARIO u on u.PERSONA = p.PERSONA
inner join dbo.ROL r on r.ROL = u.ROL
inner join dbo.INMUEBLE i on i.INMUEBLE = m.INMUEBLE 
--where dbo.meses(MONTH(m.FECHA))='MARZO'
--order by m.FECHA
go


-- ESTADO FINANCIERO

create view estadoFinanciero
as
SELECT t.NOMBRE TORRE,pis.DESCRIPCION PISO,tm.NOMBRE 'CONTROL',m.FECHA 'FECHAPAGO',m.IMPORTE,i.DESCRIPCION INMUEBLE,
r.NOMBRE+' '+p.NOMBRE as 'PERSONA',m.DESCRIPCION,
CASE 
WHEN m.OBLIGACION is NULL THEN 'COBRADO'
WHEN o.REALIZADO = 0 THEN 'POR COBRAR'
WHEN o.REALIZADO = 1 THEN 'COBRADO'
END as 'ESTADO'
FROM dbo.MOVIMIENTO m
inner join dbo.TIPOMOVIMIENTO tm on tm.TIPOMOVIMIENTO = m.TIPOMOVIMIENTO
inner join dbo.PERSONA p on p.PERSONA = m.PERSONA
inner join dbo.TIPOPERSONA tp on tp.TIPOPERSONA =  p.TIPOPERSONA
inner join dbo.USUARIO u on u.PERSONA = p.PERSONA
inner join dbo.ROL r on r.ROL = u.ROL
left join dbo.OBLIGACION o on o.OBLIGACION = m.OBLIGACION
inner join dbo.INMUEBLE i on i.INMUEBLE = m.INMUEBLE 
inner join dbo.PISO pis on pis.PISO = i.PISO
inner join dbo.TORRE t on t.TORRE = pis.TORRE
--where t.TORRE=1
--order by TM.NOMBRE,m.FECHA
GO
--------------------------------------------------------------------------------------------
-- ESTADO CUENTA DE UN PROPIETARIO
--------------------------------------------------------------------------------------------

create view cuentaPropietario
as
SELECT m.FECHA FECHA,p.DNI DNI,p.NOMBRE+' '+p.APELLIDO 'PROPIETARIO', YEAR(m.FECHA) ANIO,dbo.meses(MONTH(m.FECHA)) MES, m.DESCRIPCION  DESCRIPCION,m.IMPORTE SALDO,
CASE 
WHEN m.OBLIGACION is NULL THEN 'PAGO REALIZADO'
WHEN o.REALIZADO = 0 THEN 'FALTA PAGAR'
WHEN o.REALIZADO = 1 THEN 'PAGO REALIZADO'
END as 'ESTADO'
 FROM dbo.MOVIMIENTO m
inner join dbo.TIPOMOVIMIENTO tm on tm.TIPOMOVIMIENTO = m.TIPOMOVIMIENTO
left join dbo.OBLIGACION o on o.OBLIGACION = m.OBLIGACION
inner join dbo.PERSONA p on p.PERSONA = m.PERSONA
inner join dbo.TIPOPERSONA tp on tp.TIPOPERSONA =  p.TIPOPERSONA and tp.NOMBRE in('PROPIETARIO','EX-PROPIETARIO')
inner join dbo.INMUEBLE i on i.INMUEBLE = m.INMUEBLE
--WHERE p.DNI = '45768934'
--ORDER BY MONTH(m.FECHA)
go

--------------------------------------------------------------------------------------------
-- ESTADO CUENTA DE UN INMUEBLE
--------------------------------------------------------------------------------------------
create view cuentaInmueble
as
SELECT ti.NOMBRE INMUEBLE,T.NOMBRE TORRE, pis.DESCRIPCION PISO,i.CODIGO CODIGO, p.NOMBRE+' '+p.APELLIDO 'PROPIETARIO', 
dbo.meses(MONTH(m.FECHA)) MES,m.IMPORTE 'PAGO',m.DESCRIPCION DESCRIPCION,m.FECHA FECHA,
CASE 
WHEN m.OBLIGACION is NULL THEN 'CANCELADO'
WHEN o.REALIZADO = 0 THEN 'NO CANCELADO'
WHEN o.REALIZADO = 1 THEN 'CANCELADO'
END as 'ESTADO' FROM dbo.MOVIMIENTO m   
inner join dbo.TIPOMOVIMIENTO tm on tm.TIPOMOVIMIENTO = m.TIPOMOVIMIENTO
inner join dbo.PERSONA p on p.PERSONA = m.PERSONA
inner join dbo.TIPOPERSONA tp on tp.TIPOPERSONA = p.TIPOPERSONA
inner join dbo.USUARIO u on u.PERSONA = p.PERSONA
inner join dbo.ROL r on r.ROL = u.ROL
left join dbo.OBLIGACION o on o.OBLIGACION = m.OBLIGACION
inner join dbo.INMUEBLE i on i.INMUEBLE = m.INMUEBLE 
inner join dbo.TIPOINMUEBLE ti on ti.TIPOINMUEBLE = i.TIPOINMUEBLE
inner join dbo.PISO pis on pis.PISO = i.PISO
inner join dbo.TORRE t on t.TORRE = pis.TORRE
--WHERE ti.NOMBRE = 'DEPARTAMENTO'
--ORDER BY MONTH(m.FECHA), p.NOMBRE+' '+p.APELLIDO
GO

--SELECT NOMBRE inmueble FROM dbo.TIPOINMUEBLE where TIPOINMUEBLE in (2,3,4,5);
--SELECT NOMBRE FROM dbo.TORRE

--SELECT TORRE,PISO,CONTROL,FECHAPAGO,IMPORTE,INMUEBLE,PERSONA,DESCRIPCION,ESTADO 
--FROM dbo.estadoFinanciero WHERE TORRE='TORRE 1'