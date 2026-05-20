import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Persona> lista = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Actualizar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");

            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarPersona(sc, lista);
                    break;

                case 2:
                    mostrarPersonas(lista);
                    break;

                case 3:
                    actualizarPersona(sc, lista);
                    break;

                case 4:
                    eliminarPersona(sc, lista);
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 5);
    }

    //registro//

    public static void registrarPersona(Scanner sc, ArrayList<Persona> lista) {

        try {

            System.out.println("\nSeleccione tipo:");
            System.out.println("1. Estudiante");
            System.out.println("2. Docente");

            int tipo = sc.nextInt();
            sc.nextLine();

            //validcion de cedula//

            String cedula;

            do {

                System.out.print("Ingrese cedula: ");
                cedula = sc.nextLine();

                if (!cedula.matches("\\d{10}")) {

                    System.out.println("La cedula debe tener 10 numeros.");
                }

            } while (!cedula.matches("\\d{10}"));

            // validacionnombre//

            String nombre;

            do {

                System.out.print("Ingrese nombre: ");
                nombre = sc.nextLine();

                if (!nombre.matches("[a-zA-Z ]+")) {

                    System.out.println("Solo letras.");
                }

            } while (!nombre.matches("[a-zA-Z ]+"));

            //validacíón edad//

            int edad;

            do {

                System.out.print("Ingrese edad: ");
                edad = sc.nextInt();
                sc.nextLine();

                if (edad <= 0) {

                    System.out.println("Edad invalida.");
                }

            } while (edad <= 0);

            if (tipo == 1) {

                System.out.print("Ingrese carrera: ");
                String carrera = sc.nextLine();

                Estudiante e = new Estudiante(
                        cedula,
                        nombre,
                        edad,
                        carrera
                );

                lista.add(e);

            } else if (tipo == 2) {

                System.out.print("Ingrese materia: ");
                String materia = sc.nextLine();

                Docente d = new Docente(
                        cedula,
                        nombre,
                        edad,
                        materia
                );

                lista.add(d);

            } else {

                System.out.println("Tipo invalido.");
            }

            System.out.println("Registro agregado correctamente.");

        } catch (InputMismatchException e) {

            System.out.println("Error de ingreso.");

            sc.nextLine();
        }
    }

    //mostrar//

    public static void mostrarPersonas(ArrayList<Persona> lista) {

        if (lista.isEmpty()) {

            System.out.println("No hay registros.");
            return;
        }

        for (Persona p : lista) {

            System.out.println("\n----------------");

            p.mostrar();
        }
    }

    //actualizar//

    public static void actualizarPersona(Scanner sc, ArrayList<Persona> lista) {

        if (lista.isEmpty()) {

            System.out.println("No hay personas.");
            return;
        }

        System.out.print("Ingrese cedula: ");
        String cedulaBuscar = sc.nextLine();

        boolean encontrado = false;

        for (Persona p : lista) {

            if (p.getCedula().equals(cedulaBuscar)) {

                encontrado = true;

                //nuevo nombre//

                String nuevoNombre;

                do {

                    System.out.print("Nuevo nombre: ");
                    nuevoNombre = sc.nextLine();

                    if (!nuevoNombre.matches("[a-zA-Z ]+")) {

                        System.out.println("Solo letras.");
                    }

                } while (!nuevoNombre.matches("[a-zA-Z ]+"));

                p.setNombre(nuevoNombre);

                //nueva edad//

                int nuevaEdad;

                do {

                    System.out.print("Nueva edad: ");
                    nuevaEdad = sc.nextInt();
                    sc.nextLine();

                    if (nuevaEdad <= 0) {

                        System.out.println("Edad invalida.");
                    }

                } while (nuevaEdad <= 0);

                p.setEdad(nuevaEdad);

                //actualizar carrera//

                if (p instanceof Estudiante) {

                    Estudiante e = (Estudiante) p;

                    System.out.print("Nueva carrera: ");
                    String nuevaCarrera = sc.nextLine();

                    e.setCarrera(nuevaCarrera);
                }

                if (p instanceof Docente) {

                    Docente d = (Docente) p;

                    System.out.print("Nueva materia: ");
                    String nuevaMateria = sc.nextLine();

                    d.setMateria(nuevaMateria);
                }

                System.out.println("Actualizado correctamente.");
            }
        }

        if (!encontrado) {

            System.out.println("Persona no encontrada.");
        }
    }

    //eliminar//

    public static void eliminarPersona(Scanner sc, ArrayList<Persona> lista) {

        if (lista.isEmpty()) {

            System.out.println("No hay personas.");
            return;
        }

        System.out.print("Ingrese cedula: ");
        String cedulaEliminar = sc.nextLine();

        boolean eliminado = false;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getCedula().equals(cedulaEliminar)) {

                lista.remove(i);

                eliminado = true;

                System.out.println("Persona eliminada.");

                break;
            }
        }

        if (!eliminado) {

            System.out.println("Persona no encontrada.");
        }
    }
}