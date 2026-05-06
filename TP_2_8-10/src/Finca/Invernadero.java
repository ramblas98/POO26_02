package Finca;

import java.util.ArrayList;
import java.util.List;

public class Invernadero {
    private String nombre;
    private int codigo;
    private Clima clima;
    private int capacidadMaxima;
    private List<LoteSiembra> listaDeLotes;

    public Invernadero(){
        this.capacidadMaxima = 5;
        this.clima = Clima.TROPICAL;
        this.codigo = 1;
        this.nombre = "anonimo";
        this.listaDeLotes = new ArrayList<>();
    }

    public Invernadero(String nombre, int cod, Clima clima, int capMax){
        this.capacidadMaxima = capMax;
        this.codigo = cod;
        this.nombre = nombre;
        this.clima = clima;
        this.listaDeLotes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public Clima getClima() {
        return clima;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setClima(Clima clima) {
        this.clima = clima;
    }

    public int getDisponibilidad(){
        return capacidadMaxima - listaDeLotes.size();
    }

    public void asignarLoteSiembra(LoteSiembra lote){
        if(listaDeLotes.size() < capacidadMaxima){
            listaDeLotes.add(lote);
            lote.setInvernaderoAsignado(this);
        }
    }
}
