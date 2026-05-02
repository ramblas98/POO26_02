public class Complejo {
    private double real;
    private double imaginaria;
    private static final double epsilon = 0.001;

    public Complejo(){
        this.real = 0;
        this.imaginaria = 0;
    }

    public Complejo(double r, double ima){
        this.real = r;
        this.imaginaria = ima;
    }

    public double getReal() {
        return real;
    }

    public double getImaginaria() {
        return imaginaria;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginaria(double imaginaria) {
        this.imaginaria = imaginaria;
    }

    public void sumar(Complejo c){
        this.real = c.real + this.real;
        this.imaginaria = this.imaginaria + c.imaginaria;
    }

    public void restar(Complejo c){
        this.real = c.real - this.real;
        this.imaginaria = this.imaginaria - c.imaginaria;
    }

    public void multiplicar(Complejo com){
        double a,b,c,d;
        a = this.real;
        b = this.imaginaria;
        c = com.real;
        d = com.imaginaria;

        this.real = a*c - b*d;
        this.imaginaria = a*d + b*c;
    }

    public void dividir(Complejo com){
        double a,b,c,d,aux;
        a = this.real;
        b = this.imaginaria;
        c = com.real;
        d = com.imaginaria;
        if(modulo() < epsilon){
            aux = (c*c + d*d);
            if(modulo() < epsilon){
                this.real = (a*c + b*d)/aux;
                this.imaginaria = (b*c - a*d)/aux;
            }
        }
    }

    public double modulo(){
        double resultado = Math.sqrt(Math.pow(real,2) + Math.pow(imaginaria,2));
        return resultado;
    }

    public static Complejo sumar(Complejo c1, Complejo c2){
        c1.sumar(c2);
        Complejo c3 = c1;
        return c3;
    }

    public static Complejo restar(Complejo c1, Complejo c2){
        c1.restar(c2);
        Complejo c3 = c1;
        return c3;
    }

    public static Complejo multiplicar(Complejo c1, Complejo c2){
        c1.multiplicar(c2);
        Complejo c3 = c1;
        return c3;
    }

    public static Complejo dividir(Complejo c1, Complejo c2){
        c1.dividir(c2);
        Complejo c3 = c1;
        return c3;
    }

    public double argumento(){
        return Math.atan2(imaginaria,real);
    }

    public Complejo conjugado(){
        Complejo nuevo = new Complejo(real,-imaginaria);
        return nuevo;
    }

    public Complejo opuesto(){
        Complejo nuevo = new Complejo(-real,-imaginaria);
        return nuevo;
    }


}
