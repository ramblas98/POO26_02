/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */package ejercicio_7;
/**
 *
 * @author Hp
 */
import java.util.ArrayList;
import java.util.List;

public class EJERCICIO_7 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // ── 1. Crear los médicos ───────────────────────────────────────────
        Medico nortes    = new Medico("Nortes",    5677, Especialidad.PEDIATRIA);
        Medico gutierrez = new Medico("Gutierrez", 4568, Especialidad.FAMILIA);
        Medico mayor     = new Medico("Mayor",     7890, Especialidad.FAMILIA);
        Medico guillen   = new Medico("Guillen",   4567, Especialidad.TRAUMATOLOGIA);
        Medico mateo     = new Medico("Mateo",     8976, Especialidad.TRAUMATOLOGIA);

        // ── 2. Crear el cuadro médico e insertar todos los médicos ─────────
        CuadroMedico cuadro = new CuadroMedico();
        cuadro.insertarMedico(nortes);
        cuadro.insertarMedico(gutierrez);
        cuadro.insertarMedico(mayor);
        cuadro.insertarMedico(guillen);
        cuadro.insertarMedico(mateo);

        // ── 3. Crear la lista de historias ────────────────────────────────
        List<Historia> historias = new ArrayList<>();
        historias.add(new Historia("Rocio",   EstadoPaciente.LEVE,  Especialidad.PEDIATRIA));
        historias.add(new Historia("Andres",  EstadoPaciente.GRAVE, Especialidad.TRAUMATOLOGIA));
        historias.add(new Historia("Juan",    EstadoPaciente.MEDIO, Especialidad.TRAUMATOLOGIA));
        historias.add(new Historia("Marieta", EstadoPaciente.LEVE,  Especialidad.FAMILIA));
        historias.add(new Historia("Alfonso", EstadoPaciente.MEDIO, Especialidad.FAMILIA));

        // ── 4. Asignar cada historia al médico más disponible ─────────────
        System.out.println("=== ASIGNACIONES ===");

        for (Historia h : historias) {

            // Pregunta al cuadro quién tiene más disponibilidad para esa especialidad
            Medico medicoAsignado = cuadro.getMedicoMayorDisponibilidad(
                                        h.getEspecialidadRequerida());

            if (medicoAsignado != null) {

                // El médico verifica internamente especialidad + disponibilidad
                boolean exito = medicoAsignado.asignarHistoria(h);

                if (exito) {
                    // Reinserta para que el cuadro reordene según la nueva disponibilidad
                    cuadro.insertarMedico(medicoAsignado);

                    System.out.println("Historia #" + h.getId()
                        + " (" + h.getCodigoPaciente() + ")"
                        + " Dr. " + medicoAsignado.getNombre());
                } else {
                    System.out.println("Historia #" + h.getId()
                        + " (" + h.getCodigoPaciente() + ")"
                        + " No se pudo asignar.");
                }

            } else {
                System.out.println("Historia #" + h.getId()
                    + " (" + h.getCodigoPaciente() + ")"
                    + " No hay médico disponible para " + h.getEspecialidadRequerida());
            }
        }
        
        // ── Mostrar estado final del cuadro ───────────────────────────────
        System.out.println();
        cuadro.mostrarCuadro();

        // ── Mostrar estado de cada historia ───────────────────────────────
        System.out.println();
        System.out.println("=== HISTORIAS ===");
        for (Historia h : historias) {
            System.out.println(h);
        }
    }
}