/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_ej9;

/**
 *
 * @author alumno
 */
public class Programador {
    private String nombre;
    private int legajo;
    private Rol rol;
    private int HorasMaximas;
    private ArrayList<tarea> tareas;
    
    public Programador(String nombre, int legajo, Rol rol){
    this.nombre = nombre;
    this.legajo = legajo;
    this.rol = rol;
    this.HorasMaximas = 40;
    this.tareas = new ArrayList<>();
    }
    
    public int  getHorasLibres(){
        int usadas = 0;
        for(Tarea t : tareas){
            usadas+= t.getHorasEstimadas();
        }
        return HorasMaximas - usadas;
    }
    
    public void TomarTarea(Tarea t){
        tareas.add(t);
        t.setProgramadorAsignado(this);
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }
    
}
