package Finca;

public class LoteSiembra {
    private static int contador = 0;
    private int idLote;
    private String especie;
    private Clima climaRequerido;
    public Invernadero invernaderoAsignado;

    public LoteSiembra(){
        this.idLote = ++contador;
        this.especie = "no asignado";
        this.climaRequerido = Clima.TROPICAL;
        this.invernaderoAsignado = null;
    }

    public LoteSiembra(String especie, Clima climaR){
        this.idLote = ++contador;
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

    public void setInvernaderoAsignado(Invernadero inv) {
        this.invernaderoAsignado = inv;
    }
}
