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
        normalizar();
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
        normalizar();
    }

    public void setMes(int mes) {
        this.mes = mes;
        normalizar();
    }

    public void setAnio(int anio) {
        this.anio = anio;
        normalizar();
    }

    public void imprimir(){
        System.out.println(this.dia + " / " + this.mes + " / " + this.anio);
    }

    public static boolean esBisiesto(int anio){
        if((anio % 400 == 0) || (anio % 4 == 0)){
            return true;
        }
        if(anio % 100 == 0){
            return false;
        }
        return  false;
    }

    private int diasMes(int mes){
        switch (mes){
            case 1: return 31;
            case 2:
                if(esBisiesto(this.anio)){
                    return 29;
                }else{
                    return 28;
                }
            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6:return 30;
            case 7:return 31;
            case 8:return 31;
            case 9:return 30;
            case 10:return 31;
            case 11:return 30;
            case 12: return 31;
            default:return 0;
        }
    }

    private boolean valida(){
        if(mes < 1 || mes > 12){
            return false;
        }
        if(dia < 1){
            return false;
        }
        int maximoDias = diasMes(mes);
        if(dia <= maximoDias){
            return true;
        }
        if (dia > maximoDias) {
            return false;
        }else{
            return false;
        }
    }

    private void normalizar(){
        while(mes < 1){
            mes += 12;
            anio--;
        }
        while(mes > 12){
            mes -= 12;
            anio++;
        }

        while(dia < 1){
            mes = mes - 1;
            if(mes == 0){
                mes = 12;
                anio--;
            }
            dia = dia + diasMes(mes);
        }

        while(dia > diasMes(mes)){
            dia = dia - diasMes(mes);
            mes++;
            if(mes == 13){
                mes = 1;
                anio++;
            }
        }
    }

    public void adelantar(int d){
        dia = dia + d;
        normalizar();
    }

    public void reiniciar(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.anio = a;
        normalizar();
    }

    public int comparar(Fecha otra){
        if(this.anio == otra.anio){
            if(this.mes == otra.mes){
                if(this.dia == otra.dia){
                    return 0;
                }
                if(this.dia > otra.dia){
                    return 1;
                }else{
                    return -1;
                }
            }
            if(this.mes > otra.mes){
                return 1;
            }else{
                return -1;
            }
        }
        if(this.anio > otra.anio){
            return 1;
        }else{
            return -1;
        }
    }

    public Fecha clonar(){
        Fecha nuevo = new Fecha(this.dia,this.mes,this.anio);
        return nuevo;
    }

    public int diferenciaEnDias(Fecha otra){

    }
}
