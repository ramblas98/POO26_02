package Finca;

public class LoteSiembra {
    private int idLote;
    private String especie;
    private Clima climaRequerido;
    public Invernadero invernaderoAsignado;

    public LoteSiembra(){
        this.idLote = 1;
        this.especie = "no asignado";
        this.climaRequerido = Clima.TROPICAL;
        this.invernaderoAsignado = null;
    }

    public LoteSiembra(int idLote, String especie, Clima climaR){
        this.idLote = idLote;
        this.especie = especie;
        this.climaRequerido = climaR;
        this.invernaderoAsignado = null;
    }

    public int getIdLote() {
        return idLote;
    }

    public String getEspecie() {
        return especie;
    }

    public Clima getClimaRequerido() {
        return climaRequerido;
    }

    public Invernadero getInvernadero() {
        return invernaderoAsignado;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public void setClimaRequerido(Clima climaRequerido) {
        this.climaRequerido = climaRequerido;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

}
