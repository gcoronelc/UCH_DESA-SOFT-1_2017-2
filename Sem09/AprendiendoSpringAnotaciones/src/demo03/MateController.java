package demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MateController {

	@Autowired
	private MateService service;

	public int sumar(int n1, int n2) {
		return service.sumar(n1, n2);
	}

}
