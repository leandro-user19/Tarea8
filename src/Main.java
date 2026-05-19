import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Persona> lista = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n1. Registrar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Salir");
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

                    System.out.println("Saliendo...");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 3);
    }

    public static void registrarPersona(Scanner sc, ArrayList<Persona> lista) {

        try {

            System.out.println("\nSeleccione tipo:");
            System.out.println("1. Estudiante");
            System.out.println("2. Docente");

            int tipo = sc.nextInt();
            sc.nextLine();

            //validacion de cedula//
            String cedula;

            do {

                System.out.print("Ingrese cedula: ");
                cedula = sc.nextLine();

                if (!cedula.matches("\\d{10}")) {
                    System.out.println("La cedula debe tener 10 numeros.");
                }

            } while (!cedula.matches("\\d{10}"));

            //validar nombre//
            String nombre;

            do {

                System.out.print("Ingrese nombre: ");
                nombre = sc.nextLine();

                if (!nombre.matches("[a-zA-Z ]+")) {
                    System.out.println("El nombre solo debe contener letras.");
                }

            } while (!nombre.matches("[a-zA-Z ]+"));

            //validación de edad//
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

            System.out.println("\nRegistro agregado correctamente.");

        } catch (InputMismatchException e) {

            System.out.println("Error: ingreso incorrecto.");

            sc.nextLine();
        }
    }

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
}