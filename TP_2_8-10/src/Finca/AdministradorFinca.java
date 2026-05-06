package Finca;

import java.util.ArrayList;
import java.util.List;

public class AdministradorFinca {
    private List<Invernadero> listaDeInvernaderos;

    public AdministradorFinca(){
        this.listaDeInvernaderos = new ArrayList<>();
    }

    public AdministradorFinca(List<Invernadero> invernaderos){
        this.listaDeInvernaderos = invernaderos;
    }

    public List<Invernadero> getListaDeInvernaderos() {
        return listaDeInvernaderos;
    }

    public Invernadero obtenerMejorInvernadero(Clima c){
        Invernadero mejorInvernadero = null;
        //int disponibilad = 0;
        for(Invernadero i : this.listaDeInvernaderos){
            if(i.getClima() == c){
                if(mejorInvernadero == null){
                    mejorInvernadero = i;
                }else{
                    if(i.getDisponibilidad() > mejorInvernadero.getDisponibilidad()){
                        mejorInvernadero = i;
                    }
                }
            }
        }
        return mejorInvernadero;
    }
}
