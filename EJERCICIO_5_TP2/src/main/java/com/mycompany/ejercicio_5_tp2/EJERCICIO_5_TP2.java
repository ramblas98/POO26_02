/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio_5_tp2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class EJERCICIO_5_TP2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Estudiante> lista = new ArrayList<>();
        
        System.out.print("Ingrese la cantidad de alumnos: ");
        int n = teclado.nextInt();
        teclado.nextLine();
        
        for(int i=0; i<n; i++){
            System.out.print("Ingrese apellido/s del alumno: ");
            String apellidos = teclado.nextLine();
            System.out.print("Ingrese nombre/s del alumno: ");
            String nombres = teclado.nextLine();
            System.out.print("Ingrese libreta universiaria del alumno: ");
            int lu = teclado.nextInt();
            System.out.print("Ingrese nota de primer parcial: ");
            int nota1 = teclado.nextInt();
            System.out.print("Ingrese nota de segundo parcial: ");
            int nota2 = teclado.nextInt();
            int notaR=0;
            if(nota1<60 || nota2<60){
               System.out.print("Ingrese nota del Recuperatorio: ");
               notaR = teclado.nextInt();
            }
            System.out.print("Ingrese asistencia: ");
            int asistencia = teclado.nextInt();
            teclado.nextLine();
            
            Estudiante e = new Estudiante(apellidos,nombres,lu);
            
            e.setNotaP1(nota1);
            e.setNotaP2(nota2);
            e.setNotaR(notaR);
            e.setAsistencia(asistencia);
            
            //CRITERIOS DE REGULARIDAD
            
            /* SIN ASISTENCIA OBLIGATORIA
            // Aprobó ambos parciales, O recuperó el que le faltaba
            if((nota1>=60 && nota2>=60) || (notaR>=60 && (nota1<60 || nota2<60))){
                e.setRegular(true);
            } else {
                e.setRegular(false); 
            } */
            
            //CON ASISTENCIA OBLIGATORIA
            //   Aprobó ambos parciales, O recuperó el que le faltaba
            if(((nota1>=60 && nota2>=60) || (notaR>=60 && (nota1<60 || nota2<60))) && asistencia>=20){
                e.setRegular(true);
            } else {
                e.setRegular(false); 
            }
            
            lista.add(e);
        }
        
        System.out.println("=== ALUMNOS REGULARES ===");
        for(Estudiante e: lista){
            if(e.isRegular()){
                System.out.println(e);
            }
        }
        System.out.println("=== ALUMNOS NO REGULARES ===");
        for (Estudiante e: lista){
            if(!e.isRegular()){
                System.out.println(e);
            }
        }
    }
}
