package pe.egcc.appsuma.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.appsuma.service.MateService;

@WebServlet({"/SumaController", "/RestaController"})
public class SumaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private MateService service;

    @Override
    public void init() throws ServletException {
        service = new MateService();
    }

    @Override
    protected void service(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();

        switch( path ){
            
            case "/SumaController":
                sumar(request, response);
                break;
                
            case "/RestaController":
                restar(request, response);
                break;
                
        }
          
    }

    
    
    protected void sumar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            // Datos
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));

            // Proceso
            int suma = service.sumar(n1, n2);

            // Reporte
            request.setAttribute("n1", n1);
            request.setAttribute("n2", n2);
            request.setAttribute("suma", suma);

        } catch (Exception e) {

            request.setAttribute("error", e.getMessage());

        }

        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }

    protected void restar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            // Datos
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));

            // Proceso
            int suma = service.restar(n1, n2);

            // Reporte
            request.setAttribute("n1", n1);
            request.setAttribute("n2", n2);
            request.setAttribute("suma", suma);

        } catch (Exception e) {

            request.setAttribute("error", e.getMessage());

        }

        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }
    
}
