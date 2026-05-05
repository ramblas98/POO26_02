/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_7;

/**
 *
 * @author Hp
 */

public class Historia {

    // Variable estática: pertenece a la CLASE, no a cada objeto.
    // Se comparte entre todas las instancias para generar ids únicos y consecutivos.
    private static int contadorId = 0;
    // final = solo se asigna una vez, en el constructor. No puede cambiar después.
    private final int id;
    private final String codigoPaciente;
    private final EstadoPaciente estado;
    private final Especialidad especialidadRequerida;
    // Estos dos sí cambian después de construirse
    private Medico medico;
    private boolean altaPaciente;

    // CONTRUCTOR
    public Historia(String codigoPaciente, EstadoPaciente estado, Especialidad especialidadRequerida) {
        contadorId++;                            // incrementa el contador global -- Como primera ves 1
        this.id = contadorId;                    // id único para esta historia
        this.codigoPaciente = codigoPaciente;
        this.estado = estado;
        this.especialidadRequerida = especialidadRequerida;
        this.medico = null;                      // sin médico hasta que se asigne
        this.altaPaciente = false;               // empieza sin alta
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public EstadoPaciente getEstado() {
        return estado;
    }

    public Especialidad getEspecialidadRequerida() {
        return especialidadRequerida;
    }

    public Medico getMedico() {
        return medico;
    }
    // Devuelve si el paciente tiene el alta o no. Por convención los getters de boolean usan "is" en lugar de get.
    // No hay setter público porque el alta no se puede revertir.
    public boolean isAltaPaciente() {
        return altaPaciente;
    }

    // Solo se puede asignar médico UNA VEZ.
    // La guarda "if medico == null" protege contra reasignaciones.
    public void setMedico(Medico medico) {
        if (this.medico == null) {
            this.medico = medico;
        }
    }

    // Alta: solo si tiene médico asignado, y solo puede pasar de false a true.
    // No existe ningún setter que lo vuelva a false, así que es irreversible.
    public void darAlta() {
        if (this.medico != null) {
            this.altaPaciente = true;
        }
    }

    @Override
    public String toString() {
        String nombreMedico = (medico != null) ? medico.getNombre() : "sin asignar";
        return "Historia #" + id
            + " | Paciente: "    + codigoPaciente
            + " | Estado: "      + estado
            + " | Especialidad: "+ especialidadRequerida
            + " | Medico: "      + nombreMedico
            + " | Alta: "        + altaPaciente;
    }
}