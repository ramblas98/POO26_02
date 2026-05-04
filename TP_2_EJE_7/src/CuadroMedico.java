import java.util.List;

public class CuadroMedico {
    private List<Medico> listaMedicos;

    public Medico obtenerMedicoDisponible(Especialidad esp){
        Medico masDisponible = null;
        for(Medico m : this.listaMedicos){
            if(masDisponible == null && m.getEspecialidad() == e){
                masDisponible = m;
            }else{
                if(m.getEspecialidad() == e && m.libre() > masDisponible.libre()){
                    masDisponible = m;
                }
            }
        }
        return masDisponible;
    }
}
