
package pagoapp.model;


public class PagoModel {
    
    //Imput
    private int horasDia;
    private int dias;
    private double pagoHora;
    
    //Output
    private double ingresos;
    private double renta;
    private double neto;

   /**
    * Constructor por defecto
    */
    
    public PagoModel() {
    }
/**
 * Constructor adicional.
 * @param horasDia
 * @param dias
 * @param pagoHora 
 */
    public PagoModel(int horasDia, int dias, double pagoHora) {
        this.horasDia = horasDia;
        this.dias = dias;
        this.pagoHora = pagoHora;
    }

    public int getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(int horasDia) {
        this.horasDia = horasDia;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getPagoHora() {
        return pagoHora;
    }

    public void setPagoHora(double pagoHora) {
        this.pagoHora = pagoHora;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public double getRenta() {
        return renta;
    }

    public void setRenta(double renta) {
        this.renta = renta;
    }

    public double getNeto() {
        return neto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public void SetIngresos(double ingresos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
