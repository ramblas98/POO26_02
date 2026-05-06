package Finca;

import java.util.List;

public class AdministradorFinca {
    private List<Invernadero> listaDeInvernaderos;

    public AdministradorFinca(){
        this.listaDeInvernaderos = null;
    }

    public AdministradorFinca(List<Invernadero> invernaderos){
        this.listaDeInvernaderos = invernaderos;
    }

    public List<Invernadero> getListaDeInvernaderos() {
        return listaDeInvernaderos;
    }

    public Invernadero obtenerMejorInvernadero(Clima c){
        Invernadero mejorInvernadero = null;
        int disponibilad = 0;
        for(Invernadero i : listaDeInvernaderos){
            if(i.getClima() == c){
                if(i.getDisponibilidad() > disponibilad){
                    disponibilad = i.getDisponibilidad();
                    mejorInvernadero = i;
                }
            }
        }
        return mejorInvernadero;
    }
}
