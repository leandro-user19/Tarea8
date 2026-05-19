public class Docente extends Persona{
    private String materia;


    public Docente(String cedula, String nombre, int edad, String materia) {
        super(cedula, nombre, edad);

        this.materia=materia;
    }

    @Override
    public void mostrar() {
        super.mostrar();

        System.out.println("Materia: " + materia);

    }
}
