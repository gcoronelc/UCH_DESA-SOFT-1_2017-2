package pe.egcc.condominio.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;


@ControllerAdvice
public class AdvisorController {
	Logger LOGGER = LoggerFactory.getLogger(AdvisorController.class);

	@ExceptionHandler({ NoHandlerFoundException.class,
			NoSuchRequestHandlingMethodException.class,
			HttpClientErrorException.class })
	public String handle(Exception ex) {
		LOGGER.info("#AdvisorController.NoHandlerFoundException");
		LOGGER.info("#Exception : {}", ex.getMessage());
		return "erro/404";
	}

	@ExceptionHandler(Exception.class)
	public String internalError(Exception ex) {
		ex.printStackTrace();
		LOGGER.info("#AdvisorController.internalError");
		LOGGER.info("#Exception Class : {}", ex.getClass());
		LOGGER.info("#Exception : {}", ex.getMessage());
		return "erro/500";
	}

}
