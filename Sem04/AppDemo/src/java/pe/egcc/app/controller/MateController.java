package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.model.MateModel;
import pe.egcc.app.service.MateService;

@WebServlet(name = "MateController", urlPatterns = {"/MateController"})
public class MateController extends HttpServlet {

    private MateService service;

    @Override
    public void init() throws ServletException {
        service = new MateService();
    }
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Datos
        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));
        MateModel model = new MateModel(n1,n2);
                
        // Proceso
        model = service.procesar(model);

        // Forward
        request.setAttribute("model", model);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
        
    }


}
