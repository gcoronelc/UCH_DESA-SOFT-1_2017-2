package pe.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Evento;
import pe.java.service.EventoService;
import pe.java.service.impl.EventoServiceImpl;

@Controller
public class EventoController {

    //IoC
    private EventoService eventoService;

    public void setEventoService(EventoServiceImpl eventoServiceImpl) {
        this.eventoService = eventoServiceImpl;
    }
    
    @RequestMapping(params = "action=list")
    public ModelAndView listEvento() {

        List<Evento> list = eventoService.list();
        ModelAndView mav = new ModelAndView("evento/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newEvento() {

        Evento evento = new Evento();
        ModelAndView mav = new ModelAndView("evento/new");
        mav.addObject("eventox", evento);
        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getEvento(HttpServletRequest request) {

        String id = request.getParameter("id");
        Evento evento = eventoService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("evento/edit");
        mav.addObject("eventox", evento);

        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView saveEvento(@ModelAttribute Evento eventox) {

        String result = eventoService.insert(eventox);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Evento registrado correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }
    
    @RequestMapping(params = "action=edit")
    public ModelAndView editEvento(@ModelAttribute Evento eventox) {
        
        String result = eventoService.update(eventox);
        
        ModelAndView mav = new ModelAndView("mensaje");        
        if (result == null) {
            mav.addObject("msg", "Evento actualizado correctamente.");            
        } else {
            mav.addObject("msg", result);
        }        
        return mav;
    }
}
