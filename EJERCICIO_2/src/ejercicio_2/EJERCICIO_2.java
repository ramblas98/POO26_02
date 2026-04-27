/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_2;

/**
 *
 * @author Hp
 */
public class EJERCICIO_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Complejo c1 = new Complejo(2, 2);
        Complejo c2 = new Complejo(1, -4);

        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);

        // Métodos estáticos
        System.out.println("Suma: " + Complejo.sumar(c1, c2));
        System.out.println("Resta: " + Complejo.restar(c1, c2));
        System.out.println("Multiplicacion: " + Complejo.multiplicar(c1, c2));
        System.out.println("Division: " + Complejo.dividir(c1, c2));

        // Métodos de instancia
        c1.sumar(c2);
        System.out.println("c1 despues de sumar: " + c1);

        // Otros métodos
        System.out.println("Modulo: " + c1.modulo());
        System.out.println("Argumento: " + c1.argumento());
        System.out.println("Conjugado: " + c1.conjugado());
        System.out.println("Opuesto: " + c1.opuesto());
        System.out.println("Potencia (c1^3): " + c1.potencia(3));
        System.out.println(c1.equals(c2));
        c2 = c1;
        System.out.println(c1.equals(c2));
    }
    
}
