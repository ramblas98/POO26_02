/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_6_tp2;

import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class EJERCICIO_6_TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vendedor[] vendedores = new Vendedor[3];
        int opcion;
        
        do {
            System.out.println("\n===== SISTEMA DE VENDEDORES =====");
            System.out.println("1. Registrar vendedor");
            System.out.println("2. Cargar venta de un mes");
            System.out.println("3. Ver total anual de un vendedor");
            System.out.println("4. Ver comision de un vendedor");
            System.out.println("5. Mostrar comisiones de todos");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1: for(Vendedor v: vendedores){
                          System.out.println("Ingrese nombre del vendedor: ");
                          String nombre = sc.nextLine();
                          System.out.println("Ingrese apellido del vendedor: ");
                          String apellido = sc.nextLine();
                          System.out.println("Ingrese DNI del vendedor: ");
                          int dni = sc.nextInt();
                          Persona persona = new Persona(apellido,nombre,dni);
                          v.setPersona(persona);
                          
                          System.out.println("Ingrese legajo del vendedor: ");
                          int legajo = sc.nextInt();
                          System.out.println("Ingrese zona de venta del vendedor: ");
                          String zona = sc.nextLine();
                          v.setLegajo(legajo);
                          v.setZonaDeVenta(zona);
                        }
                    /* crear Persona, crear Vendedor, guardarlo en el array */ break;
                case 2: 
                        
                        
                        System.out.println("Ingresar vendedor: ");
                        System.out.println("1: VENDEDOR: "+vendedores[0].getPersona().getNombres());
                        System.out.println("2: VENDEDOR: "+vendedores[1].getPersona().getNombres());
                        System.out.println("3: VENDEDOR: "+vendedores[2].getPersona().getNombres());
                        int op = sc.nextInt();
                        switch(op){
                            case 1: break;
                            case 2: break;
                            case 3: break;
                        }
                        
                    /* elegir vendedor por índice, pedir mes y monto, llamar setVentasMensuales */ break;
                case 3: /* elegir vendedor, llamar getTotalAnual, mostrar resultado */ break;
                case 4: /* elegir vendedor, llamar getComision, mostrar resultado */ break;
                case 5: /* recorrer el array y mostrar la comision de cada uno */ break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion invalida");
            }
            
        } while(opcion != 0);
    }
    
}
