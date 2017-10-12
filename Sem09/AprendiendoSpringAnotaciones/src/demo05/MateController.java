package demo05;

public class MateController {

  private MateService service;
  private String nombre;
  private String ciudad;

  public MateController(MateService service,
      String nombre, String ciudad) {
    this.service = service;
    this.nombre = nombre;
    this.ciudad = ciudad;
  }
  
  public int sumar(int n1, int n2){
    System.out.println("Nombre: " + nombre);
    System.out.println("Ciudad: " + ciudad);
    return service.sumar(n1, n2);
  }

}
