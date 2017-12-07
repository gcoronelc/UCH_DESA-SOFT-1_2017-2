use MICONDOMINIO;

go

create procedure usp_valida(
@usuario varchar(200),
@clave varchar(200)
) as
select p.PERSONA, p.TIPOPERSONA, p.NOMBRE, p.APELLIDO, p.DNI, p.TELEFONO, p.DIRECCION,
p.EMAIL, u.ROL
from persona p
inner join usuario u on p.PERSONA = u.PERSONA
where u.USUARIO = @usuario 
and u.CLAVE = HashBytes('SHA1',@clave);

GO

create procedure usp_creausuario(
@nombre		varchar(50),
@apellido	varchar(50),
@dni		varchar(15),
@telefono	varchar(50),
@direccion	varchar(100),
@email		varchar(60),
@tipoper	varchar(30),
@tipousu	varchar(40),
@usuario	varchar(20),
@clave		varchar(50)
)
as
	begin
		declare @idtipoper int, @idtipousu int, @idpersona int;
		select @idtipoper = TIPOPERSONA from TIPOPERSONA where NOMBRE = @tipoper;
		select @idtipousu = ROL from ROL where NOMBRE = @tipousu;

		-- inserta una nueva persona --
		insert into PERSONA(TIPOPERSONA, NOMBRE, APELLIDO, DNI, TELEFONO, DIRECCION, EMAIL)
		values(@idtipoper, @nombre, @apellido, @dni, @telefono, @direccion, @email);

		-- trae el id de la persona insertada --
		select @idpersona = SCOPE_IDENTITY();

		-- insera un nuevo usuario
		insert into USUARIO(PERSONA, ROL, USUARIO, CLAVE, ESTADO)
		values(@idpersona, @idtipousu, @usuario, HashBytes('SHA1',@clave), 1);
		


	end
go

create PROCEDURE usp_guardaInmueble(
@tipoinmueble	varchar(50),
@dni			varchar(15),
@piso			varchar(20),
@descripcion	varchar(200)
)
as

	begin
		declare @idtipoinmueble int, @idpersona int, @idpiso int, @idinmueble int, @importe decimal(10,2);
		select @idtipoinmueble = TIPOINMUEBLE, @importe = MANTENIMIENTO 
		from TIPOINMUEBLE where NOMBRE = @tipoinmueble;
		select @idpersona = PERSONA from PERSONA where DNI = @dni;
		select @idpiso = PISO from PISO where DESCRIPCION = @piso;
		-- inserta un inmueble --
		insert into INMUEBLE(TIPOINMUEBLE, PERSONA, PISO, CODIGO, DESCRIPCION, ACTIVO)
		values(@idtipoinmueble, @idpersona, @idpiso, concat('INMU-',@idtipoinmueble,@idpiso,@idpersona), 
		@descripcion, 1);
		-- trae el id del inmueble --
		select @idinmueble = SCOPE_IDENTITY();

		insert into OBLIGACION(OBLIGACION, TIPOOBLIGACION, INMUEBLE, PERSONA, ANIO, MES, FVENCE, IMPORTE,
		FECHA, REALIZADO)
		values(concat('OMANTE-0', @idinmueble),2, @idinmueble, @idpersona, YEAR(GETDATE()), MONTH(GETDATE()),
		EOMONTH(GETDATE()), @importe, concat(YEAR(GETDATE()),'-',MONTH(GETDATE()),'-01'), 0)
	end
GO

create procedure usp_registroMantenimiento(
@dni			varchar(15),
@obligacion		varchar(20),
@descripcion	varchar(200)
)
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