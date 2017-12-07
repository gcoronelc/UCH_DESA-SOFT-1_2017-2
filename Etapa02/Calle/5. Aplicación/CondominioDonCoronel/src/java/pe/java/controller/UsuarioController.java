package pe.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Usuario;
import pe.java.service.UsuarioService;
import pe.java.service.impl.UsuarioServiceImpl;

@Controller
public class UsuarioController {

    //IoC
    private UsuarioService usuarioService;

    public void setUsuarioService(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioService = usuarioServiceImpl;
    }
    
    @RequestMapping(params = "action=list")
    public ModelAndView listUsuario() {

        List<Usuario> list = usuarioService.list();
        ModelAndView mav = new ModelAndView("usuario/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newUsuario() {

        Usuario usuario = new Usuario();
        ModelAndView mav = new ModelAndView("usuario/new");
        mav.addObject("usuariox", usuario);
        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getUsuario(HttpServletRequest request) {

        String id = request.getParameter("id");
        Usuario usuario = usuarioService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("usuario/edit");
        mav.addObject("usuariox", usuario);

        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView saveUsuario(@ModelAttribute Usuario usuariox) {

        usuariox.setClave("123456");
        String result = usuarioService.insert(usuariox);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Usuario registrado correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "action=edit")
    public ModelAndView editUsuario(@ModelAttribute Usuario usuariox) {

        String result = usuarioService.update(usuariox);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Usuario actualizado correctamente.");
        } else {
            mav.addObject("msg", result);
        }
        return mav;
    }
    
}
