/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_0;

import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class EJERCICIO_0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //ArrayList<Character> letra = new ArrayList<>(); DESPUES INTENTAR CON ArrayList
        //ArrayList<Integer> frecuencia = new ArrayList<>();
        int n,i;
        char letra[];
        int frecuencia[];
        
        //teclado.next(); //limpiar buffer
        String palabra = teclado.next(); //ingreso de la palabra por teclado
        
        n = palabra.length();
        //La idea es que los vectores tengan el tamaño justo...
        letra = new char[n]; //por eso se pone del tamaño de la
        frecuencia = new int[n];//palabra que ingresa el usuario
        
        int usados=0; //variable 'usados' que indicará el tamaño justo del vector de letras
        for(i=0;i<palabra.length(); i++){//ciclo for que recorre la palabra
            if(i==0){
            letra[usados]=palabra.charAt(i);
            frecuencia[usados]=1;
            usados++;
            } else {
             boolean encontrado = false;
             int k=0; //variable k que se debe inciar en cero cuando cae por else
             while(k < usados && encontrado==false){
               if(palabra.charAt(i) == letra[k]){
                  encontrado = true;
                }else{
                  k++;
                }
              }
            if(encontrado){
              frecuencia[k]++; //aumenta la frecuencia
            } else { //si no lo encuentra lo agrega al vector de letras
              letra[usados] = palabra.charAt(i);//aqui uso 'usados' que quedo con el siguiente espacio
              frecuencia[usados] = 1;
              usados++;
            }
          } 
        }
        
        boolean primero = true;
        for(i = 0; i < usados; i++){
          if(frecuencia[i] >= 2){
            if(!primero) System.out.print(", ");
            System.out.print(letra[i] + ":" + frecuencia[i]);
            primero = false;
          }
        } 
    }
    
}
