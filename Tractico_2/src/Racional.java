public class Racional {
    private int numerador;
    private int denominador;

    //Inicializar Racional xd
    public Racional(){
        this.numerador = 0;
        this.denominador = 1;
        simplificar();
    }

    //Pedir Racional
    public Racional(int numerador, int denominador){
        this.numerador = numerador;
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

    }

    public double aDecimal(){
        return (double) numerador/denominador;
    }
}
