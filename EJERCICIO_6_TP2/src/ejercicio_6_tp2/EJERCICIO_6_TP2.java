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
        boolean b=false; //booleano necesario para marcar las opciones
        
        do {
            System.out.println("\n===== SISTEMA DE VENDEDORES =====");
            System.out.println("1. Registrar vendedores");
            System.out.println("2. Cargar venta de un mes");
            System.out.println("3. Ver total anual de un vendedor");
            System.out.println("4. Ver comision de un vendedor");
            System.out.println("5. Mostrar comisiones de todos");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            int opcionVendedor;
            switch(opcion){
                case 1: sc.nextLine(); // limpia el Enter del menú ANTES del loop
                        for(int i = 0; i < vendedores.length; i++){
                          System.out.println("REGISTRO DE VENDEDOR "+(i+1));
                          System.out.println("Ingrese nombre del vendedor: ");
                          String nombre = sc.nextLine();
                          System.out.println("Ingrese apellido del vendedor: ");
                          String apellido = sc.nextLine();
                          System.out.println("Ingrese DNI del vendedor: ");
                          int dni = sc.nextInt();
                          sc.nextLine(); // limpia el buffer
                          System.out.println("Ingrese legajo del vendedor: ");
                          int legajo = sc.nextInt();
                          sc.nextLine(); // limpia el buffer
                          System.out.println("Ingrese zona de venta del vendedor: ");
                          String zona = sc.nextLine();
                          Persona persona = new Persona(apellido,nombre,dni);
                          vendedores[i] = new Vendedor(persona, legajo, zona);
                            System.out.println("=================================");
                        }
                        b=true; //PONEMOS EL BOOLEANO EN TRUE CUANDO TERMINEMOS DE CARGAR A LOS VENDEDORES
                    /* crear Persona, crear Vendedor, guardarlo en el array */ break;
                case 2: 
                        if(b){
                            opcionVendedor = seleccionarVendedor(vendedores);
                            ingresoMontoMes(vendedores, opcionVendedor - 1);
                        } else {
                            System.out.println("PRIMERO DEBE INGRESAR LOS VENDEDORES");
                        }
                        break;
                        /* elegir vendedor por índice, pedir mes y monto, llamar setVentasMensuales */ 
                case 3: 
                        if(b){
                            opcionVendedor = seleccionarVendedor(vendedores);
                            muestraVentaAnual(vendedores,opcionVendedor-1); //opcionVendedor-1 para que mande la posicion del vendedor en el array
                        } else {
                            System.out.println("PRIMERO DEBE INGRESAR LOS VENDEDORES");
                        }
                        /* elegir vendedor, llamar getTotalAnual, mostrar resultado */ 
                        break;
                case 4: if(b){
                           opcionVendedor = seleccionarVendedor(vendedores);
                           comisionVendedor(vendedores,opcionVendedor-1);
                        } else {
                            System.out.println("PRIMERO DEBE INGRESAR LOS VENDEDORES");
                        }
                        /* elegir vendedor, llamar getComision, mostrar resultado */ break;
                case 5:
                        if(b){
                          System.out.println("======================== COMISIONES DE LOS VENDEDORES ========================");
                          for(Vendedor e: vendedores){
                          System.out.println("Comision de "+e.getPersona().getNombres()+' '+e.getPersona().getApellidos());
                          System.out.println("$"+e.getComision());
                          System.out.println("==============================================================================");
                          }  
                        } else {
                            System.out.println("PRIMERO DEBE INGRESAR LOS VENDEDORES");
                        }
                        
                        /* recorrer el array y mostrar la comision de cada uno */
                        break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion invalida");
            }
            
        } while(opcion != 0);
        
    }
    public static int seleccionarVendedor(Vendedor[] v){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione vendedor: ");
        System.out.println("1: VENDEDOR: "+v[0].getPersona().getNombres()+' '+v[0].getPersona().getApellidos());
        System.out.println("2: VENDEDOR: "+v[1].getPersona().getNombres()+' '+v[1].getPersona().getApellidos());
        System.out.println("3: VENDEDOR: "+v[2].getPersona().getNombres()+' '+v[2].getPersona().getApellidos());
        int opVendedor;
        do {
            opVendedor = sc.nextInt();
            if(opVendedor < 1 || opVendedor > v.length){
            System.out.println("Opción inválida, ingrese 1, 2 o 3");
            }
        } while(opVendedor < 1 || opVendedor > v.length);
        return opVendedor;
    }
    public static void ingresoMontoMes(Vendedor[] v,int indice){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el mes: ");
        System.out.println("1:ENERO 2:FEBRERO 3:MARZO 4:ABRIL 5:MAYO 6:JUNIO"
        +" 7:JULIO 8:AGOSTO 9:SEPTIEMBRE 10:OCTUBRE 11NOVIEMBRE 12:DICIEMBRE");
        int opcionMes =sc.nextInt();
        System.out.print("Ingrese monto:");
        double monto = sc.nextDouble();
        v[indice].setVentasMensuales(opcionMes, monto);
    }
    public static void muestraVentaAnual(Vendedor[] v, int indice){
        System.out.println("Venta anual de "+v[indice].getPersona().getNombres()+' '+v[indice].getPersona().getApellidos());
        System.out.println(v[indice].getTotalAnual());
    }
    public static void comisionVendedor(Vendedor[] v, int indice){
        double comision = v[indice].getComision();
        if(v[indice].getTotalAnual() > 50000){
          System.out.println("Comision de "+v[indice].getPersona().getNombres()+' '+v[indice].getPersona().getApellidos());
          System.out.println("$"+comision);
          System.out.println("====================================");  
        } else {
            System.out.println("El monto minimo anual debe ser mayor a $50,000");
        }
    }
    
}
