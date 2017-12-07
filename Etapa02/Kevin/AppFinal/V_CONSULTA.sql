use micondominio;
/*Creando vista para consulta de movimiento*/
CREATE VIEW consultaMovimiento AS
select 
inm.codigo as inmueble_codigo,
inm.descripcion as inmueble_descripcion,
inm.idtorre as inmueble_torre,
obl.anio as obligacion_anio,
obl.mes as obligacion_mes,
obl.fvence as obligacion_fvence,
obl.importe as obligacion_importe,
tmo.nombre as tmovimiento_nombre,
tmo.accion as tmovimiento_accion,
mov.fecha as movimiento_fecha,
mov.importe as movimiento_importe,
mov.descripcion as movimiento_descripcion,
p.dni as persona_dni,
p.nombre as persona_nombre,
p.apellido as persona_apellido
from movimiento as mov
inner join inmueble as inm on inm.idinmueble = mov.idinmueble
inner join obligacion as obl on obl.idobligacion = mov.idobligacion
inner join tmovimiento as tmo on tmo.idtmovimiento = mov.idtmovimiento
inner join persona as p on p.idpersona = mov.audidpersona;

