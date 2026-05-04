public class Historia {
    private static int contador = 1;
    private int indicador;
    private String codigoPaciente;
    private Especialidad especialidad;
    private EstadoPaciente estadoInicial;
    private Medico medicoAsignado;
    private boolean alta;

    public Historia(){
        this.indicador = 1;
        this.codigoPaciente = "h3yr";
        this.estadoInicial = EstadoPaciente.LEVE;
        this.especialidad = Especialidad.FAMILIA;
    }

    public Historia(String cod, EstadoPaciente estado, Especialidad esp){
        this.indicador = 1;
        this.codigoPaciente = cod;
        this.estadoInicial = estado;
        this.especialidad = esp;
    }

    public int getIndicador() {
        return indicador;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public EstadoPaciente getEstadoInicial() {
        return estadoInicial;
    }

    public Especialidad getEspacialidad(){
        return especialidad;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }


}
