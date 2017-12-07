use MICONDOMINIO;

-----------------------------------------------------
-- PROCEDIMIENTO ALMACENADO PARA VALIDAR LOS PAGOS --
-----------------------------------------------------
GO
alter procedure registropago
@dni			varchar(15),
@obligacion		varchar(20),
@descripcion	varchar(200)

AS
	BEGIN
		declare @idpersona int, @idinmueble int, @importe numeric(12,2);
		select @idpersona = p.PERSONA, @idinmueble = o.INMUEBLE, @importe = o.IMPORTE  
		from PERSONA p 
		inner join OBLIGACION o on o.PERSONA = p.PERSONA
		where p.DNI = @dni and o.OBLIGACION = @obligacion;
		insert into MOVIMIENTO(TIPOMOVIMIENTO, OBLIGACION, INMUEBLE, PERSONA, FECHA, IMPORTE, DESCRIPCION)
		values(1, @obligacion, @idinmueble, @idpersona, GETDATE(), @importe, @descripcion);
		update OBLIGACION 
				set REALIZADO = 1
		where PERSONA = @idpersona and OBLIGACION = @obligacion;
	END
GO
------------------------------
-- PRUEBA DEL PROCEDIMIENTO --
------------------------------

-- exec registropago '45768934', 'OMANTE-0001', 'Cuota mantenimiento';

----------------------------------------------
-- SELECT PARA LA CONSULTA DE LA PREGUNTA 2 --
----------------------------------------------

/*select tm.NOMBRE, (p.NOMBRE + ' ' + p.APELLIDO) as NOMBRECOMPLETO, m.OBLIGACION,
		    		i.DESCRIPCION, m.IMPORTE, m.FECHA  from MOVIMIENTO m
		    		inner join TIPOMOVIMIENTO tm on tm.TIPOMOVIMIENTO = m.TIPOMOVIMIENTO
		    		inner join PERSONA p on p.PERSONA = m.PERSONA
		    		inner join INMUEBLE i on i.INMUEBLE = m.INMUEBLE 
		    		inner join TIPOINMUEBLE ti on ti.TIPOINMUEBLE = i.TIPOINMUEBLE
		    		inner join OBLIGACION o on o.OBLIGACION = m.OBLIGACION
		    		inner join TIPOOBLIGACION tob on o.TIPOOBLIGACION = tob.TIPOOBLIGACION and tob.TIPOOBLIGACION = 2
		    		where tm.NOMBRE = 'INGRESO' and ti.NOMBRE = 'DEPARTAMENTO'; */



