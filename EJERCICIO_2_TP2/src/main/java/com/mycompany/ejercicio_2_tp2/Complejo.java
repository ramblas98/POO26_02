/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio_2_tp2;

/**
 *
 * @author USUARIO
 */
public class Complejo {
    private double real;
    private double imaginaria;
    private static final double EPSILON = 1e-9;
    
    //constructor sin parametro
    public Complejo() {
    }
    
    //constructor
    public Complejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }
    
    //getter
    public double getReal() {
        return real;
    }

    public double getImaginaria() {
        return imaginaria;
    }

    public static double getEPSILON() {
        return EPSILON;
    }
    
    //setter
    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginaria(double imaginaria) {
        this.imaginaria = imaginaria;
    }
    
    //suma
    public void sumar(Complejo otro){
        this.real += otro.real;
        this.imaginaria += otro.imaginaria;
    }
    
    //resta
    public void restar(Complejo otro){
        this.real = this.real - otro.real;
        this.imaginaria = this.imaginaria - otro.imaginaria;
    }
    
    //multiplicacion
    public void multiplicar(Complejo otro){
        //Calculamos los nuevos valores usando variables temporales
        double nuevoReal = (this.real * otro.real) - (this.imaginaria * otro.imaginaria); // anteponemos el - para que haga el producto (-1)
        double nuevoImaginario = (this.real * otro.imaginaria) + (this.imaginaria*otro.real);

        // Asignamos los valores finales después de calcular todo
        this.real = nuevoReal;
        this.imaginaria = nuevoImaginario;
        
        /* ESTO NO SE HACE
        this.real = (this.real*otro.real) + ((this.imaginaria*otro.imaginaria)*(-1));
        this.imaginaria = (this.real*otro.imaginaria) + (this.imaginaria*otro.real) ; */
    }
    
    //Conjugado
    public Complejo conjugado(){
        return new Complejo(this.real, -this.imaginaria);
    }
    
    //Dividir
    public void dividir(Complejo otro){
        double a = this.real;
        double b = this.imaginaria;
        double c = otro.real;
        double d = otro.imaginaria;

        double denominador = c*c + d*d;
        
        if(denominador==0){
            System.out.println("No se puede dividir por cero"); //TAMBIEN SE PUEDE LANZAR UNA EXCEPCION
        }
        
        double nuevoReal = (a*c + b*d) / denominador;
        double nuevaImaginaria = (b*c - a*d) / denominador;

        this.real = nuevoReal;
        this.imaginaria = nuevaImaginaria;
    }
    
    @Override
    public boolean equals(Object obj){
        // pregunto si es el Mismo objeto (referencia)
        //this es una referencia al objeto actual, es decir, el objeto sobre el que se llamó el método
        if (this == obj) return true; 
        
        // pregunto si es Null
        if (obj == null) return false;

        // Despues se verifica el tipo
        if (!(obj instanceof Complejo)) return false;

        // Castear
        Complejo otro = (Complejo) obj; //El objeto generico pasa a ser del tipo Complejo

        // Se aplica la Lógica de tolerancia
        return Math.abs(this.real - otro.real) < EPSILON && //aqui directamente devuelve el valor booleano
        Math.abs(this.imaginaria - otro.imaginaria) < EPSILON;
    }
    
    //Calcula el modulo
    public double modulo() {
        return Math.sqrt(real * real + imaginaria * imaginaria);
    }
    
    //Argumento
    public double argumento() {
        return Math.atan2(imaginaria, real);
    }
    
    
    /*Lo de acceder a c1.real directamente en vez de c1.getReal()
    funciona porque se está dentro de la misma clase, por eso se tiene
    acceso a los atributos privados sin problema. Desde otra clase ya no se podría. */
    public static Complejo sumar(Complejo c1, Complejo c2){
        c1.sumar(c2);
        Complejo resultado = new Complejo(c1.getReal(),c1.getImaginaria());
        return resultado;
        /*double resultadoReal = c1.real+c2.real;
        double resultadoImaginario = c1.imaginaria+c2.imaginaria;
        return new Complejo(resultadoReal,resultadoImaginario); */
    }
    
    public static Complejo restar(Complejo c1, Complejo c2){
        double resultadoReal = c1.real - c2.real;
        double resultadoImaginario = c1.imaginaria - c2.imaginaria;
        return new Complejo(resultadoReal,resultadoImaginario);
    }
    
    public static Complejo multiplicar(Complejo c1, Complejo c2){
        double nuevoReal = (c1.real * c2.real) - (c1.imaginaria * c2.imaginaria); // anteponemos el - para que haga el producto (-1)
        double nuevoImaginario = (c1.real * c2.imaginaria) + (c1.imaginaria*c2.real);

        return new Complejo(nuevoReal,nuevoImaginario);
    }
    
    
    public static Complejo dividir(Complejo c1, Complejo c2){
        double a = c1.real;
        double b = c1.imaginaria;
        double c = c2.real;
        double d = c2.imaginaria;

        double denominador = c*c + d*d;
        
        if(denominador==0){
            System.out.println("No se puede dividir por cero"); //TAMBIEN SE PUEDE LANZAR UNA EXCEPCION
            return null;
        }
        
        double nuevoReal = (a*c + b*d) / denominador;
        double nuevaImaginaria = (b*c - a*d) / denominador;

        return new Complejo(nuevoReal,nuevaImaginaria);
    }
    
    //toString
    @Override
    public String toString() {
        return "Complejo: (" + "real: " + String.format("%.2f", real) + ", imaginaria:" + String.format("%.2f", imaginaria) + 'i' + ')';
    }
}
