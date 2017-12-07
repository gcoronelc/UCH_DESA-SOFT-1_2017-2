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
    fnCargarTabla();

    $("#btnGrabar").click(function () {
        var data = $("#form1").serialize();
        $.post("grabarObliMant.htm", data, function (response) {

            var objJson = $.parseJSON(response);

            if (objJson.code == 1) {
                fnCargarTabla();
                alert("Proceso ejecutado correctamente.");
            } else {
                alert(objJson.mensaje);
            }


        });
    });

    $("#periodo").change(fnCargarTabla);

    $("#mes").change(fnCargarTabla);

    function fnCargarTabla() {

        $("#divGrabar").hide();
        $("#tabla").html("");
        var data = $("#form1").serialize();

        $.post("leerObligaciones.htm", data, function (dataJson) {

            var lista = $.parseJSON(dataJson);

            if (lista.length == 0) {

                $.post("generaObligaciones.htm", data, function (dataJson) {
                    var lista = $.parseJSON(dataJson);
                    mostrarList(lista);
                    $("#divGrabar").show();
                });

            } else {
                mostrarList(lista);
            }

        });

    }

    function mostrarList(lista) {
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

            $("#tabla").append(row);

        });

        $('#tabla_cuota').DataTable();
    }
});

