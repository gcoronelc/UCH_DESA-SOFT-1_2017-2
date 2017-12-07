package pe.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Administrador;
import pe.java.hibernate.Condominio;
import pe.java.hibernate.Usuario;
import pe.java.service.AdministradorService;
import pe.java.service.CondominioService;
import pe.java.service.UsuarioService;
import pe.java.service.impl.AdministradorServiceImpl;
import pe.java.service.impl.CondominioServiceImpl;
import pe.java.service.impl.UsuarioServiceImpl;

@Controller
public class AdministradorController {

    // IoC
    private AdministradorService administradorService;
    private UsuarioService usuarioService;
    private CondominioService condominioService;

    public void setAdministradorService(AdministradorServiceImpl administradorServiceImpl) {
        this.administradorService = administradorServiceImpl;
    }

    public void setUsuarioService(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioService = usuarioServiceImpl;
    }

    public void setCondominioService(CondominioServiceImpl condominioServiceImpl) {
        this.condominioService = condominioServiceImpl;
    }

    @RequestMapping(params = "action=list")
    public ModelAndView listAdministrador() {

        List<Administrador> list = administradorService.list();
        ModelAndView mav = new ModelAndView("administrador/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newAdministrador() {

        List<Usuario> ls_usuario = usuarioService.list();
        List<Condominio> ls_condominio = condominioService.list();
        
        Administrador administrador = new Administrador();
        ModelAndView mav = new ModelAndView("administrador/new");
        
        mav.addObject("administradorx", administrador);
        mav.addObject("ls_usuario", ls_usuario);
        mav.addObject("ls_condominio", ls_condominio);
        
        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getAdministrador(HttpServletRequest request) {

        String id = request.getParameter("id");
        
        List<Usuario> ls_usuario = usuarioService.list();
        List<Condominio> ls_condominio = condominioService.list();
        
        Administrador administrador = administradorService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("administrador/edit");
        mav.addObject("administradorx", administrador);
        mav.addObject("ls_usuario", ls_usuario);
        mav.addObject("ls_condominio", ls_condominio);
        
        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView saveAdministrador(@ModelAttribute Administrador administradorx) {

        String result = administradorService.insert(administradorx);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Administrador registrado correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "action=edit")
    public ModelAndView editAdministrador(@ModelAttribute Administrador administradorx) {

        String result = administradorService.update(administradorx);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Administrador actualizado correctamente.");
        } else {
            mav.addObject("msg", result);
        }
        return mav;
    }
}
