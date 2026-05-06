package Finca;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Invernadero inv1 , inv2, inv3;
        inv1 = new Invernadero("Pepe_Fundation",234,Clima.TEMPLADO,10);
        inv2 = new Invernadero("Umbrella_corporation",198,Clima.TROPICAL,7);
        inv3 = new Invernadero("Cocos_Fincas",309,Clima.TEMPLADO,9);

        List<Invernadero> invernaderos = new ArrayList<>();
        invernaderos.add(inv1);
        invernaderos.add(inv2);
        invernaderos.add(inv3);
        AdministradorFinca fincas = new AdministradorFinca(invernaderos);
        List<LoteSiembra> siembras = new ArrayList<>();
        siembras.add(new LoteSiembra(123,"peligro",Clima.TROPICAL));
        siembras.add(new LoteSiembra(113,"peligro",Clima.TEMPLADO));
        siembras.add(new LoteSiembra(320,"peligro",Clima.SECO));
        siembras.add(new LoteSiembra(149,"peligro",Clima.TROPICAL));
        siembras.add(new LoteSiembra(17123,"peligro",Clima.SECO));

        for(LoteSiembra i : siembras){
            Invernadero nuevo = fincas.obtenerMejorInvernadero(i.getClimaRequerido());
            if(nuevo == null){
                System.out.println("ALERTA! Lote[" + i.getIdLote() + "] sin refugio");
            }else{
                System.out.println("SALVADO! Lote["+i.getIdLote()+"] de ["+i.getEspecie()+"] asignado a Invernadero["+i.getInvernadero()+"]");
            }
        }
    }
}