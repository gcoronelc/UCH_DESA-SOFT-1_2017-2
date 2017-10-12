package demo04;

public class MateController {

  private MateService service;

  public MateController(MateService service) {
    this.service = service;
  }
  
  public int sumar(int n1, int n2){
    return service.sumar(n1, n2);
  }

}
