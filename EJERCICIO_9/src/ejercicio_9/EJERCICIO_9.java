/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_9;
/**
 *
 * @author Hp
 */
import java.util.ArrayList;

public class EJERCICIO_9 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crea gestor para la lista
        GestorProyectos gestor = new GestorProyectos();

        // Programadores
        Programador p1 = new Programador("Ana", 1, Rol.FRONTEND);
        Programador p2 = new Programador("Luis", 2, Rol.BACKEND);
        Programador p3 = new Programador("Sofia", 3, Rol.FULLSTACK);
        Programador p4 = new Programador("Pedro", 4, Rol.BACKEND);

        gestor.agregarProgramador(p1);
        gestor.agregarProgramador(p2);
        gestor.agregarProgramador(p3);
        gestor.agregarProgramador(p4);

        // Simular carga previa
        p1.tomarTarea(new Tarea("Filtros de Búsqueda", 40, Rol.FRONTEND));
        p2.tomarTarea(new Tarea("Servicio de Notificaciones", 10, Rol.BACKEND));
        p3.tomarTarea(new Tarea("Formulario de Registro", 20, Rol.FRONTEND));
        
        // Tareas críticas
        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("Pagos", 10, Rol.BACKEND));
        tareas.add(new Tarea("Interfaz Reportes", 8, Rol.FRONTEND));
        tareas.add(new Tarea("Seguridad", 12, Rol.BACKEND));
        tareas.add(new Tarea("Integracion", 15, Rol.FULLSTACK));

        // Reasignación
        for (Tarea t : tareas) {
            Programador p = gestor.buscarProgramadorDisponible(t.getRolRequerido(), t.getHorasEstimadas());
            if (p != null) {
                p.tomarTarea(t);
                System.out.println("Tarea " + t.getIdTarea() + " - " + t.getDescripcion() + 
                " reasignada a " + p.getNombre() + 
                " (Horas restantes: " + p.getHorasLibres() + ")");
            } else {
                System.out.println("Tarea " + t.getIdTarea() + " - " + t.getDescripcion() +
                        " NO pudo asignarse");
            }
        }
        // Mostrar horas libres de los progrmadores
        System.out.println("====HORAS LIBRES====");
        System.out.println("ANA -> horas libres: " + p1.getHorasLibres());
                
        for (Programador p : gestor.getProgramadores()){
            System.out.println(p.getNombre() + " -> horas libres: " + p.getHorasLibres());
        }
    }
}