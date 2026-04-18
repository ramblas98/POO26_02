// Clase Complejo

public class Complejo {

    // Atributos
    private double real;
    private double imaginaria;
    private static final double EPSILON = 1e-9;

    // -------------------------
    // Constructores
    // -------------------------

    public Complejo() {
        this.real = 0;
        this.imaginaria = 0;
    }

    public Complejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    // -------------------------
    // Getters y Setters
    // -------------------------

    public double getReal() {

        return real;

    }

    public double getImaginaria() {

        return imaginaria;

    }

    public void setReal(double real) {

        this.real = real;

    }

    public void setImaginaria(double imaginaria) {

        this.imaginaria = imaginaria;

    }

    // -------------------------
    // Métodos de instancia (modifican el objeto actual)
    // -------------------------

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
        double nuevoImag = this.real * otro.imaginaria + this.imaginaria * otro.real;
        this.real = nuevoReal;
        this.imaginaria = nuevoImag;
    }

    public void dividir(Complejo otro) {
        double denominador = otro.real * otro.real + otro.imaginaria * otro.imaginaria;
        if (Math.abs(denominador) < EPSILON) {
            throw new ArithmeticException("División por cero complejo.");
        }
        double nuevoReal = (this.real * otro.real + this.imaginaria * otro.imaginaria) / denominador;
        double nuevoImag = (this.imaginaria * otro.real - this.real * otro.imaginaria) / denominador;
        this.real = nuevoReal;
        this.imaginaria = nuevoImag;
    }

    // -------------------------
    // Métodos útiles de instancia
    // -------------------------

    /**
     * Calcula el módulo: |z| = sqrt(a² + b²)
     */
    public double modulo() {
        return Math.sqrt(real * real + imaginaria * imaginaria);
    }

    /**
     * Calcula el argumento: θ = atan(b/a) en radianes
     */
    public double argumento() {
        return Math.atan2(imaginaria, real);
    }

    /**
     * Retorna el conjugado: a - bi
     */
    public Complejo conjugado() {
        return new Complejo(real, -imaginaria);
    }

}