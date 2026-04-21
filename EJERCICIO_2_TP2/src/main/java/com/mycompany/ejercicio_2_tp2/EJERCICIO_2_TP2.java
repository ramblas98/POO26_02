/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio_2_tp2;

/**
 *
 * @author USUARIO
 */
public class EJERCICIO_2_TP2 {
    //OTRA FORMA DE USAR LOS STATIC
    public static Complejo multiplicar(Complejo c1, Complejo c2){
        double nuevoReal = (c1.getReal() * c2.getReal()) - (c1.getImaginaria() * c2.getImaginaria()); // anteponemos el - para que haga el producto (-1)
        double nuevoImaginario = (c1.getReal() * c2.getImaginaria()) + (c1.getImaginaria()*c2.getReal());

        return new Complejo(nuevoReal,nuevoImaginario);
    }
    public static Complejo sumar(Complejo c1, Complejo c2){
        double resultadoReal = c1.getReal()+c2.getReal();
        double resultadoImaginario = c1.getImaginaria()+c2.getImaginaria();
        return new Complejo(resultadoReal,resultadoImaginario);
    }
    public static void main(String[] args) {
        Complejo c1 = new Complejo(3,2);
        Complejo c2 = new Complejo(1,7);
        
        //SUMA
        c1.sumar(c2);
        System.out.print("V1 Resultado de la suma:");
        System.out.println(c1);
        
        Complejo c14 = new Complejo(3,2);
        Complejo c15 = new Complejo(1,7);
        Complejo resultadoSuma = Complejo.sumar(c14, c15);
        System.out.println("V2 Resultado de la suma: "+resultadoSuma);
        
        Complejo c16 = new Complejo(3,2);
        Complejo c17 = new Complejo(1,7);
        Complejo resultadoSuma2 = EJERCICIO_2_TP2.sumar(c16, c17);
        System.out.println("V3 Resultado de la suma: "+resultadoSuma2);
        
        //MULTIPLICACION
        c1.multiplicar(c2);
        System.out.println(c1);
        
        Complejo c3 = new Complejo(3,2);
        Complejo c4 = new Complejo(1,7);
        Complejo resultadoMultiplicacion = Complejo.multiplicar(c3,c4);
        System.out.println("Resultado de la Multiplicacion: "+resultadoMultiplicacion);
        
        //MODULO Y ARGUMENTO
        Complejo c5 = new Complejo(4,3);
        double modulo = c5.modulo();
        double argumento = c5.argumento();
        System.out.println("Argumento: "+modulo+", Argumento: "+String.format("%.2f", argumento));
        
        //RESTA
        Complejo c6 = new Complejo(2,2);
        Complejo c7 = new Complejo(3,8);
        c6.restar(c7);
        System.out.print("Resultado de la resta: ");
        System.out.println(c6);
        
        //DIVISION
        Complejo c8 = new Complejo(2,2);
        Complejo c9 = new Complejo(3,8);
        c8.dividir(c9);
        System.out.print("Resultado de la division: ");
        System.out.println(c8);
        
        Complejo c10 = new Complejo(2,2);
        Complejo c11 = new Complejo(3,8);
        Complejo resultadoDivision = Complejo.dividir(c10, c11);
        System.out.println("Resultado de la division: "+ resultadoDivision);
        
        //SI SON IGUALES
        Complejo c12 = new Complejo(12,16);
        Complejo c13 = new Complejo(12,16);
        boolean b = c12.equals(c13);
        if(b){
            System.out.println("Son iguales");
        } else System.out.println("No son iguales");
    }
}
