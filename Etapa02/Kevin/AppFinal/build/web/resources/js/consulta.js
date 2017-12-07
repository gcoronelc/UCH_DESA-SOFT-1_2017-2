/*
 <%-- 
 
 o   o                o          o    o                      8                             .oPYo.    
 8  .P                           8    8                      8                             8    8    
 o8ob'  .oPYo. o    o o8 odYo.   o8oooo8 o    o .oPYo. o    o 8oPYo. o    o .oPYo. .oPYo.   8         
 8  `b 8oooo8 Y.  .P  8 8' `8    8    8 8    8 .oooo8 8    8 8    8 8    8 .oooo8 Yb..     8         
 8   8 8.     `b..d'  8 8   8    8    8 8    8 8    8 8    8 8    8 8    8 8    8   'Yb.   8    8    
 8   8 `Yooo'  `YP'   8 8   8    8    8 `YooP' `YooP8 `YooP8 8    8 `YooP' `YooP8 `YooP'   `YooP' 88 
 :..::..:.....:::...:::....::..:::..:::..:.....::.....::....8 ..:::..:.....::.....::.....::::.....:..:
 ::::::::::::::::::::::::::::::::::::::::::::::::::::::::ooP'.::::::::::::::::::::::::::::::::::::::::
 ::::::::::::::::::::::::::::::::::::::::::::::::::::::::...::::::::::::::::::::::::::::::::::::::::::
 
 Proyecto    : KH-Condominio
 Creacion    : 30-nov-2017, 1:36:18
 Autor       : Kevin Huayhuas Cariapaza
 --%>
 */
$(document).ready(function () {
    $("#consultarmov").click(fnConsultar);
    $("#form").submit(fnConsultar);
    function fnConsultar(e) {
        e.preventDefault();
        var data = $("#form").serialize();
        $.ajax({
            url: "consultamovimiento.htm",
            type: 'POST',
            data: data,
            beforeSend: function () {
                $("#consultarmov").attr("disabled", "disabled");
                $("#consultarmov").html("Buscando...");
            }
        }).then(function (data) {
            var lista = $.parseJSON(data);
            $("#salida_consulta").html("");
            $.each(lista, function (index, r) {
                var row = "<tr>";
                row += "<td>" + r.inmueble_codigo + "</td>";
                row += "<td>" + r.inmueble_descripcion + "</td>";
                row += "<td>" + r.inmueble_torre + "</td>";
                row += "<td>" + r.obligacion_mes + " / " + r.obligacion_anio + "</td>";
                row += "<td>" + r.obligacion_fvence + "</td>";
                row += "<td>" + r.obligacion_importe + "</td>";
                row += "<td>" + r.tmovimiento_nombre + "</td>";
                row += "<td>" + r.tmovimiento_accion + "</td>";
                row += "<td>" + r.movimiento_fecha + "</td>";
                row += "<td>" + r.movimiento_importe + "</td>";
                row += "<td>" + r.persona_nombre + " " + r.persona_apellido + "</td>";
                row += "</tr>";
                $("#salida_consulta").append(row);
            });
            $('#tabla_consulta').DataTable();
            $("#tabla_consulta").show();

            $("#consultarmov").html("Consultar");
            $("#consultarmov").removeAttr("disabled");
        });


    }
});

