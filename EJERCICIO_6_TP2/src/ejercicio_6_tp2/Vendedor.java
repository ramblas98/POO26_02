/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_6_tp2;

/**
 *
 * @author Administrador
 */
public class Vendedor {
    private Persona persona;
    private int legajo;
    private String zonaDeVenta;
    private double ventasMensuales[];
    private double totalAnual;
    private double comision;

    public Vendedor() {
        this.ventasMensuales = new double[12]; //java ya llena todo con 0.0
        this.comision = 0;
        this.totalAnual = 0;
        
    }

    public Vendedor(Persona persona, int legajo, String zonaDeVenta) {
        this.persona = persona;
        this.legajo = legajo;
        this.zonaDeVenta = zonaDeVenta;
        this.ventasMensuales = new double[12];
        this.comision = 0;
        this.totalAnual = 0;
        
    }

    public Persona getPersona() {
        return persona;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getZonaDeVenta() {
        return zonaDeVenta;
    }
    
    public double getTotalAnual(){
        this.totalAnual = 0; //Se resetea para que no duplique ni acumule de mas
        for(double e: ventasMensuales){
            this.totalAnual += e;
        }
        return this.totalAnual;
    }
    
    public double getComision(){
        this.getTotalAnual(); // asegura que totalAnual esté actualizado
        if(this.totalAnual>50000){
            if(this.totalAnual<75000){
                this.comision = (this.totalAnual*15)/100;
            } else if(this.totalAnual <100000){
                this.comision = (this.totalAnual*20)/100;
            } else { //Mayor que $100000
                this.comision = (this.totalAnual*30)/100;
            }
        }
        return this.comision;
    }
    
    public double[] getVentasMensuales() {
        return ventasMensuales;
    }
    
    public void setVentasMensuales(int mes, double monto){
        this.ventasMensuales[mes - 1] = monto;
        System.out.println("Se agrego el monto del mes: " + mes + " correctamente");
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setZonaDeVenta(String zonaDeVenta) {
        this.zonaDeVenta = zonaDeVenta;
    }

}
