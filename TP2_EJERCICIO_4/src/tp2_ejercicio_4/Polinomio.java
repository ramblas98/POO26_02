/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_ejercicio_4;

/**
 *
 * @author Rita y Jazmin
 */
import java.util.Arrays;
import java.util.Scanner;

public class Polinomio {
    private int grado;
    private double[] coeficientes;
    

    public Polinomio(){
        System.out.println("Obj. Polinomio creado.");
    }

    //Constructor que recibe un arreglo de coeficientes
    public Polinomio(double[] coeficientesRecibidos){ 
        coeficientes = coeficientesRecibidos;
    }
    
    //Constructor que recibe un grado y crea un polinomio con todos los coeficientes
    public Polinomio(int gradoRecibido){
        coeficientes = new double[gradoRecibido +1];   
    }
    
    //Métodos de instancia para operaciones básicas que modifican los atributos del Polinomio:
    //sumar(Polinomio p): Suma dos polinomios
    public void sumar(Polinomio p){ //Metodo de instancia
        int gradoS,i;
        double coef1, coef2;
        
        if(this.grado > p.grado){
            gradoS = this.grado;
        } else gradoS = p.grado;
        
        Polinomio suma = new Polinomio();
        suma.grado= gradoS;
        suma.coeficientes= new double[gradoS +1];
        
          for(i=0; i<= gradoS; i++){
              coef1=0;
              coef2=0;
          
          if( i<= this.grado){
              coef1 = this.coeficientes[i];
          }
          if(i <= p.grado){
              coef2= p.coeficientes[i];
          }
          
            suma.coeficientes[i] = coef1 + coef2;
          }  
          this.grado= suma.grado;
          this.coeficientes = suma.coeficientes; 
    }
    
