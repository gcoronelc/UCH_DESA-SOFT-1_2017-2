<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OBLIGACIONES DE MANTENIMIENTO</title>
</head>
<body>
	
	<h1>OBLIGACIONES DE MANTENIMIENTO</h1>
	
	<form id="form1">
	
	   <input type="hidden" name="tipo" value="2" />
	
	   <table>
	   
	       <tr>
	           <td>Periodo</td>
	           <td>Mes</td>
	       </tr>
	   
	       <tr>
               <td>
                   <select id="periodo" name="periodo">
                      <option value="2017">2017</option>
                      <option value="2018">2018</option>
                   </select>
               </td>
               <td>
                    <select id="mes" name="mes">
                        <option value="1">Enero</option>
                        <option value="2">Febrero</option>
                        <option value="3">Marzo</option>
                        <option value="4">Abril</option>
                        <option value="5">Mayo</option>
                        <option value="6">Junio</option>
                        <option value="7">Julio</option>
                        <option value="8">Agosto</option>
                        <option value="9">Setiembre</option>
                        <option value="10">Octubre</option>
                        <option value="11">Noviembre</option>
                        <option value="12">Diciembre</option>
                    </select>
               </td>
           </tr>
           
	   </table>
	
	</form>
	
	<h2>Obligaciones</h2>
	
	<table border="1">
	   <thead>
	       <tr>
	           <th>ID</th>
	           <th>INMUEBLE</th>
	           <th>CODIGO</th>
	           <th>TORRE</th>
	           <th>PISO</th>
	           <th>DESCRIPCION</th>
	           <th>OBLIGACION</th>
	           <th>AÑO</th>
	           <th>MES</th>
	           <th>IMPORTE</th>
	           <th>VENCIMIENTO</th>
	           <th>PAGADA</th>
	       </tr>
	   </thead>
	
	   <tbody id="tabla">
	   </tbody>
	
	</table>
	
	<div id="divGrabar" style="display: none;">
		<input id="btnGrabar" class="egcc_btn_default topspace" type="button" value="Grabar" />
	</div>
	
	<script>
	
	fnCargarTabla();
	
	$("#btnGrabar").click(function(){
		var data = $("#form1").serialize();
		$.post("grabarObliMant.htm",data,function(response){
			
			var objJson =  $.parseJSON(response);
			
			if( objJson.code == 1 ){
				fnCargarTabla();
				alert("Proceso ejecutado correctamente.");
			} else {
				alert(objJson.mensaje);
			}
			
			
		});
	});
	
	$("#periodo").change(fnCargarTabla);
	
	$("#mes").change(fnCargarTabla);
	
	function fnCargarTabla(){
		
		$("#divGrabar").hide();
		$("#tabla").html("");
		var data = $("#form1").serialize();
		
		$.post("leerObligaciones.htm", data, function(dataJson){
		
			var lista = $.parseJSON(dataJson);
			
			if( lista.length == 0 ) {
				
				$.post("generaObligaciones.htm", data, function(dataJson){
					var lista = $.parseJSON(dataJson);
					mostrarList(lista);
					$("#divGrabar").show();
				});
				
			} else {
				mostrarList(lista);	
			}
			
		});
		
	}
	
	function mostrarList(lista){
	   $.each(lista, function (index, r) {
            
            var row = "<tr>";
            row += "<td>" + r.id + "</td>";
            row += "<td>" + r.inmueble + "</td>";
            row += "<td>" + r.codigo + "</td>";
            row += "<td>" + r.torre + "</td>";
            row += "<td>" + r.piso + "</td>";
            row += "<td>" + r.descripcion + "</td>";
            row += "<td>" + r.nomobligacion + "</td>";
            row += "<td>" + r.anio + "</td>";
            row += "<td>" + r.mes + "</td>";
            row += "<td>" + r.importe + "</td>";
            row += "<td>" + r.vencimiento + "</td>";
            row += "<td>" + r.pagada + "</td>";
            row += "</tr>";
            
            $("#tabla").append( row );
            
        });
	}

	</script>
	
	
</body>
</html>