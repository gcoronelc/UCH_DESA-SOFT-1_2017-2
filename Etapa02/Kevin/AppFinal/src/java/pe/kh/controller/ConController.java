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
package pe.kh.controller;

import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.kh.model.Estado;
import pe.kh.model.Obligacion;
import pe.kh.model.Persona;


import pe.kh.service.ConService;

/**
 *
 * @author Kevin
 */
@Controller
public class ConController {

    @Autowired
    private ConService conService;

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "cuota.htm", method = RequestMethod.GET)
    public String cuota() {
        return "cuota";
    }

    @RequestMapping(value = "registro.htm", method = RequestMethod.GET)
    public String registro(Model model) {

        List<Map<String, Object>> inmuebles = conService.listaInmueble();
        model.addAttribute("inmuebles", inmuebles);

        List<Map<String, Object>> obligaciones = conService.listaObligacion();
        model.addAttribute("obligaciones", obligaciones);

        List<Map<String, Object>> tmovimientos = conService.listaTMovimiento();
        model.addAttribute("tmovimientos", tmovimientos);

        List<Map<String, Object>> audpersonas = conService.listaPersona();
        model.addAttribute("audpersonas", audpersonas);

        return "registro";
    }

    @RequestMapping(value = "consulta.htm", method = RequestMethod.GET)
    public String consulta() {
        return "consulta";
    }

    @RequestMapping(value = "consultamovimiento.htm", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String consultamovimiento(@RequestParam("tmovimiento") String tmovimiento, Model model) {
        // Proceso
        List<Map<String, Object>> lista;
        lista = conService.consultarMovimiento(tmovimiento);
        Gson gson = new Gson();
        String textJson = gson.toJson(lista);
        return textJson;
    }

    @RequestMapping(value = "registramovimientopago.htm", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String registramovimientopago(
            @RequestParam("inmueble") String inmueble,
            @RequestParam("obligacion") String obligacion,
            @RequestParam("tmovimiento") String tmovimiento,
            @RequestParam("fecha") String fecha,
            @RequestParam("importe") String importe,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("audpersona") String audpersona,
            Model model) {
        // Proceso
        String rpt;
        rpt = conService.crearPago(inmueble, obligacion, tmovimiento, fecha, importe, descripcion, audpersona);
        Gson gson = new Gson();
        String textJson = gson.toJson(rpt);
        return textJson;
    }

    //controller obligacion
    @RequestMapping(value = "grabarObliMant.htm",
            method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String grabarObliMant(
            @RequestParam("periodo") Integer periodo,
            @RequestParam("mes") Integer mes,
            @RequestParam("tipo") Integer tipo,
            HttpSession session
    ) {

        Estado estado = new Estado();

        try {

            int persona = (int) session.getAttribute("usuario");

            conService.creaCuotaMant(periodo, mes, persona);

            estado.setCode(1);
            estado.setMensaje("Proceso ejecutado correctamente.");

        } catch (Exception e) {
            estado.setCode(-1);
            estado.setMensaje("Error en el proceso " + e);
        }

        Gson gson = new Gson();
        String txtJson = gson.toJson(estado);

        return txtJson;
    }

    @RequestMapping(value = "obliMantenimiento.htm", method = RequestMethod.GET)
    public String obliMantenimiento() {
        return "obliMantenimiento";
    }

    @RequestMapping(value = "leerObligaciones.htm",
            method = RequestMethod.POST,
            produces = "application/json")
    public @ResponseBody
    String leerObligaciones(
            @RequestParam("periodo") Integer periodo,
            @RequestParam("mes") Integer mes,
            @RequestParam("tipo") Integer tipo) {

        List<Obligacion> lista = conService.leerObligaciones(periodo, mes, tipo);

        Gson gson = new Gson();
        String textJson = gson.toJson(lista);

        return textJson;
    }

    @RequestMapping(value = "generaObligaciones.htm",
            method = RequestMethod.POST,
            produces = "application/json")
    public @ResponseBody
    String generaObligaciones(
            @RequestParam("periodo") Integer periodo,
            @RequestParam("mes") Integer mes,
            @RequestParam("tipo") Integer tipo) {

        List<Obligacion> lista = conService.generaCuotaMant(periodo, mes);

        Gson gson = new Gson();
        String textJson = gson.toJson(lista);

        return textJson;
    }

    //LOGIN CONTROLLER
    @RequestMapping(value = "ingresar.htm", method = RequestMethod.POST)
    public String ingresar(
            @RequestParam("usuario") String usuario,
            @RequestParam("clave") String clave,
            Model model,
            HttpSession session) {

        String destino;

        try {

            Persona bean = conService.validarUsuario(usuario, clave);

            session.setAttribute("usuario", bean.getIdpersona());
            destino = "cuota";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            destino = "index";
        }

        return destino;
    }

    @RequestMapping(value = "salir.htm", method = RequestMethod.GET)
    public String salir(HttpSession session) {
        session.invalidate();
        return "index";
    }

}
