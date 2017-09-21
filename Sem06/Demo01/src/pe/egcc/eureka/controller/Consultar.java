package pe.egcc.eureka.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.eureka.service.impl.EurekaServiceImpl;
import pe.egcc.eureka.service.spec.EurekaServiceSpec;


@WebServlet("/Consultar")
public class Consultar extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Dato
		String cuenta = request.getParameter("cuenta");
		
		// Proceso
		EurekaServiceSpec service;
		service = new EurekaServiceImpl();
		List<Map<String,Object>> lista;
		lista = service.conMovimientos(cuenta);
		
		// Forward
		request.setAttribute("lista", lista);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

	

}
