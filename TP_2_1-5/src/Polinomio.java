import java.util.Scanner;

public class Polinomio {
    private int grado;
    private double[] coeficientes;

    public Polinomio(double[] coeficientes){
        if (coeficientes == null) {
            throw new IllegalArgumentException("El arreglo de coeficientes no puede ser nulo");
        }
        int i;
        int grados = 0;
        for(i = 0; i < coeficientes.length; i++){
            if (Math.abs(coeficientes[i]) > 1e-10) {
                grados = i;
            }
        }

        this.grado = grados;
        this.coeficientes = new double[this.grado + 1];

        for(i = 0; i < this.grado;i++){
            this.coeficientes[i] = coeficientes[i];
        }
    }

    public Polinomio(int grado){
        if(grado < 0){
            throw new IllegalArgumentException("el grado no puede ser negativo");
        }

        this.grado = grado;
        this.coeficientes = new double[grado + 1];
    }

    public int getGrado() {
        return grado;
    }

    public double getCoeficientes(int i) {
        return coeficientes[i];
    }

    public double[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(double[] c, int i) {
        this.coeficientes[i] = c[i];
    }

    public void ingresarPolinomio() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el grado del polinomio: ");
        int nuevoGrado = sc.nextInt();
        if (nuevoGrado < 0) {
            System.out.println("El grado no puede ser negativo. Se usará grado 0.");
            nuevoGrado = 0;
        }
        double[] nuevosCoef = new double[nuevoGrado + 1];
        for (int i = 0; i <= nuevoGrado; i++) {
            System.out.print("Coeficiente para x^" + i + ": ");
            nuevosCoef[i] = sc.nextDouble();
        }
        this.coeficientes = nuevosCoef;
        int gradoReal = 0;
        for (int i = 0; i < this.coeficientes.length; i++) {
            if (Math.abs(this.coeficientes[i]) > 1e-10) {
                gradoReal = i;
            }
        }
        this.grado = gradoReal;
        if (gradoReal + 1 < this.coeficientes.length) {
            double[] temp = new double[gradoReal + 1];
            System.arraycopy(this.coeficientes, 0, temp, 0, gradoReal + 1);
            this.coeficientes = temp;
        }
    }

    public void agregarCoeficiente(double coef, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo");
        }

        if (exp >= this.coeficientes.length) {
            double[] nuevoArreglo = new double[exp + 1];
            System.arraycopy(this.coeficientes, 0, nuevoArreglo, 0, this.coeficientes.length);
            this.coeficientes = nuevoArreglo;
        }

        this.coeficientes[exp] = coef;

        int nuevoGrado = 0;
        for (int i = this.coeficientes.length - 1; i >= 0; i--) {
            if (Math.abs(this.coeficientes[i]) > 1e-10) {
                nuevoGrado = i;
                break;
            }
        }
        this.grado = nuevoGrado;

