public class Complejo {
    private double real;
    private double imaginaria;
    private static final double epsilon = 0.00001;

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
        aux = (c*c + d*d);
        if(Math.abs(aux) < epsilon){
            throw new ArithmeticException("cero");
        }
        this.real = (a*c + b*d)/aux;
        this.imaginaria = (b*c - a*d)/aux;
    }

    public double modulo(){
        double resultado = Math.sqrt(Math.pow(real,2) + Math.pow(imaginaria,2));
        return resultado;
    }

    public static Complejo sumar(Complejo c1, Complejo c2){
        Complejo nuevo = new Complejo(c1.real,c1.imaginaria);
        nuevo.sumar(c2);
        return nuevo;
    }

    public static Complejo restar(Complejo c1, Complejo c2){
        Complejo nuevo = new Complejo(c1.real,c1.imaginaria);
        nuevo.restar(c2);
        return nuevo;
    }

    public static Complejo multiplicar(Complejo c1, Complejo c2){
        Complejo nuevo = new Complejo(c1.real,c1.imaginaria);
        nuevo.multiplicar(c2);
        return nuevo;
    }

    public static Complejo dividir(Complejo c1, Complejo c2){
        Complejo nuevo = new Complejo(c1.real,c1.imaginaria);
        nuevo.dividir(c2);
        return nuevo;
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

    public Complejo potencia(int n){
        if (n == 0) {
            return new Complejo(1, 0);
        }
        double r = this.modulo();
        if (Math.abs(r) < epsilon) {
            if (n > 0) {
                return new Complejo(0, 0);
            } else {
                throw new ArithmeticException("Potencia negativa de cero: indefinida");
            }
        }
        double theta = this.argumento();
        double nuevoModulo = Math.pow(r, n);
        double nuevoArgumento = theta * n;
        double real = nuevoModulo * Math.cos(nuevoArgumento);
        double imag = nuevoModulo * Math.sin(nuevoArgumento);

        if (Math.abs(real) < epsilon) real = 0.0;
        if (Math.abs(imag) < epsilon) imag = 0.0;
        return new Complejo(real, imag);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Complejo otro = (Complejo) obj;

        return Math.abs(this.real - otro.real) <= epsilon &&
                Math.abs(this.imaginaria - otro.imaginaria) <= epsilon;
    }

    @Override
    public String toString() {
        // Caso: parte imaginaria es cero (dentro de la tolerancia)
        if (Math.abs(imaginaria) < epsilon) {
            return String.format("%.2f", real);
        }
        // Caso: parte real es cero
        if (Math.abs(real) < epsilon) {
            return String.format("%.2fi", imaginaria);
        }
        // Caso general: a + bi (o a - bi)
        String signo = (imaginaria > 0) ? "+" : "-";
        double imagAbs = Math.abs(imaginaria);
        return String.format("%.2f %s %.2fi", real, signo, imagAbs);
    }
}
