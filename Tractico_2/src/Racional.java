public class Racional {
    private int numerador;
    private int denominador;

    //Inicializar Racional xd
    public Racional(){
        this.numerador = 0;
        this.denominador = 1;
    }

    //Pedir Racional
    public Racional(int numerador, int denominador){
        this.numerador = numerador;
        if(denominador == 0){
            this.denominador = 1;
            System.out.println("Tiene que ser distinto de 0 pero se agrego 1 por defecto");
        }
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        if(denominador != 0){
            this.denominador = denominador;
        }else{
            System.out.println("Denominador distinto de 0");
        }
    }

    public void sumar(Racional r){
        this.numerador = this.numerador * r.denominador + r.numerador * this.denominador;
        this.denominador = r.denominador * this.denominador;
    }

    public void restar(Racional r){
        this.numerador = this.numerador * r.denominador - r.numerador * this.denominador;
        this.denominador = r.denominador * this.denominador;
    }

    public void multiplicar(Racional r){
        this.numerador = r.numerador * this.numerador;
        this.denominador = r.denominador * this.denominador;
    }

    public void dividir(Racional r){
        this.numerador = this.numerador * r.denominador;
        this.denominador = this.denominador * r.numerador;
    }

    public Racional simplificar(){
        int divisor = mcd(Math.abs(numerador), Math.abs(denominador));

        numerador /= divisor;
        denominador /= divisor;

        if (denominador < 0) {
            numerador *= -1;
            denominador *= -1;
        }

        return this;
    }

    public double aDecimal(){
        return (double) numerador/denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Racional){
            Racional otro = (Racional) obj;

            return this.numerador * otro.denominador == otro.numerador * this.denominador;
        }

        return false;
    }

    public int compareTo(Racional r) {
        int valor1 = this.numerador * r.denominador;
        int valor2 = r.numerador * this.denominador;

        return Integer.compare(valor1,valor2);
    }

    public static Racional sumar(Racional r1,Racional r2){
        int nume = r1.numerador * r2.denominador + r2.numerador * r1.denominador;
        int demo = r1.denominador * r2.denominador;

        return new Racional(nume,demo);
    }

    public static Racional restar(Racional r1,Racional r2){
        int nume = r1.numerador * r2.denominador - r2.numerador * r1.denominador;
        int demo = r1.denominador * r2.denominador;

        return new Racional(nume,demo);
    }

    public static Racional multiplicar(Racional r1,Racional r2){
        int nume = r1.numerador * r2.numerador;
        int demo = r1.denominador * r2.denominador;

        return new Racional(nume,demo);
    }

    public static Racional dividir(Racional r1,Racional r2){
        int nume = r1.numerador * r2.denominador;
        int demo = r1.denominador * r2.numerador;

        return new Racional(nume,demo);
    }

    private static int mcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
