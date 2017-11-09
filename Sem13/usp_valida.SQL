
create procedure usp_valida(
@usuario varchar(200),
@clave varchar(200)
) as
select idpersona,idrol, usuario,estado
from usuario 
where usuario = @usuario 
and clave = HashBytes('SHA1',@clave);
GO

EXEC usp_valida 'gustavo', 'gustavo';
GO




