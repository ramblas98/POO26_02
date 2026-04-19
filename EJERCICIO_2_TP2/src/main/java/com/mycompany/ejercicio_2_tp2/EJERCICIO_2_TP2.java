/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio_2_tp2;

/**
 *
 * @author USUARIO
 */
public class EJERCICIO_2_TP2 {
    public static Complejo multiplicar(Complejo c1, Complejo c2){
        double nuevoReal = (c1.getReal() * c2.getReal()) - (c1.getImaginaria() * c2.getImaginaria()); // anteponemos el - para que haga el producto (-1)
        double nuevoImaginario = (c1.getReal() * c2.getImaginaria()) + (c1.getImaginaria()*c2.getReal());

        return new Complejo(nuevoReal,nuevoImaginario);
    }
    public static void main(String[] args) {
        Complejo c1 = new Complejo(3,2);
        Complejo c2 = new Complejo(1,7);
        
        
        c1.multiplicar(c2);
        System.out.println(c1);
        
        Complejo c3 = new Complejo(3,2);
        Complejo c4 = new Complejo(1,7);
        Complejo resultadoMultiplicacion = Complejo.multiplicar(c3,c4);
        System.out.println("Resultado de la Multiplicacion: "+resultadoMultiplicacion);
        
        Complejo c5 = new Complejo(4,3);
        double modulo = c5.modulo();
        double argumento = c5.argumento();
        System.out.println("Argumento: "+modulo+", Argumento: "+String.format("%.2f", argumento));
        
        Complejo c6 = new Complejo(2,2);
        Complejo c7 = new Complejo(3,8);
        c6.restar(c7);
        System.out.print("Resultado de la resta: ");
        System.out.println(c6);
        
        Complejo c8 = new Complejo(2,2);
        Complejo c9 = new Complejo(3,8);
        c6.dividir(c8);
        System.out.print("Resultado de la division: ");
        System.out.println(c8);
    }
}