    //restar(Polinomio p): Resta un polinomio del actual
    public void restar(Polinomio q){
        int gradoR,i;
        double coef1, coef2;
        
        if(this.grado > q.grado){
            gradoR = this.grado;
        } else gradoR = q.grado;
        
        Polinomio resta = new Polinomio();
        resta.grado= gradoR;
        resta.coeficientes= new double[gradoR +1];
        
          for(i=0; i<= gradoR; i++){
              coef1=0;
              coef2=0;
          
          if( i<= this.grado){
              coef1 = this.coeficientes[i];
          }
          if(i <= q.grado){
              coef2= q.coeficientes[i];
          }
          
            resta.coeficientes[i] = coef1 - coef2;
          }  
          this.grado= resta.grado;
          this.coeficientes = resta.coeficientes; 
    }
       

    
    // multiplicar(Polinomio p): Multiplica dos polinomios
    public void multiplicar(Polinomio m){
        int gradoM = this.grado + m.getGrado();
        double[] nuevoArreglo = new double[gradoM +1];
        
       for(int i=0; i<= this.grado; i++){
           for(int j=0; j<= m.grado ;j++){
               nuevoArreglo[i+j] += m.coeficientes[j] * this.coeficientes[i];  
           }
       }
      
       this.coeficientes = nuevoArreglo;
    }
    
    
    public int getGrado(){
    return grado;
}

public double[] getCoeficientes(){
    return coeficientes.clone();
}

public double getCoeficiente(int indice){
    if(indice >= 0 && indice < coeficientes.length){
        return coeficientes[indice];
    } else{
    System.out.println("Indice fuera de rango");
    }
    return 0;
}

public void setCoeficiente(int indice, double nuevoCoef){
    if(indice >this.grado || indice < 0){
        System.out.println("Indice no valido.Ingresar un valor entre 0 y " + this.grado);
    } else {
        this.coeficientes[indice] = nuevoCoef;
    }
}

public void setGrado(int nuevoGrado){
    if (nuevoGrado >= coeficientes.length) {
        System.out.println("Error: El grado excede la capacidad del arreglo.");
        return;
    }
    // 2. Limpiar (poner en 0) todos los términos que quedan "fuera" del nuevo grado
    for (int i = nuevoGrado + 1; i <= this.grado; i++) {
        this.coeficientes[i] = 0;
    }
    this.grado = nuevoGrado;
}

public void ingresarPolinomio(){
    Scanner teclado = new Scanner(System.in);
    
    System.out.println("ingresar grado: ");
    this.grado = teclado.nextInt();
    teclado.nextLine();
    this.coeficientes = new double[this.grado +1];

    for(int i=grado ; i >= 0 ; i--){
        double valor;
        System.out.println("Ingrese coeficiente para X^" + i + ": ");
        valor = teclado.nextDouble();
        
        while(i== this.grado && valor == 0){
            System.out.println("Ingrese coeficiente para X^" + i + ": ");
            System.out.println("no puede valer 0");
            valor = teclado.nextDouble();
        }
    this.coeficientes[i] = valor;
    }
}

public void agregarCoeficiente(double coef, int exp){
    
    if(exp > this.grado){
        double[] nuevoArreglo= new double[exp +1];
        
        
        nuevoArreglo[exp]= coef;
        for(int i= 0; i<=this.grado; i++){
            nuevoArreglo[i] = coeficientes[i];
        }
        
        this.grado = exp;
        this.coeficientes = nuevoArreglo;
    }
    
    if(this.coeficientes[exp] != 0){
       this.coeficientes[exp] = coef;
    }
    
    
}
    
    
    public Polinomio[] dividir(Polinomio p){
        Polinomio[] resultados = new Polinomio[2];
        boolean continuar= false;
        
        for(int i= p.grado; i>=0;i--){
            if(p.coeficientes[i] != 0 ){
                continuar = true;
            }
        }
        
        if(continuar == true){
        resultados[0]= new Polinomio();
        resultados[1]= new Polinomio();
        
        //resultados[0] = Cociente de la division
        resultados[0].coeficientes = new double[this.grado - p.grado +1];
         //resultados[1] = Resto de la division
        resultados[1].coeficientes = this.coeficientes.clone();
        resultados[1].grado = this.grado;
        
        //Si el grado del Dividendo es menor que el grado del divisor -> C(x)= 0 y R(x)= D(x).
        if(this.grado < p.grado){ 
            return resultados;
        }
         
        int gradoCociente = this.grado - p.grado; 
        
        resultados[0].grado = gradoCociente;
          
        for(int i= gradoCociente; i >= 0 ; i--){
            resultados[0].coeficientes[i] = resultados[1].coeficientes[i + p.grado]/p.coeficientes[p.grado];
            
            for(int j=0; j<= p.grado; j++){
                resultados[1].coeficientes[i + j] -= resultados[0].coeficientes[i] * p.coeficientes[j];
            }
        }
      }
        System.out.println("Indefinido");
        return resultados;
    }
    
  
    
   
    public double evaluar(double x){
        double[] aux;//= new double[this.grado +1];
        double res;
        
        aux = this.coeficientes;
        for(int i= this.grado-1; i>=0;i--){
            aux[i] += x* aux[i + 1]; 
        }
        res = aux[0];
        
        return res;
    }
    
     
    public Polinomio derivar(){
        Polinomio resultado= new Polinomio();
        
        resultado.grado = this.grado-1;
        resultado.coeficientes = new double[resultado.grado +1];
        
        for(int i= this.grado; i>0 ;i--){
            resultado.coeficientes[i-1] = this.coeficientes[i];
        }
        
        for(int i= resultado.grado; i>=0 ;i--){
            resultado.coeficientes[i] *= (i + 1); 
        }
        return resultado;
    }
    
    
    //+ integrar(): Polinomio
    public Polinomio integrar(){
        Polinomio resultado = new Polinomio();
        
        resultado.grado = this.grado +1;
        resultado.coeficientes = new double [resultado.grado +1];
        
        resultado.coeficientes[0]= 0;
        //resultado.coeficientes= this.coeficientes;
   
        for(int i=this.grado; i>=0; i-- ){
            resultado.coeficientes[i+1] = this.coeficientes[i] / (i+1);
        }
         
        return resultado;
    }
    
    
    //+ calcularRaices(): double[]
    public double[] calcularRaices(){
        double[] raices = new double[2];
        
        if(this.grado == 1 ){
            raices[0] = (-1) *this.coeficientes[0] / this.coeficientes[1];
            return raices;
        }
        
        if(this.grado == 2){
            double a= this.coeficientes[2];
            double b= this.coeficientes[1];
            double c= this.coeficientes[0];
            
            //System.out.println( "A= " + a);
            //System.out.println( "B= " + b);
            //System.out.println( "C= " + c);
            
            double discriminante= b*b - 4*a*c;
            //System.out.println( "Discriminante= " + discriminante);
            
            if(discriminante >0){
                raices[0] = (-1*b + Math.sqrt(discriminante))/(2*a); 
                raices[1] = (-1*b - Math.sqrt(discriminante))/(2*a);
            } else {
                if(discriminante == 0){
                    raices[0] = -1*b /2*a;
                    raices[1] = -1*b /2*a;
                }else {
                    System.out.println("Raices imaginarias: ");
                  //  raices[0] = (((-1)*b)/2*a) + (((-1)*Math.sqrt(discriminante)) /2*a);
                  //  raices[1] = (((-1)*b)/2*a) - (((-1)*Math.sqrt(discriminante)) /2*a);
                  
                }
            }         
        }
        
       if(raices != null){
           return raices;
       } 
        return null;
    }
    
    
    
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        
        final Polinomio other = (Polinomio) obj;
        if(this.grado != other.grado){
            return false;
        }
        if(this.coeficientes != other.coeficientes){
            return false;
        }
        
