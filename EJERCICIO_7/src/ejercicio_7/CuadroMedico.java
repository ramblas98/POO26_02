/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_7;

/**
 *
 * @author Hp
 */
import java.util.ArrayList;
import java.util.List;

public class CuadroMedico {

    // Lista plana con TODOS los médicos sin importar la especialidad.
    // El orden se mantiene de menor a mayor disponibilidad (espacio libre).
    private List<Medico> medicos;

    public CuadroMedico() {
        this.medicos = new ArrayList<>();
    }

    // Inserta un médico en la lista (si no estaba ya).
    // Después reordena para mantener el invariante de orden.
    public void insertarMedico(Medico m) {
        // contains() -> Recorre la lista buscando si ese objeto exacto está dentro. usar denuevo
        if (!medicos.contains(m)) {
            medicos.add(m);
        }
        ordenarPorDisponibilidad();
    }

    // Elimina un médico de la lista.
    public void eliminarMedico(Medico m) {
        medicos.remove(m);
    }

    // Devuelve el médico con MAYOR disponibilidad para la especialidad dada.
    // Como la lista está ordenada de menor a mayor disponibilidad,
    // recorre de atrás hacia adelante y devuelve el primero que cumpla.
    // Devuelve null si no hay ninguno disponible o la especialidad no existe.
    public Medico getMedicoMayorDisponibilidad(Especialidad especialidad) {
        Medico candidato = null;
        for (Medico m : medicos) {
            if (m.getEspecialidad() == especialidad && m.tieneDisponibilidad()) {
                candidato = m; // actualiza siempre: el último encontrado tiene más disponibilidad
            }
        }
        return candidato;
    }

    // Ordenamiento burbuja de menor a mayor disponibilidad.
    // Disponibilidad = cupo - cantidad de historias activas.
    // Un valor más alto significa más espacio libre (más disponible).
    private void ordenarPorDisponibilidad() {
        int n = medicos.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                int dispJ  = medicos.get(j).getCupo()   - medicos.get(j).getHistorias().size();
                int dispJ1 = medicos.get(j + 1).getCupo() - medicos.get(j + 1).getHistorias().size();

                // Si el de la izquierda tiene MÁS disponibilidad → intercambiar
                // (queremos los de menor disponibilidad primero)
                if (dispJ > dispJ1) {
                    Medico temp = medicos.get(j);
                    medicos.set(j,     medicos.get(j + 1));
                    medicos.set(j + 1, temp);
                }
            }
        }
    }

    // Muestra todos los médicos agrupados por especialidad.
    // Sin Map, usamos Especialidad.values() para recorrer cada grupo.
    public void mostrarCuadro() {
        System.out.println("=== CUADRO MEDICO ===");

        for (Especialidad esp : Especialidad.values()) {
            boolean hayAlguno = false;

            for (Medico m : medicos) {
                if (m.getEspecialidad() == esp) {
                    if (!hayAlguno) {
                        System.out.println("  Especialidad: " + esp);
                        hayAlguno = true;
                    }
                    System.out.println("    " + m);
                }
            }
        }
    }
}
