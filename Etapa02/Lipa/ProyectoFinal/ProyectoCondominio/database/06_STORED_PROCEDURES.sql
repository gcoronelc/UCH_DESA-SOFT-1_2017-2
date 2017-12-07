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

--EXEC usp_valida 'alonso', 'lipa';
--GO

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
-- trabajador = 3 | administrador = 2 --
execute usp_creausuario 'Adriel', 'Ordoñez', '7400000', '987654321', 'algun lugar', 'adriel@gmail.com',
'TRABAJADOR', 'ADMINISTRADOR', 'ADM74000000', 'arturocabro';

select * from usuario;
select * from persona;

select TP.NOMBRE, P.NOMBRE, P.APELLIDO, R.NOMBRE, U.USUARIO, U.CLAVE
from PERSONA P
inner join TIPOPERSONA TP ON P.TIPOPERSONA = TP.TIPOPERSONA
inner join USUARIO U ON U.PERSONA = P.PERSONA
inner join ROL R ON U.ROL = R.ROL
where U.ESTADO = 1;