        return Arrays.equals (this.coeficientes, other.coeficientes);
        
    }
    
    

    public String toString() {
     // 1. Preparamos la "caja" vacía
    StringBuilder caja = new StringBuilder();

    for (int i = coeficientes.length - 1; i >= 0; i--) {
        double coef = coeficientes[i];

        if (coef != 0) {
            
            if (coef > 0 && caja.length() > 0) {
                caja.append(" + "); 
            } else if (coef < 0) {
                caja.append(" - ");
            }

             double valorAbs = Math.abs(coef);
            
            if (valorAbs == (long) valorAbs) {
                
                caja.append((long) valorAbs);
            } else {
                
                caja.append(valorAbs);
            }
            
            
            if (i > 1) {
                caja.append("x^");
                caja.append(i);
                caja.append(" ");
            }
            if(i == 1 ) caja.append("x");
        }
    }
   
    return caja.toString();
    }
    
    
    //+ static sumar(p1: Polinomio, p2: Polinomio): Polinomio
    public static Polinomio sumar(Polinomio p1, Polinomio p2){
        Polinomio suma = new Polinomio();
        
        suma.grado= p1.grado;
        suma.coeficientes = p1.coeficientes;
         suma.sumar(p2);
       
        
        return suma;
    }
    
    
    
    //+ static restar(p1: Polinomio, p2: Polinomio): Polinomio
    public static Polinomio restar(Polinomio p1, Polinomio p2){
         Polinomio resta = new Polinomio();
        
        resta.grado = p1.grado;
        resta.coeficientes = p1.coeficientes;
        for(int i=p2.grado; i >=0; i--){
           p2.coeficientes[i] *= -1; 
        }
        
        resta.sumar(p2);
 
        return resta;
    }
    
    
    
    //+ static multiplicar(p1: Polinomio, p2: Polinomio): Polinomio
    public static Polinomio multiplicar(Polinomio p1, Polinomio p2){
        Polinomio producto = new Polinomio();
        
        producto.grado = p1.grado + p2.grado;
        producto.coeficientes = new double[producto.grado +1];
        
        for(int i =0; i<= p1.grado; i++){
            for(int j=0; j<= p2.grado; j++){
                producto.coeficientes[i + j] += p1.coeficientes[i] * p2.coeficientes[j]; 
            }
        }
        
        return producto;
    }
    
}
