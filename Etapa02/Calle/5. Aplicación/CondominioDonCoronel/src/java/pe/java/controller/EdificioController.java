package pe.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Condominio;
import pe.java.hibernate.Edificio;
import pe.java.service.CondominioService;
import pe.java.service.EdificioService;
import pe.java.service.impl.CondominioServiceImpl;
import pe.java.service.impl.EdificioServiceImpl;

@Controller
public class EdificioController {
    
    // IoC
    private EdificioService edificioService;
    private CondominioService condominioService;

    public void setEdificioService(EdificioServiceImpl edificioServiceImpl) {
        this.edificioService = edificioServiceImpl;
    }

    public void setCondominioService(CondominioServiceImpl condominioServiceImpl) {
        this.condominioService = condominioServiceImpl;
    }
    
    @RequestMapping(params = "action=list")
    public ModelAndView listCondominio() {

        List<Edificio> list = edificioService.list();
        ModelAndView mav = new ModelAndView("edificio/list");
        mav.addObject("list", list);
        return mav;
    }
    
    @RequestMapping(params = "action=new")
    public ModelAndView newCondominio() {
        
        List<Condominio> ls_condominio = condominioService.list();
        
        Edificio edificio = new Edificio();  
        ModelAndView mav = new ModelAndView("edificio/new");
        mav.addObject("edificiox", edificio);
        mav.addObject("ls_condominio", ls_condominio);
        
        return mav;
    }
    
    @RequestMapping(params = "action=get")
    public ModelAndView getCondominio(HttpServletRequest request) {
        
        List<Condominio> ls_condominio = condominioService.list();
        
        String id = request.getParameter("id");
        Edificio edificio = edificioService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("edificio/edit");
        mav.addObject("edificiox", edificio);
        mav.addObject("ls_condominio", ls_condominio);
        
        return mav;
    }
    
    @RequestMapping(params = "action=save")
    public ModelAndView saveCondominio(@ModelAttribute Edificio edificiox) {
        
        String result = edificioService.insert(edificiox);
        
        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Edificio registrado correctamente.");            
        } else {
            mav.addObject("msg", result);
        }        
        
        return mav;
    }
    
    @RequestMapping(params = "action=edit")
    public ModelAndView editCondominio(@ModelAttribute Edificio edificiox) {
        
        String result = edificioService.update(edificiox);
        
        ModelAndView mav = new ModelAndView("mensaje");        
        if (result == null) {
            mav.addObject("msg", "Condominio actualizado correctamente.");            
        } else {
            mav.addObject("msg", result);
        }        
        return mav;
    }
    
}