        if (this.grado + 1 < this.coeficientes.length) {
            double[] temp = new double[this.grado + 1];
            System.arraycopy(this.coeficientes, 0, temp, 0, this.grado + 1);
            this.coeficientes = temp;
        }
    }

    public void sumar(Polinomio p) {
        int maxGrado = Math.max(this.grado, p.grado);
        double[] nuevoCoef = new double[maxGrado + 1];


        for (int i = 0; i <= this.grado; i++) {
            nuevoCoef[i] = this.coeficientes[i];
        }
        for (int i = 0; i <= p.grado; i++) {
            nuevoCoef[i] += p.coeficientes[i];
        }

        int nuevoGrado = 0;
        for (int i = maxGrado; i >= 0; i--) {
            if (Math.abs(nuevoCoef[i]) > 1e-10) {
                nuevoGrado = i;
                break;
            }
        }

        this.grado = nuevoGrado;
        this.coeficientes = new double[nuevoGrado + 1];
        System.arraycopy(nuevoCoef, 0, this.coeficientes, 0, nuevoGrado + 1);
    }

    public void restar(Polinomio p) {
        int maxGrado = Math.max(this.grado, p.grado);
        double[] nuevoCoef = new double[maxGrado + 1];


        for (int i = 0; i <= this.grado; i++) {
            nuevoCoef[i] = this.coeficientes[i];
        }
        for (int i = 0; i <= p.grado; i++) {
            nuevoCoef[i] -= p.coeficientes[i];
        }

        int nuevoGrado = 0;
        for (int i = maxGrado; i >= 0; i--) {
            if (Math.abs(nuevoCoef[i]) > 1e-10) {
                nuevoGrado = i;
                break;
            }
        }

        this.grado = nuevoGrado;
        this.coeficientes = new double[nuevoGrado + 1];
        System.arraycopy(nuevoCoef, 0, this.coeficientes, 0, nuevoGrado + 1);
    }

    public void multiplicar(Polinomio p) {
        int nuevoGrado = this.grado + p.grado;
        double[] nuevoCoef = new double[nuevoGrado + 1];

        for (int i = 0; i <= this.grado; i++) {
            for (int j = 0; j <= p.grado; j++) {
                nuevoCoef[i + j] += this.coeficientes[i] * p.coeficientes[j];
            }
        }

        int gradoReal = 0;
        for (int i = nuevoGrado; i >= 0; i--) {
            if (Math.abs(nuevoCoef[i]) > 1e-10) {
                gradoReal = i;
                break;
            }
        }

        this.grado = gradoReal;
        this.coeficientes = new double[gradoReal + 1];
        System.arraycopy(nuevoCoef, 0, this.coeficientes, 0, gradoReal + 1);
    }

    public Polinomio[] dividir(Polinomio p) {
        boolean divisorCero = true;
        for (int i = 0; i <= p.grado; i++) {
            if (Math.abs(p.coeficientes[i]) > 1e-10) {
                divisorCero = false;
                break;
            }
        }
        if (divisorCero) {
            throw new ArithmeticException("División por polinomio cero");
        }

        Polinomio resto = new Polinomio(this.coeficientes.clone());
        int gradoCociente = this.grado - p.grado;
        if (gradoCociente < 0) {
            Polinomio cociente = new Polinomio(new double[]{0.0});
            Polinomio residuo = new Polinomio(this.coeficientes.clone());
            return new Polinomio[]{cociente, residuo};
        }

        double[] coefCociente = new double[gradoCociente + 1];

        while (resto.grado >= p.grado && !esPolinomioCero(resto)) {
            double coef = resto.coeficientes[resto.grado] / p.coeficientes[p.grado];
            int exp = resto.grado - p.grado;
            coefCociente[exp] = coef;

            double[] monomioCoef = new double[exp + p.grado + 1];
            for (int i = 0; i <= p.grado; i++) {
                monomioCoef[exp + i] = coef * p.coeficientes[i];
            }
            Polinomio monomioPol = new Polinomio(monomioCoef);

            resto.restar(monomioPol);
        }

        Polinomio cociente = new Polinomio(coefCociente);
        return new Polinomio[]{cociente, resto};
    }

    private boolean esPolinomioCero(Polinomio pol) {
        for (int i = 0; i <= pol.grado; i++) {
            if (Math.abs(pol.coeficientes[i]) > 1e-10) {
                return false;
            }
        }
        return true;
    }

    public static Polinomio sumar(Polinomio p1, Polinomio p2){
        Polinomio nuevo = new Polinomio(p1.coeficientes.clone());
        //nuevo = new Polinomio(p1.grado);
        nuevo.sumar(p2);
        return nuevo;
    }

    public static Polinomio restar(Polinomio p1, Polinomio p2){
        Polinomio nuevo = new Polinomio(p1.coeficientes.clone());
        //nuevo = new Polinomio(p1.grado);
        nuevo.restar(p2);
        return nuevo;
    }

    public static Polinomio multiplicar(Polinomio p1, Polinomio p2){
        Polinomio nuevo = new Polinomio(p1.coeficientes.clone());
        //nuevo = new Polinomio(p1.grado);
        nuevo.multiplicar(p2);
        return nuevo;
    }

    public static Polinomio[] dividir(Polinomio p1, Polinomio p2){
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("Los polinomios no pueden ser nulos");
        }
        Polinomio nuevo = new Polinomio(p1.coeficientes.clone());
        //nuevo = new Polinomio(p1.grado);
        return nuevo.dividir(p2);
    }

    public double evaluar(double x) {
        double resultado = 0.0;
        for (int i = this.grado; i >= 0; i--) {
            resultado = resultado * x + this.coeficientes[i];
        }
        return resultado;
    }

    public Polinomio derivar() {
        if (this.grado == 0) {
            return new Polinomio(new double[]{0.0});
        }

        double[] nuevosCoef = new double[this.grado];

        for (int i = 1; i <= this.grado; i++) {
            nuevosCoef[i - 1] = i * this.coeficientes[i];
        }

        return new Polinomio(nuevosCoef);
    }

    public Polinomio integrar() {
        int nuevoGrado = this.grado + 1;
        double[] nuevosCoef = new double[nuevoGrado + 1];

        nuevosCoef[0] = 0.0;

        for (int i = 0; i <= this.grado; i++) {
            nuevosCoef[i + 1] = this.coeficientes[i] / (i + 1.0);
        }

        return new Polinomio(nuevosCoef);
    }

    public double[] calcularRaices() {
        final double EPS = 1e-10;

        if (this.grado == 0) {
            return new double[0];
        }

        if (this.grado == 1) {
            double a = this.coeficientes[1];
            double b = this.coeficientes[0];
            if (Math.abs(a) < EPS) {
                return new double[0];
            }
            double raiz = -b / a;
            return new double[]{raiz};
        }

        if (this.grado == 2) {
            double a = this.coeficientes[2];
            double b = this.coeficientes[1];
            double c = this.coeficientes[0];

            if (Math.abs(a) < EPS) {
                if (Math.abs(b) < EPS) {
                    return new double[0];
                }
                double raiz = -c / b;
                return new double[]{raiz};
            }

            double discriminante = b * b - 4 * a * c;
            if (discriminante < -EPS) {
                return new double[0];
            }
            if (Math.abs(discriminante) < EPS) {
                double raiz = -b / (2 * a);
                return new double[]{raiz};
            }
            double sqrtD = Math.sqrt(discriminante);
            double raiz1 = (-b + sqrtD) / (2 * a);
            double raiz2 = (-b - sqrtD) / (2 * a);
            if (raiz1 > raiz2) {
                double temp = raiz1;
                raiz1 = raiz2;
                raiz2 = temp;
            }
            return new double[]{raiz1, raiz2};
        }

        throw new UnsupportedOperationException("Cálculo de raíces solo para grado ≤ 2");
    }

    @Override
    public String toString() {
        boolean esCero = true;
        for (int i = 0; i <= this.grado; i++) {
            if (Math.abs(this.coeficientes[i]) > 1e-10) {
                esCero = false;
                break;
            }
        }
        if (esCero) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = this.grado; i >= 0; i--) {
            double coef = this.coeficientes[i];
            if (Math.abs(coef) < 1e-10) {
                continue;
            }
            if (sb.length() == 0) {
                if (coef < 0) {
                    sb.append("-");
                }
            } else {
                sb.append(coef > 0 ? " + " : " - ");
            }
            double absCoef = Math.abs(coef);
            if (i == 0) {
                sb.append(String.format("%.2f", absCoef));
            } else {
                if (Math.abs(absCoef - 1.0) < 1e-10) {
                    sb.append("x");
                } else {
                    sb.append(String.format("%.2f", absCoef)).append("x");
                }
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }
        return sb.toString();
    }
}
