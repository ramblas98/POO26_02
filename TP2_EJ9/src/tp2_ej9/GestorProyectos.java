/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_ej9;

/**
 *
 * @author alumno
 */
public class GestorProyectos {
    private List<Programador> programadores;
    
    public GestorProyectos(){
        programadores = new ArrayList<>(); 
    }
    
    
    public void agregarProgramador(Programador p) {
        programadores.add(p);
    }

    public Programador buscarProgramadorDisponible(Rol r, int horasNecesarias) {
        Programador mejor = null;

        for (Programador p : programadores) {
            boolean cumpleRol = p.getRol() == r || p.getRol() == Rol.FULLSTACK;
            boolean tieneTiempo = p.getHorasLibres() >= horasNecesarias;

            if (cumpleRol && tieneTiempo) {
                if (mejor == null || p.getHorasLibres() > mejor.getHorasLibres()) {
                    mejor = p;
                }
            }
        }

        return mejor;
    }
}
