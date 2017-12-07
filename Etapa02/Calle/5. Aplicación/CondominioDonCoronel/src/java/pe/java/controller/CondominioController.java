package pe.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Condominio;
import pe.java.service.CondominioService;
import pe.java.service.impl.CondominioServiceImpl;

@Controller
public class CondominioController {

    // IoC
    private CondominioService condominioService;

    public void setCondominioService(CondominioServiceImpl condominioService) {
        this.condominioService = condominioService;
    }

    @RequestMapping(params = "action=list")
    public ModelAndView listCondominio() {

        List<Condominio> list = condominioService.list();
        ModelAndView mav = new ModelAndView("condominio/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newCondominio() {
        
        Condominio condominio = new Condominio();        
        ModelAndView mav = new ModelAndView("condominio/new");
        mav.addObject("condominiox", condominio);
        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getCondominio(HttpServletRequest request) {
        
        String id = request.getParameter("id");
        Condominio condominio = condominioService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("condominio/edit");
        mav.addObject("condominiox", condominio);
        
        return mav;
    }
    
    
    @RequestMapping(params = "action=save")
    public ModelAndView saveCondominio(@ModelAttribute Condominio condominiox) {
        
        String result = condominioService.insert(condominiox);
        
        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Condominio registrado correctamente.");            
        } else {
            mav.addObject("msg", result);
        }        
        
        return mav;
    }
     
    /*
    @RequestMapping(params = "action=save")
    public String saveCondominio(@ModelAttribute Condominio condominiox) {        
        String result = condominioService.insert(condominiox);
        return "redirect:/condominio.htm?action=list";
    }
    */    
    
    
    @RequestMapping(params = "action=edit")
    public ModelAndView editCondominio(@ModelAttribute Condominio condominiox) {
        
        String result = condominioService.update(condominiox);
        
        ModelAndView mav = new ModelAndView("mensaje");        
        if (result == null) {
            mav.addObject("msg", "Condominio actualizado correctamente.");            
        } else {
            mav.addObject("msg", result);
        }        
        return mav;
    }
    
    
    /*
    @RequestMapping(params = "action=edit")
    public String editCondominio(@ModelAttribute Condominio condominiox) {                
        String result = condominioService.update(condominiox); 
        return "redirect:/condominio.htm?action=list";
    }
    */ 
}
