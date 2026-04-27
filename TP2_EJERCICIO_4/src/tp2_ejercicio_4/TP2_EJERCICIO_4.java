/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package tp2_ejercicio_4;
import java.util.Arrays;
/**
 *
 * @author Pc
 */

public class TP2_EJERCICIO_4 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // Ejercicio 4
        
        //Los coeficientes se cargan de atras para adelante
        double[] listaCoef1 = {7,-10,2,4,3}; 
        double[] listaCoef2 = {2,-5,3};
        double[] listaCoef3 = {-4,3,-3,0,2};
        double[] listaCoef4 = {2,-1};
        
        //Ingresar Polinomio
        //Instancia un objeto
        //Polinomio p1= new Polinomio();
        //p1.ingresarPolinomio();
        //System.out.println(p1.toString());
        
        
        //Agregar Coeficiente
        //p1.agregarCoeficiente(-10,5);
        //System.out.println(p1.toString());
        
        
        Polinomio miPoli1 = new Polinomio(listaCoef1);
        miPoli1.setGrado(4);
        Polinomio miPoli2 = new Polinomio(listaCoef2);
        miPoli2.setGrado(2);
        Polinomio miPoli3 = new Polinomio(listaCoef3);
        miPoli3.setGrado(4);
        Polinomio miPoli4 = new Polinomio(listaCoef4);
        miPoli4.setGrado(1);
       
        //GET COEFICIENTE
        System.out.println(miPoli1.getCoeficiente(1));
       
       //GET COEFICIENTES
       //double[] aux = miPoli1.getCoeficientes();
       System.out.println(Arrays.toString(miPoli1.getCoeficientes()));
       
       
       
        //Suma de Polinomios (operacion de instancia)
        miPoli1.sumar(miPoli2);
        System.out.println("Resultado de la suma de Polinomio1 y Polinomio2: ");
        System.out.println(miPoli1.toString());
       /* */
        
        miPoli3.restar(miPoli4);
        System.out.println("Resultado de la resta de Polinomio3 y Polinomio4: ");
        System.out.println(miPoli2.toString());
        
        
       
        //GETTER
        System.out.println(miPoli1.getGrado());
        
        //SETTER
        miPoli1.setGrado(3);
        System.out.println("Nuevo grado de Polinomio 1: " );
        System.out.println(miPoli1.getGrado());
        System.out.println(miPoli1.toString());
        
       
       //Division de Polinomios
       System.out.println("Division: ");
       Polinomio[] resultado = miPoli1.dividir(miPoli2);
       Polinomio cociente= resultado[0];
       Polinomio resto= resultado[1];
       
       System.out.println("Resultados de la Division");
       System.out.print("COCIENTE: ");
       System.out.println(cociente.toString());
       System.out.print("RESTO: ");
       System.out.println(resto.toString());
        
       //Multiplicacion
        System.out.println("Multiplicacion: ");
        Polinomio prod;
        prod = Polinomio.multiplicar(miPoli2, miPoli4);
        System.out.println(prod.toString());
       
       
      //Evaluar un polinomio en un punto
      System.out.println("Resultado de evaluar en polinomio en un punto: ");
      System.out.println(miPoli3.evaluar(-2));
        
       
      //Derivar
      System.out.println("Resultado Derivar: ");
      System.out.println(miPoli3.derivar().toString());
        
        
        
    //Prueba integrar un Polinomio
    System.out.println("Integral: ");
    System.out.println(miPoli3.integrar().toString());
    
    
    //Prueba calcular raices
    System.out.println("Raices: ");
    double[] raices;// = new double[2];
     
    raices = miPoli2.calcularRaices();
    
    System.out.println(raices[0]);
    System.out.println(raices[1]);
     /**/
       
     
     //EQUALS
     System.out.println(miPoli1.equals(miPoli2));
         
    }

}