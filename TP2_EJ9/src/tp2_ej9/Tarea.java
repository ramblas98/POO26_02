/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_ej9;

/**
 *
 * @author alumno
 */
public class Tarea {
    private static int contador = 100;
    
    private int idTarea;
    private String descripcion;
    private int HorasEstimadas;
    private Rol rolRequerido;
    private Programador programadorAsignado;

    public Tarea(String descripcion, int horasEstimadas, Rol rolRequerido) {
        this.idTarea = contador++;
        this.descripcion = descripcion;
        this.HorasEstimadas = horasEstimadas;
        this.rolRequerido = rolRequerido;
    }

    public int getHorasEstimadas() {
        return HorasEstimadas;
    }

    public Rol getRolRequerido() {
        return rolRequerido;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setProgramadorAsignado(Programador p) {
        this.programadorAsignado = p;
    }
}
