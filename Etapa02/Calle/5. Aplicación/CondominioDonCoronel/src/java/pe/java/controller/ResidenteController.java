package pe.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Departamento;
import pe.java.hibernate.Residente;
import pe.java.hibernate.Usuario;
import pe.java.service.DepartamentoService;
import pe.java.service.ResidenteService;
import pe.java.service.UsuarioService;
import pe.java.service.impl.DepartamentoServiceImpl;
import pe.java.service.impl.ResidenteServiceImpl;
import pe.java.service.impl.UsuarioServiceImpl;

@Controller
public class ResidenteController {

    //IoC
    private ResidenteService residenteService;
    private UsuarioService usuarioService;
    private DepartamentoService departamentoService;

    public void setResidenteService(ResidenteServiceImpl residenteServiceImpl) {
        this.residenteService = residenteServiceImpl;
    }

    public void setUsuarioService(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioService = usuarioServiceImpl;
    }

    public void setDepartamentoService(DepartamentoServiceImpl departamentoServiceImpl) {
        this.departamentoService = departamentoServiceImpl;
    }

    @RequestMapping(params = "action=list")
    public ModelAndView listResidente() {

        List<Residente> list = residenteService.list();
        ModelAndView mav = new ModelAndView("residente/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newResidente() {

        List<Usuario> ls_usuario = usuarioService.list();
        List<Departamento> ls_departamento = departamentoService.list();

        Residente residente = new Residente();
        ModelAndView mav = new ModelAndView("residente/new");
        mav.addObject("residentex", residente);
        mav.addObject("ls_usuario", ls_usuario);
        mav.addObject("ls_departamento", ls_departamento);

        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getResidente(HttpServletRequest request) {

        String id = request.getParameter("id");
        
        List<Usuario> ls_usuario = usuarioService.list();
        List<Departamento> ls_departamento = departamentoService.list();
        
        Residente residente = residenteService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("residente/edit");
        mav.addObject("residentex", residente);
        mav.addObject("ls_usuario", ls_usuario);
        mav.addObject("ls_departamento", ls_departamento);
        
        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView saveResidente(@ModelAttribute Residente residentex) {

        String result = residenteService.insert(residentex);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Residente registrado correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "action=edit")
    public ModelAndView editResidente(@ModelAttribute Residente residentex) {

        String result = residenteService.update(residentex);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Residente actualizado correctamente.");
        } else {
            mav.addObject("msg", result);
        }
        return mav;
    }
}
