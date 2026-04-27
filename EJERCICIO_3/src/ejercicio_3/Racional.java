/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_3;

/**
 *
 * @author Hp
 */
public class Racional {
    private int numerador;
    private int denominador;

    // CONSTRUCTORES
    public Racional() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            System.out.println("Denominador no puede ser 0");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    // GETTERS 
    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }
    // SETTERS
    public void setNumerador(int numerador) {
        this.numerador = numerador;
        simplificar();
    }

    public void setDenominador(int denominador) {
        if (denominador == 0) {
            System.out.println("Denominador no puede ser 0");
        }
        this.denominador = denominador;
        simplificar();
    }

    
    // METODOS DE INSTANCIA

    public void sumar(Racional r) {
        this.numerador = this.numerador * r.denominador + r.numerador * this.denominador;
        this.denominador = this.denominador * r.denominador;
        simplificar();
    }

    public void restar(Racional r) {
        this.numerador = this.numerador * r.denominador - r.numerador * this.denominador;
        this.denominador = this.denominador * r.denominador;
        simplificar();
    }

    public void multiplicar(Racional r) {
        this.numerador *= r.numerador;
        this.denominador *= r.denominador;
        simplificar();
    }

    public void dividir(Racional r) {
        if (r.numerador == 0) {
            System.out.println("División por 0");
        }
        this.numerador *= r.denominador;
        this.denominador *= r.numerador;
        simplificar();
    }

    // OTROS METODOS 

    public Racional simplificar() {
        int mcd = mcd(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;

        // Mantener signo en el numerador
        if (denominador < 0) {
            numerador *= -1;
            denominador *= -1;
        }

        return this;
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Racional other = (Racional) obj;
        if (this.numerador != other.numerador) {
            return false;
        }
        return this.denominador == other.denominador;
    }

    public int compareTo(Racional r) {
        double diff = this.aDecimal() - r.aDecimal();

        if (Math.abs(diff) < 1e-9) return 0;
        return (diff > 0) ? 1 : -1;
    }

    // MÉTODOS ESTÁTICOS

    public static Racional sumar(Racional r1, Racional r2) {
        return new Racional(
            r1.numerador * r2.denominador + r2.numerador * r1.denominador,
            r1.denominador * r2.denominador
        );
    }

    public static Racional restar(Racional r1, Racional r2) {
        return new Racional(
            r1.numerador * r2.denominador - r2.numerador * r1.denominador,
            r1.denominador * r2.denominador
        );
    }

    public static Racional multiplicar(Racional r1, Racional r2) {
        return new Racional(
            r1.numerador * r2.numerador,
            r1.denominador * r2.denominador
        );
    }

    public static Racional dividir(Racional r1, Racional r2) {
        if (r2.numerador == 0) {
            System.out.println("División por 0");
        }
        return new Racional(
            r1.numerador * r2.denominador,
            r1.denominador * r2.numerador
        );
    }

    // MCD 
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
