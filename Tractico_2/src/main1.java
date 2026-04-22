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
        System.out.println("--------------");

        System.out.println("Ingrese numerador: ");
        n = sc.nextInt();
        System.out.println("Ingrese denominador: ");
        d = sc.nextInt();

        r1 = new Racional(n,d);
        r1.simplificar();
        System.out.println(r1);
        System.out.println("--------------");

        System.out.println("Ingrese numerador: ");
        n = sc.nextInt();
        System.out.println("Ingrese denominador: ");
        d = sc.nextInt();

        r2 = new Racional(n,d);
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
        System.out.println("Cambiar numerador con Setter:");
        r2.setNumerador(2);
        System.out.println("Cambiar denominador con Setter:");
        r2.setDenominador(5);
        System.out.println(r2);
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
        System.out.println(r1 + "*" + r2 + "=" + multi);
        System.out.println("--------------");

        Racional divi = Racional.dividir(r1,r2);
        divi.simplificar();
        System.out.println(divi);
        System.out.println(r1 + "/" + r2 + "=" + divi);
        System.out.println("--------------");
    }
}
