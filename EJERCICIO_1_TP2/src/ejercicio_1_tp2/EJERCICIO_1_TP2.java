/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_1_tp2;

/**
 *
 * @author Administrador
 */
public class EJERCICIO_1_TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Crear fechas
        Fecha f1 = new Fecha(10, 5, 2026);
        Fecha f2 = new Fecha(11, 03, 2026);

        System.out.println("Fecha 1: " + f1);
        System.out.println("Fecha 2: " + f2);

        // 2. Calcular edad (en días)
        int edadDias = f1.diferenciaEnDias(f2);
        System.out.println("Edad en dias: " + edadDias);

        // 3. Comparar fechas
        int comp = f1.comparar(f2);
        if (comp < 0) {
            System.out.println("f1 es anterior a f2");
        } else if (comp > 0) {
            System.out.println("f1 es posterior a f2");
        } else {
            System.out.println("Son iguales");
        }

        // 4. Adelantar días
        f1.adelantar(40);
        System.out.println("f1 adelantada 40 dias: " + f1);

        // 5. Reiniciar fecha
        f1.reiniciar(12,03,2026); // fecha inválida -> normaliza
        System.out.println("f1 reiniciada: " + f1);

        // 6. Clonar
        Fecha copia = f1.clonar();
        System.out.println("Copia de f1: " + copia);

        // 7. Formatear
        System.out.println("Formato personalizado: " + f1.formatear("DD/MM/AAAA"));

        // 8. Fecha actual (manual)
        Fecha hoy = Fecha.hoy();
        System.out.println("Hoy: " + hoy);

        // 9. Días hasta un evento
        Fecha evento = new Fecha(1, 1, 2027);
        int diasRestantes = hoy.diferenciaEnDias(evento);
        System.out.println("Dias hasta el evento: " + diasRestantes);
    }
    
}
