package pe.java.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Condominio;
import pe.java.hibernate.Queja;
import pe.java.service.CondominioService;
import pe.java.service.QuejaService;
import pe.java.service.impl.CondominioServiceImpl;
import pe.java.service.impl.QuejaServiceImpl;

@Controller
public class QuejaController {

    //IoC
    private QuejaService quejaService;
    private CondominioService condominioService;

    public void setQuejaService(QuejaServiceImpl quejaServiceImpl) {
        this.quejaService = quejaServiceImpl;
    }

    public void setCondominioService(CondominioServiceImpl condominioServiceImpl) {
        this.condominioService = condominioServiceImpl;
    }

    @RequestMapping(params = "action=list")
    public ModelAndView listQueja() {

        List<Queja> list = quejaService.list();
        ModelAndView mav = new ModelAndView("queja/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newQueja() {
        
        List<Condominio> ls_condominio = condominioService.list();

        Queja queja = new Queja();
        ModelAndView mav = new ModelAndView("queja/new");
        mav.addObject("quejax", queja);
        mav.addObject("ls_condominio", ls_condominio);        
        
        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getQueja(HttpServletRequest request) {

        String id = request.getParameter("id");
        
        List<Condominio> ls_condominio = condominioService.list();
        
        Queja queja = quejaService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("queja/edit");
        mav.addObject("quejax", queja);
        mav.addObject("ls_condominio", ls_condominio);
        
        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView saveQueja(@ModelAttribute Queja quejax) {

        quejax.setFecha(new Date());
        String result = quejaService.insert(quejax);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Queja registrada correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "action=edit")
    public ModelAndView editQueja(@ModelAttribute Queja quejax) {
        
        quejax.setFecha(new Date());
        String result = quejaService.update(quejax);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Queja actualizada correctamente.");
        } else {
            mav.addObject("msg", result);
        }
        return mav;
    }
}
