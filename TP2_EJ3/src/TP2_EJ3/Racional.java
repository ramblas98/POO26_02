/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2_EJ3;

/**
 *
 * @author alumno
 */
public class Racional {
    private int numerador;
    private int denominador;

    public Racional() {
        this.numerador=0;
        this.denominador=1;
    }
     public Racional(int numerador, int denominador) {
         if(denominador==0){
             throw new IllegalArgumentException("El denominador no puede ser cero");
         }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
        simplificar();
    }

    public void setDenominador(int denominador) {
        if(denominador!=0){
            this.denominador = denominador;
        }
        else{
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }
        simplificar();
    }
    
    public void sumar(Racional r){
        this.numerador=this.numerador*r.denominador+r.numerador*this.denominador;
        this.denominador=r.denominador*this.denominador;
        simplificar();
    }
    
    public void restar(Racional r){
        this.numerador=this.numerador*r.denominador-r.numerador*this.denominador;
        this.denominador=this.denominador*r.denominador;
        simplificar();
    }
    
    public void multiplicar(Racional r){
        this.numerador=this.numerador*r.numerador;
        this.denominador=this.denominador*r.denominador;
        simplificar();
    }
        
    public void dividir(Racional r){
        if(r.numerador==0){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        this.numerador=this.numerador*r.denominador;
        this.denominador=this.denominador*r.numerador;
        simplificar();
    }
    
    public Racional simplificar(){
        int mcd=mcd(Math.abs(numerador),Math.abs(denominador));
        numerador/=mcd;
        denominador/=mcd;
        
        if(denominador<0){
            numerador*=-1;
            denominador*=-1;
        }
        return this;
    }
    
    public double aDecimal(){
        return (double) numerador/denominador;
    }
    
    @Override
    public String toString(){
        return numerador+"/"+denominador;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Racional){
            Racional otro = (Racional) obj;

            return this.numerador * otro.denominador == otro.numerador * this.denominador;
        }

        return false;
    }
    
    public int compareTo(Racional r) {
        int valor1 = this.numerador * r.denominador;
        int valor2 = r.numerador * this.denominador;

        return Integer.compare(valor1,valor2);
    }
    
    public static Racional sumar(Racional r1,Racional r2){
        int nume = r1.numerador * r2.denominador + r2.numerador * r1.denominador;
        int demo = r1.denominador * r2.denominador;

        return new Racional(nume,demo);
    }

    public static Racional restar(Racional r1,Racional r2){
        int nume = r1.numerador * r2.denominador - r2.numerador * r1.denominador;
        int demo = r1.denominador * r2.denominador;

        return new Racional(nume,demo);
    }

    public static Racional multiplicar(Racional r1,Racional r2){
        int nume = r1.numerador * r2.numerador;
        int demo = r1.denominador * r2.denominador;

        return new Racional(nume,demo);
    }

    public static Racional dividir(Racional r1,Racional r2){
        int nume = r1.numerador * r2.denominador;
        int demo = r1.denominador * r2.numerador;

        return new Racional(nume,demo);
    }
    
    private static int mcd(int a,int b){
        if(b==0){
            return a;
        }
        return mcd(b,a%b);
    }
}