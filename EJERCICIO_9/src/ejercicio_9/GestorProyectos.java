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

public class GestorProyectos {

    private ArrayList<Programador> plantilla;

    public GestorProyectos() {
        plantilla = new ArrayList<>();
    }

    public ArrayList<Programador> getProgramadores() {
        return plantilla;
    }
    

    public void agregarProgramador(Programador p) {
        plantilla.add(p);
    }

    public Programador buscarProgramadorDisponible(Rol r, int horasNecesarias) {

        Programador mejor = null;

        for (Programador p : plantilla) {

            boolean cumpleRol = (p.getRol() == r || p.getRol() == Rol.FULLSTACK);
            boolean tieneHoras = p.getHorasLibres() >= horasNecesarias;

            if (cumpleRol && tieneHoras) {
                if (mejor == null || p.getHorasLibres() > mejor.getHorasLibres()) {
                    mejor = p;
                }
            }
        }

        return mejor;
    }
}