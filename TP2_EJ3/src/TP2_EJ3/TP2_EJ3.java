/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TP2_EJ3;

/**
 *
 * @author alumno
 */
public class TP2_EJ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Racional r1,r2;

        r1 = new Racional();
        r2 = new Racional();
        System.out.println(r1);
        System.out.println(r2);


        System.out.println("--------------");

        r1 = new Racional(3,6);
        r1.simplificar();
        System.out.println(r1);
        System.out.println("--------------");

        r2 = new Racional(5,10);
        r2.simplificar();
        System.out.println(r2);

        Racional r3 = r1;
        System.out.println("--------------");
        if(r1.equals(r2)){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        System.out.println("--------------");

        System.out.println(r1);

        System.out.println("Pedir numerador usando Getter:");
        int numer = r1.getNumerador();
        System.out.println(numer);

        System.out.println("Pedir Denominador usando Getter:");
        int denom = r1.getDenominador();
        System.out.println(denom);

        System.out.println("--------------");

        System.out.println(r2);
        System.out.println("Cambiar numerador y denominador con Setter:");
        r2.setNumerador(2);

        r2.setDenominador(5);
        System.out.println(r2);

        System.out.println("--------------");
        System.out.println("Metodos de instancia:");

        Racional temp = new Racional(3,8);
        temp.simplificar();

        Racional temp2 = new Racional(5,10);
        temp2.simplificar();

        temp.sumar(temp2);
        System.out.println(temp);

        temp.restar(temp2);
        System.out.println(temp);

        temp.multiplicar(temp2);
        System.out.println(temp);

        temp.dividir(temp2);
        System.out.println(temp);

        System.out.println("--------------");
        System.out.println(r1 + " a decimal -> " + r1.aDecimal());
        System.out.println("--------------");
        System.out.println(r1.compareTo(r2));
        System.out.println("--------------");

        Racional suma = Racional.sumar(r1,r2);
        suma.simplificar();
        System.out.println(suma);
        System.out.println(r1 + "+" + r2 + "=" + suma);
        System.out.println("--------------");

        Racional resta = Racional.restar(r1,r2);
        resta.simplificar();
        System.out.println(resta);
        System.out.println(r1 + "-" + r2 + "=" + resta);
        System.out.println("--------------");

        Racional multi = Racional.multiplicar(r1,r2);
        multi.simplificar();
        System.out.println(multi);
        System.out.println(r1 + " * " + r2 + "=" + multi);
        System.out.println("--------------");

        Racional divi = Racional.dividir(r1,r2);
        divi.simplificar();
        System.out.println(divi);
        System.out.println(r1 + " / " + r2 + "=" + divi);
        System.out.println("--------------");
    }
    
}
