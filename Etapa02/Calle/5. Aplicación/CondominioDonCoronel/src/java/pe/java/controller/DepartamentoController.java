package pe.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Cuota;
import pe.java.hibernate.Departamento;
import pe.java.hibernate.Edificio;
import pe.java.service.DepartamentoService;
import pe.java.service.EdificioService;
import pe.java.service.impl.DepartamentoServiceImpl;
import pe.java.service.impl.EdificioServiceImpl;

@Controller
public class DepartamentoController {

    //IoC
    private DepartamentoService departamentoService;
    private EdificioService edificioService;

    public void setDepartamentoService(DepartamentoServiceImpl departamentoServiceImpl) {
        this.departamentoService = departamentoServiceImpl;
    }

    public void setEdificioService(EdificioServiceImpl edificioServiceImpl) {
        this.edificioService = edificioServiceImpl;
    }

    @RequestMapping(params = "action=list")
    public ModelAndView listDepartamento() {

        List<Departamento> list = departamentoService.list();
        ModelAndView mav = new ModelAndView("departamento/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newDepartamento() {

        List<Edificio> ls_edificio = edificioService.list();

        Departamento departamento = new Departamento();
        ModelAndView mav = new ModelAndView("departamento/new");
        mav.addObject("departamentox", departamento);
        mav.addObject("ls_edificio", ls_edificio);

        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getDepartamento(HttpServletRequest request) {

        String id = request.getParameter("id");
        
        List<Edificio> ls_edificio = edificioService.list();
        
        Departamento departamento = departamentoService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("departamento/edit");
        mav.addObject("departamentox", departamento);
        mav.addObject("ls_edificio", ls_edificio);
        
        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView saveDepartamento(@ModelAttribute Departamento departamentox) {

        String result = departamentoService.insert(departamentox);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Departamento registrado correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "action=edit")
    public ModelAndView editDepartamento(@ModelAttribute Departamento departamentox) {

        String result = departamentoService.update(departamentox);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Departamento actualizado correctamente.");
        } else {
            mav.addObject("msg", result);
        }
        return mav;
    }
}
