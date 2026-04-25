/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio_5_tp2;

/**
 *
 * @author USUARIO
 */
public class Estudiante {
    //Atributos
    private String apellidos;
    private String nombres;
    private int lu;
    public boolean regular;
    private int notaP1;
    private int notaP2;
    private int notaR;
    private int asistencia;
    
    //constructor sin parametro
    
    public Estudiante() {
    }
    //costructor con parametro

    public Estudiante(String apellidos, String nombres, int lu) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.lu = lu;
    }
    
    //getter
    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public int getLu() {
        return lu;
    }

    public boolean isRegular() {
        return regular;
    }

    public int getNotaP1() {
        return notaP1;
    }

    public int getNotaP2() {
        return notaP2;
    }

    public int getNotaR() {
        return notaR;
    }

    public int getAsistencia() {
        return asistencia;
    }
    
    //setter
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setLu(int lu) {
        this.lu = lu;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    public void setNotaP1(int notaP1) {
        this.notaP1 = notaP1;
    }

    public void setNotaP2(int notaP2) {
        this.notaP2 = notaP2;
    }

    public void setNotaR(int notaR) {
        this.notaR = notaR;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }
    
    public void incAsistencia(){
        this.asistencia++;
    }
    
    public void incAsistencia(int c){
        this.asistencia += c;
    }
    
    //toString
    @Override
    public String toString() {
        return "Estudiante{" + "apellidos: " + apellidos + ", nombres: " + nombres + ", lu: " + lu + '}';
    }
    //asd
}
