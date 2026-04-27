/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_1_tp2;
import java.util.Calendar;

/**
 *
 * @author Administrador
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    // Constructor por defecto
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 2000;
    }

    // Constructor con parámetros
    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anio = a;
    }
    
    // Getters devuelve la copia del atributo 
    public int getDia() { 
        return dia; 
    }
    public int getMes() { 
        return mes; 
    }
    public int getAnio() { 
        return anio; 
    }

    // Setters modifica el valor del atributo
    public void setDia(int d) { 
        this.dia = d; normalizar(); 
    }
    public void setMes(int m) { 
        this.mes = m; normalizar(); 
    }
    public void setAnio(int a) { 
        this.anio = a; normalizar(); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        //
        final Fecha other = (Fecha) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        return this.anio == other.anio;
    }
    
    // Reiniciar
    public void reiniciar(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anio = a;
        normalizar();
    }

    // Adelantar dias (manual)
    public void adelantar(int d) {
        this.dia += d;
        normalizar();
    }

    // Imprimir
    public void imprimir() {
        System.out.println(this.toString());
    }

    // Validar
    private boolean valida() {
        if (mes < 1 || mes > 12) return false;
        if (dia < 1 || dia > diasDelMes(mes)) return false;
        return true;
    }

    // Normalizar (clave del ejercicio)
    public void normalizar() { // por si se pasa del numero de dias del mes
        while (dia > diasDelMes(mes)) {
            dia -= diasDelMes(mes);
            mes++;
            if (mes > 12) {
                mes = 1;
                anio++;
            }
        }
    }

    // Días por mes
    private int diasDelMes(int mes) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(anio) ? 29 : 28;
            default:
                return 0;
        }
    }

    // Bisiesto
    public static boolean esBisiesto(int a) {
        return (a % 400 == 0) || (a % 4 == 0 && a % 100 != 0);
    }

    // toString
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }

    // Clonar
    public Fecha clonar() {
        return new Fecha(dia, mes, anio);
    }

    // Comparar
    public int comparar(Fecha f) {
        if (this.anio != f.anio) return this.anio - f.anio;
        if (this.mes != f.mes) return this.mes - f.mes;
        return this.dia - f.dia;
    }

    // Diferencia en días
    public int diferenciaEnDias(Fecha otra) {
       int total1 = anio * 360 + mes * 30 + dia;
       int total2 = otra.anio * 360 + otra.mes * 30 + otra.dia;
       return Math.abs(total1 - total2);
    }

    // Formatear
    /*public String formatear(String fmt) {
        return fmt
                .replace("DD", String.format("%02d", dia))
                .replace("MM", String.format("%02d", mes))
                .replace("AAAA", String.valueOf(anio));
    }*/
    
    public String formatear(String formato) {

    String d = (dia < 10 ? "0" : "") + dia;
    String m = (mes < 10 ? "0" : "") + mes;
    String a = "" + anio;

    String resultado = "";

    for (int i = 0; i < formato.length(); i++) {

        // Detectar "DD"
        if (i + 1 < formato.length() && formato.substring(i, i + 2).equals("DD")) {
            resultado += d;
            i++; // saltar la segunda D
        }
        // Detectar "MM"
        else if (i + 1 < formato.length() && formato.substring(i, i + 2).equals("MM")) {
            resultado += m;
            i++;
        }
        // Detectar "AAAA"
        else if (i + 3 < formato.length() && formato.substring(i, i + 4).equals("AAAA")) {
            resultado += a;
            i += 3;
        }
        // Copiar cualquier otro carácter
        else {
            resultado += formato.charAt(i);
        }
    }
    return resultado;
}

    // Hoy 
    public static Fecha hoy() {
      Calendar cal = Calendar.getInstance();
      int d = cal.get(Calendar.DAY_OF_MONTH);
      int m = cal.get(Calendar.MONTH) + 1;
      int a = cal.get(Calendar.YEAR);
       return new Fecha(d, m, a);
    }
}
