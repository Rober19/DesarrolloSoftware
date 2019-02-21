
package Entities;

import java.io.Serializable;

/**
 *
 * @author Rober19
 */
public class Operacion implements Serializable{
    private Double valor1;
    private Double valor2;
    private String operacion;

    public Operacion(Double valor1, Double valor2, String operacion) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.operacion = operacion;
    }   
    
    Operacion(){
        
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }    
    

    public Double getValor1() {
        return valor1;
    }

    public void setValor1(Double valor1) {
        this.valor1 = valor1;
    }

    public Double getValor2() {
        return valor2;
    }

    public void setValor2(Double valor2) {
        this.valor2 = valor2;
    }    
        
}
