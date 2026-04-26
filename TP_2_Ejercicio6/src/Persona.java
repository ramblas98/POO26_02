public class Persona {
    private int dni;
    private String nombres;
    private String apellidos;
    Vendedor info;
    public Persona(){
        this.dni = 0;
        this.nombres = "name";
        this.apellidos = "surname";
        this.info = new Vendedor();
    }

    public Persona(int dni,String nombres,String apellidos){
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
