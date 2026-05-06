/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_9;

/**
 *
 * @author Hp
 */
import java.util.ArrayList;

public class Programador {

    private String nombre;
    private final int legajo;
    private Rol rol;
    private int horasMaximas = 40;
    private ArrayList<Tarea> tareas;

    public Programador(String nombre, int legajo, Rol rol) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.rol = rol;
        this.tareas = new ArrayList<>();
    }

    public int getHorasLibres() {
        int horasOcupadas = 0;
        for (Tarea t : tareas) {
            horasOcupadas += t.getHorasEstimadas();
        }
        return horasMaximas - horasOcupadas;
    }
    
    public Rol getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }
    public void tomarTarea(Tarea t) {
        tareas.add(t);
        t.setProgramadorAsignado(this); // vínculo bidireccional
    }
    
}