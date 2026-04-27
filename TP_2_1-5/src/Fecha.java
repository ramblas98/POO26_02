import java.util.Calendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(){
        this.dia = 31;
        this.mes = 12;
        this.anio = 1999;
    }

    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    private static int meses30(int dia){
        if(dia <= 30 && dia > 0){
            return dia;
        }else{
            return dia - (dia % 30);
        }
    }

    private static int meses31(int dia){
        if(dia <= 31 && dia > 0){
            return dia;
        }else{
            return dia - (dia % 31);
        }
    }

    private static int meses(int dia, int mes, int anio){

    }
    private void normaliza(){
        switch (mes){
            case 1:
                this.dia = meses31(dia);
            case 2:
                //this.dia = dia - meses31(dia);
            case 3:
                this.dia = meses31(dia);
            case 4:
                this.dia = meses30(dia);
        }
    }

    public static boolean esBisiesto(int anio){

        return false;
    }
}
