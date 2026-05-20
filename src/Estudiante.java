public class Estudiante extends Persona{
    private String carrera;


    public Estudiante(String cedula, String nombre, int edad, String carrera) {
        super(cedula, nombre, edad);

        this.carrera=carrera;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Carrera: " + carrera);
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
