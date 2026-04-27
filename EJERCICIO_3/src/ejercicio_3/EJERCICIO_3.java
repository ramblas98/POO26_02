/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_3;
/**
 *
 * @author Hp
 */
public class EJERCICIO_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Racional r1 = new Racional(16, 8);
        Racional r2 = new Racional(4, 5);

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);

        // Estáticos
        System.out.println("Suma: " + Racional.sumar(r1, r2));
        System.out.println("Resta: " + Racional.restar(r1, r2));
        System.out.println("Multiplicacion: " + Racional.multiplicar(r1, r2));
        System.out.println("Division: " + Racional.dividir(r1, r2));

        // Instancia
        r1.sumar(r2);
        System.out.println("r1 despues de sumar: " + r1);

        // Otros
        System.out.println("Decimal: " + r1.aDecimal());
        System.out.println("Comparacion r1 vs r2: " + r1.compareTo(r2));
        
        System.out.println(r1.equals(r2));
        r2 = r1;
        System.out.println(r1.equals(r2));
    }
    
}
