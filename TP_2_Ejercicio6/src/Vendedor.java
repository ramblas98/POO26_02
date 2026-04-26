public class Vendedor {
    private int legajo;
    private String zonaDeVenta;
    private float[] ventasMensuales = new float[12];
    private float totalAnual;
    private float comision;
    private float TasaDeComision = 25;
    public Vendedor(){
        this.legajo = 0;
        this.zonaDeVenta = "NT";
        for (int i = 0; i < ventasMensuales.length; i++){
            this.ventasMensuales[i] = 0;
        }
        float c = 0;
        for (int j = 0; j < ventasMensuales.length; j++){
            c = c + this.ventasMensuales[j];
        }
        this.totalAnual = c/ventasMensuales.length;
        this.comision = this.totalAnual * (this.TasaDeComision/100);
    }
}
