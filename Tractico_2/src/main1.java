import java.util.Scanner;

public class main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,d;
        Racional r1,r2;
        r1 = new Racional();
        r2 = new Racional();
        System.out.println(r1);
        System.out.println(r2);
        System.out.println("Ingrese numerador: ");
        n = sc.nextInt();
        System.out.println("Ingrese denominador: ");
        d = sc.nextInt();

        r1 = new Racional(n,d);
        r1.simplificar();
        System.out.println(r1);

        System.out.println("Ingrese numerador: ");
        n = sc.nextInt();
        System.out.println("Ingrese denominador: ");
        d = sc.nextInt();

        r2 = new Racional(n,d);
        r2.simplificar();
        System.out.println(r2);

        Racional suma = Racional.sumar(r1,r2);
        suma.simplificar();
        System.out.println(suma);
        System.out.println(r1 + "+" + r2 + "=" + suma);

        Racional resta = Racional.restar(r1,r2);
        resta.simplificar();
        System.out.println(resta);
        System.out.println(r1 + "-1" + r2 + "=" + resta);
        
    }
}
