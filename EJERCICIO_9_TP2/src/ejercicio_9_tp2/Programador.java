/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_9_tp2;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Programador {
    private String nombre;
    private int legajo;
    private Rol rol;
    private int horasMaximas;
    private ArrayList<Tarea> listaTareas = new ArrayList<>();
    
    //Constructor sin parametro
    public Programador(int horasMaximas) {
        this.horasMaximas = 40;
    }
    
    //Constructor con parametro

    public Programador(String nombre, int legajo, Rol rol) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.rol = rol;
    }
    
}
