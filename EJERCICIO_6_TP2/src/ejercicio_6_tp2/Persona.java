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
public class Persona {
    private String apellidos;
    private String nombres;
    private int dni;

    public Persona() {
    }

    public Persona(String apellidos, String nombres, int dni) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public int getDni() {
        return dni;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    
}
