/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_2;

/**
 *
 * @author Hp
 */
public class Complejo {
    private double real;
    private double imaginaria;
    public static final double EPSILON = 1e-9;

    // Constructores
    public Complejo() {
        this.real = 0;
        this.imaginaria = 0;
    }

    public Complejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    // Getters
    public double getReal() {
        return real;
    }

    public double getImaginaria() {
        return imaginaria;
    }
    
    // Setters
    public void setReal(double real) {
        this.real = real;
    }
    
    public void setImaginaria(double imaginaria) {
        this.imaginaria = imaginaria;
    }

    // MÉTODOS DE INSTANCIA
    public void sumar(Complejo otro) {
        this.real += otro.real;
        this.imaginaria += otro.imaginaria;
    }

    public void restar(Complejo otro) {
        this.real -= otro.real;
        this.imaginaria -= otro.imaginaria;
    }

    public void multiplicar(Complejo otro) {
        double nuevoReal = this.real * otro.real - this.imaginaria * otro.imaginaria;
        double nuevaImag = this.real * otro.imaginaria + this.imaginaria * otro.real;
        this.real = nuevoReal;
        this.imaginaria = nuevaImag;
    }

    public void dividir(Complejo otro) {
        double denominador = otro.real * otro.real + otro.imaginaria * otro.imaginaria;

        if (Math.abs(denominador) < EPSILON) {
            System.out.println("No se puede división por cero");
        }

        double nuevoReal = (this.real * otro.real + this.imaginaria * otro.imaginaria) / denominador;
        double nuevaImag = (this.imaginaria * otro.real - this.real * otro.imaginaria) / denominador;

        this.real = nuevoReal;
        this.imaginaria = nuevaImag;
    }

    // OTROS MÉTODOS
 
    public double modulo() {
        return Math.sqrt(real * real + imaginaria * imaginaria);
    }

    public double argumento() {
        return Math.atan2(imaginaria, real); // mejor que atan(b/a)
    }

    public Complejo conjugado() {
        return new Complejo(real, -imaginaria);
    }

    public Complejo opuesto() {
        return new Complejo(-real, -imaginaria);
    }

    public Complejo potencia(int n) {
        Complejo resultado = new Complejo(1, 0);
        Complejo base = new Complejo(this.real, this.imaginaria);

        for (int i = 0; i < n; i++) {
            resultado.multiplicar(base);
        }
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        //pregunta si el objeto esta vacio
        if (obj == null) {
            return false;
        }
        // si la clase del complejo es distinta a la clase del objeto ingresado
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complejo other = (Complejo) obj;
        
        if (this.real != other.real) {
            return false;
        }
        return (this.imaginaria) == (other.imaginaria);
    }

    @Override
    public String toString() {
        if (imaginaria >= 0) {
            return real + " + " + imaginaria + "i";
        } else {
            return real + " - " + (-imaginaria) + "i";
        }
    }

    // MÉTODOS ESTÁTICOS
    
    public static Complejo sumar(Complejo c1, Complejo c2) {
        return new Complejo(c1.real + c2.real, c1.imaginaria + c2.imaginaria);
    }

    public static Complejo restar(Complejo c1, Complejo c2) {
        return new Complejo(c1.real - c2.real, c1.imaginaria - c2.imaginaria);
    }

    public static Complejo multiplicar(Complejo c1, Complejo c2) {
        double real = c1.real * c2.real - c1.imaginaria * c2.imaginaria;
        double imag = c1.real * c2.imaginaria + c1.imaginaria * c2.real;
        return new Complejo(real, imag);
    }

    public static Complejo dividir(Complejo c1, Complejo c2) {
        double denominador = c2.real * c2.real + c2.imaginaria * c2.imaginaria;

        if (Math.abs(denominador) < EPSILON) {
            System.out.println("No se puede división por cero");
        }

        double real = (c1.real * c2.real + c1.imaginaria * c2.imaginaria) / denominador;
        double imag = (c1.imaginaria * c2.real - c1.real * c2.imaginaria) / denominador;

        return new Complejo(real, imag);
    }
}
