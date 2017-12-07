package pe.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavegaController {
    
    @RequestMapping(params = "action=login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
}
