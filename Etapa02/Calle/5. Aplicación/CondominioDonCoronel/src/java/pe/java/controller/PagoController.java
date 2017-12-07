package pe.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.java.hibernate.Pago;
import pe.java.service.PagoService;
import pe.java.service.impl.PagoServiceImpl;

@Controller
public class PagoController {

    //IoC
    private PagoService pagoService;

    public void setPagoService(PagoServiceImpl pagoServiceImpl) {
        this.pagoService = pagoServiceImpl;
    }

    @RequestMapping(params = "action=list")
    public ModelAndView listPago() {

        List<Pago> list = pagoService.list();
        ModelAndView mav = new ModelAndView("pago/list");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(params = "action=new")
    public ModelAndView newPago() {

        Pago pago = new Pago();
        ModelAndView mav = new ModelAndView("pago/new");
        mav.addObject("pagox", pago);
        return mav;
    }

    @RequestMapping(params = "action=get")
    public ModelAndView getPago(HttpServletRequest request) {

        String id = request.getParameter("id");
        Pago pago = pagoService.get(Integer.valueOf(id));
        ModelAndView mav = new ModelAndView("pago/edit");
        mav.addObject("pagox", pago);

        return mav;
    }

    @RequestMapping(params = "action=save")
    public ModelAndView savePago(@ModelAttribute Pago pagox) {

        String result = pagoService.insert(pagox);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Pago registrado correctamente.");
        } else {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "action=edit")
    public ModelAndView editPago(@ModelAttribute Pago pagox) {

        String result = pagoService.update(pagox);

        ModelAndView mav = new ModelAndView("mensaje");
        if (result == null) {
            mav.addObject("msg", "Pago actualizado correctamente.");
        } else {
            mav.addObject("msg", result);
        }
        return mav;
    }
}
