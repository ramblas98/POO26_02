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

public class Medico {
    // IMPORTANTE -> RECORDAR -> AGREGAR EN APUNTES
    // Inmutables -> private final: se asignan en el constructor y no cambian nunca
    //En atributos, crea constantes de instancia que no pueden modificarse después 
    //de su inicialización, reforzando el principio del menor privilegio.
    private final String nombre;
    private final int matricula;
    private final Especialidad especialidad;
    // El cupo SÍ puede cambiar (necesidades del servicio)
    private int cupo;
    // Lista de historias activas que está atendiendo en este momento
    private List<Historia> historias;

    // Constructor completo
    public Medico(String nombre, int matricula, Especialidad especialidad, int cupo) {
        this.nombre       = nombre;
        this.matricula    = matricula;
        this.especialidad = especialidad;
        this.cupo         = cupo;
        // lista VACÍA, lista para recibir historias
        this.historias    = new ArrayList<>();
    }

    // Constructor sin cupo: por defecto 10
    public Medico(String nombre, int matricula, Especialidad especialidad) {
        this(nombre, matricula, especialidad, 10);
    }

    // Constructor sin especialidad ni cupo: especialidad FAMILIA, cupo 10
    public Medico(String nombre, int matricula) {
        this(nombre, matricula, Especialidad.FAMILIA, 10);
    }

    // --- Getters ---
    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public int getCupo() {
        return cupo;
    }

    public List<Historia> getHistorias() {
        return historias;
    }
    // Para los atributos final como nombre o matricula no existe setter, porque no pueden cambiar.
    // El cupo SÍ tiene setter porque puede cambiar por necesidades del servicio
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
    // Cuántos pacientes está atendiendo ahora. cupo es el máximo permitido.
    // Disponible si la cantidad de historias activas es menor al cupo
    public boolean tieneDisponibilidad() {
        return historias.size() < cupo;
    }

    // Asigna una historia a este médico.
    // Condiciones: misma especialidad Y tiene disponibilidad.
    // Devuelve true si la asignación tuvo éxito.
    public boolean asignarHistoria(Historia h) {
        if (h.getEspecialidadRequerida() == this.especialidad && tieneDisponibilidad()) {
            historias.add(h);   // .add agrega la historia al final de su lista activa
            //this es el médico actual. Le dice a la historia que este médico es el que la está atendiendo. estaplese una relacion 
            //Histroia <-> medico 
            h.setMedico(this);  // registro: el médico tiene la historia en su lista y la historia tiene al médico registrado.
            return true;
        }
        return false;
    }

    // Da el alta al paciente de una historia.
    // Quita la historia de la lista activa, pero la historia conserva la referencia al médico.
    public void darAlta(Historia h) {
        // contains() -> Recorre la lista buscando si ese objeto exacto está dentro. 
        if (historias.contains(h)) {
            h.darAlta();          // marca el alta dentro de la historia
            historias.remove(h);  // la quita de la lista activa del médico
        }
    }

    @Override
    public String toString() {
        return "Dr. " + nombre
            + " | Matricula: "  + matricula
            + " | Especialidad: " + especialidad
            + " | Pacientes: "  + historias.size() + "/" + cupo;
    }
}