/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_0;

/**
 *
 * @author profeblas
 */
public class EJERCICIO_0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("Buena suerte!!");
        
        Auto a1 = new Auto();
        //a1.arrrancar();
        //a1.frenar();
        Auto a2 = new Auto("EYU722",5);
        
        Auto a3 = new Auto("EYU722",5);
        Auto a4 = a1;
        Auto a5 = null;
        String a6 = "Auto 6";
        
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        
        System.out.println(a4.equals(a1)?"Son iguales":"Son distintos");
        System.out.println(a1.equals(a5)?"Son iguales":"Son distintos");
        System.out.println(a1.equals(a6)?"Son iguales":"Son distintos");
        System.out.println(a3.equals(a2)?"Son iguales":"Son distintos");
        
        Auto.ponerGnc(a2);
        System.out.println(a2);
        
        if(Auto.compararVelocidadMaxima(a1, a2)==0)
            System.out.println("Tienen la misma velocidad maxima.");
        else
            if(Auto.compararVelocidadMaxima(a1, a2)>0)
                System.out.println(a1 +"es mas rapido que " +a2);
            else
                System.out.println(a2 +"es mas rapido que " +a1);
    }
    
}
