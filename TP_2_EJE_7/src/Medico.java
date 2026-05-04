import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nombre;
    private int matriculaProfesional;
    private Especialidad especialidad;
    private int cupo;
    private List<Historia> listaDeHistorias;

    public Medico(){
        this.cupo = 10;
        this.especialidad = Especialidad.FAMILIA;
    }

    public Medico(String n ,int m,Especialidad esp,int cupo){
        this.nombre = n;
        this.matriculaProfesional = m;
        if(esp == null){
            this.especialidad = Especialidad.FAMILIA;
        }else{
            this.especialidad = esp;
        }
        this.cupo = cupo;
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public int getMatriculaProfesional() {
        return matriculaProfesional;
    }

    public int getCupo() {
        return cupo;
    }

    public List<Historia> getListaDeHistorias(){
        return listaDeHistorias;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public boolean tieneDisponibilidad(){

    }
}
