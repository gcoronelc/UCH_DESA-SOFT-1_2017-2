package pe.java.controller;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Departamento;
import pe.java.hibernate.Visita;
import pe.java.service.DepartamentoService;
import pe.java.service.VisitaService;
import pe.java.service.impl.DepartamentoServiceImpl;
import pe.java.service.impl.VisitaServiceImpl;

@Controller
public class VisitaController {
    
    //IoC
    private VisitaService visitaService;
    private DepartamentoService departamentoService;

    public void setDepartamentoService(DepartamentoServiceImpl departamentoService) {
        this.departamentoService = departamentoService;
    }

    public void setVisitaService(VisitaServiceImpl visitaService) {
        this.visitaService = visitaService;
    }

    @RequestMapping(params = "action=list")
    public ModelAndView listVisita() {

        List<Visita> list = visitaService.list();
        ModelAndView mav = new ModelAndView("visita/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newVisita() {
        List<Departamento> usaDepa = departamentoService.list();
        Visita visita = new Visita();
        ModelAndView mav = new ModelAndView("visita/new");
        mav.addObject("usaDepa", usaDepa);
        mav.addObject("visitaox", visita);
        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView saveVisita(@ModelAttribute Visita visitaox) {
        visitaox.setFecha(new Date());
        String result = visitaService.insert(visitaox);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Visita registrada correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }
}
