package pe.java.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Cuota;
import pe.java.hibernate.Evento;
import pe.java.service.CuotaService;
import pe.java.service.EventoService;
import pe.java.service.impl.CuotaServiceImpl;
import pe.java.service.impl.EventoServiceImpl;

@Controller
public class CuotaController {

    // IoC
    private CuotaService cuotaService;
    private EventoService eventoService;

    public void setCuotaService(CuotaServiceImpl cuotaServiceImpl) {
        this.cuotaService = cuotaServiceImpl;
    }

    public void setEventoService(EventoServiceImpl eventoServiceImpl) {
        this.eventoService = eventoServiceImpl;
    }

    @RequestMapping(params = "action=list")
    public ModelAndView listCuota() {

        List<Cuota> list = cuotaService.list();
        ModelAndView mav = new ModelAndView("cuota/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newCuota() {

        List<Evento> ls_evento = eventoService.list();
        
        Cuota cuota = new Cuota();
        ModelAndView mav = new ModelAndView("cuota/new");
        mav.addObject("cuotax", cuota);
        mav.addObject("ls_evento", ls_evento);
        
        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getCuota(HttpServletRequest request) {

        String id = request.getParameter("id");
        
        List<Evento> ls_evento = eventoService.list();
        
        Cuota cuota = cuotaService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("cuota/edit");
        mav.addObject("cuotax", cuota);
        mav.addObject("ls_evento", ls_evento);
        
        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView saveCuota(@ModelAttribute Cuota cuotax) {

        cuotax.setTermina(new Date());
        
        String result = cuotaService.insert(cuotax);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Cuota registrado correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "action=edit")
    public ModelAndView editCuota(@ModelAttribute Cuota cuotax) {

        String result = cuotaService.update(cuotax);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Cuota actualizado correctamente.");
        } else {
            mav.addObject("msg", result);
        }
        return mav;
    }
}
