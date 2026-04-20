/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_0;

import java.util.Objects;

/**
 *
 * @author profeblas
 */
public class Auto {
    private String patente;
    private int puertas;
    private boolean gnc;
    private float velocidadMax;

    public Auto() {
        System.out.println("Obj auto creado.");
        this.gnc = false;
    }

    public Auto(String patente, int puertas) {
        this.patente = patente;
        this.puertas = puertas;
        this.gnc = false;
         System.out.println("Obj "+ this.patente+" creado.");
    }

    public String getPatente() {
        return patente;
    }

    public int getPuertas() {
        return puertas;
    }

    public boolean isGnc() {
        return gnc;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public static void ponerGnc(Auto a) {
        System.out.println("Instalando equipo GNC.-");
        a.gnc = true;
    }
    
    public static int compararVelocidadMaxima(Auto a1, Auto a2){
        if(a1.velocidadMax==a2.velocidadMax)
            return 0;
        else if (a1.velocidadMax>a2.velocidadMax)
                return 1;
        else 
            return -1;
    }

    @Override
    public String toString() {
        return "Auto{" + "patente=" + patente + ", puertas=" + puertas + ", gnc=" + gnc + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // direccion de memoria
            return true;
        }
        if (obj == null) { // obj nulo
            return false;
        }
        if (getClass() != obj.getClass()) { // distinta clase
            return false;
        }
        // casteo - conversion hacia abajo
        final Auto other = (Auto) obj;
        
        if (this.puertas != other.puertas) {
            return false;
        }
        if (this.gnc != other.gnc) {
            return false;
        }
        return Objects.equals(this.patente, other.patente);
    }
    
    public void arrrancar(){
        System.out.println("RRRRRNNNNN");
    }
    
    public void frenar(){
        System.out.println("griiiiiiii");
    }
    
}
