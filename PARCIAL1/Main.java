import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Teatro teatro = new Teatro();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n================ CINEMASTAR ================");
            System.out.println("1. Menu de creacion de peliculas");
            System.out.println("2. Menu de asignacion de funciones");
            System.out.println("3. Menu de ventas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerEntero();
            switch (opcion) {
                case 1: menuPeliculas(); break;
                case 2: menuAsignacionFunciones(); break;
                case 3: menuVentas(); break;
                case 4:
                    salir = true;
                    System.out.println("Cerrando la aplicacion. Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        }
        sc.close();
    }

    private static void menuPeliculas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n---- Creacion de Peliculas ----");
            System.out.println("1. Mostrar peliculas registradas");
            System.out.println("2. Anadir pelicula");
            System.out.println("3. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            int op = leerEntero();

            switch (op) {
                case 1:
                    Pelicula[] lista = teatro.getPeliculas();
                    if (lista.length == 0) {
                        System.out.println("No hay peliculas registradas.");
                    } else {
                        for (int i = 0; i < lista.length; i++) {
                            System.out.println((i + 1) + ". " + lista[i]);
                        }
                    }
                    break;
                case 2:
                    anadirPelicula();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    private static void anadirPelicula() {
        System.out.print("Nombre de la pelicula: ");
        String nombre = sc.nextLine();

        System.out.print("Idioma: ");
        String idioma = sc.nextLine();

        String tipo = "";
        while (!tipo.equalsIgnoreCase("35mm") && !tipo.equalsIgnoreCase("3D")) {
            System.out.print("Tipo (35mm / 3D): ");
            tipo = sc.nextLine().trim();
        }

        System.out.print("Duracion en minutos: ");
        int duracion = leerEntero();

        Pelicula p = new Pelicula(nombre, idioma, tipo, duracion);
        if (teatro.registrarPelicula(p)) {
            System.out.println("Pelicula registrada exitosamente.");
        } else {
            System.out.println("No se pudo registrar la pelicula (limite alcanzado).");
        }
    }

    private static void menuAsignacionFunciones() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n---- Asignacion de Funciones ----");
            System.out.println("1. Asignar pelicula a una sala/franja");
            System.out.println("2. Ver cartelera del dia");
            System.out.println("3. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            int op = leerEntero();

            switch (op) {
                case 1: asignarFuncion(); break;
                case 2: verCartelera(); break;
                case 3: volver = true; break;
                default: System.out.println("Opcion invalida.");
            }
        }
    }

    private static void asignarFuncion() {
        if (teatro.getTotalPeliculas() == 0) {
            System.out.println("Primero debe registrar al menos una pelicula.");
            return;
        }

        int salaId = pedirSala();
        int franjaIdx = pedirFranja();

        Pelicula[] lista = teatro.getPeliculas();
        System.out.println("Peliculas disponibles:");
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + ". " + lista[i]);
        }
        System.out.print("Seleccione el numero de la pelicula a asignar: ");
        int idx = leerEntero() - 1;

        if (idx < 0 || idx >= lista.length) {
            System.out.println("Seleccion invalida.");
            return;
        }

        String resultado = teatro.asignarFuncion(salaId, franjaIdx, lista[idx]);
        switch (resultado) {
            case "OK":
                System.out.println("Pelicula asignada correctamente a Sala " + salaId
                        + " en la franja " + Sala.FRANJAS[franjaIdx] + ".");
                break;
            case "TIPO_INCOMPATIBLE":
                System.out.println("ERROR: esa sala no admite peliculas de tipo " + lista[idx].getTipo() + ".");
                break;
            case "FRANJA_OCUPADA":
                System.out.println("ERROR: la sala ya tiene una pelicula asignada en esa franja horaria.");
                break;
        }
    }

    private static void verCartelera() {
        System.out.println("\n================ CARTELERA DEL DIA ================");
        for (Sala sala : teatro.getSalas()) {
            System.out.println("\nSala " + sala.getId() + (sala.isSolo3D() ? " (solo 3D)" : ""));
            for (int i = 0; i < Sala.FRANJAS.length; i++) {
                Funcion f = sala.getFuncion(i);
                String pelicula = f.tienePeliculaAsignada() ? f.getPelicula().getNombre() : "-- sin asignar --";
                System.out.println("  " + Sala.FRANJAS[i] + " : " + pelicula
                        + "  (disponibles: " + f.contarDisponibles() + ")");
            }
        }
    }

    private static void menuVentas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n---- Modulo de Ventas ----");
            int salaId = pedirSala();
            int franjaIdx = pedirFranja();

            Sala sala = teatro.getSala(salaId);
            Funcion funcion = sala.getFuncion(franjaIdx);

            if (!funcion.tienePeliculaAsignada()) {
                System.out.println("Esta funcion aun no tiene pelicula asignada. Asignela primero.");
            } else {
                venderEntradas(sala, funcion);
            }

            System.out.print("\nDesea realizar otra venta? (S/N): ");
            String resp = sc.nextLine().trim();
            if (!resp.equalsIgnoreCase("S")) {
                volver = true;
            }
        }
    }

    private static void venderEntradas(Sala sala, Funcion funcion) {
        System.out.println("\nPelicula: " + funcion.getPelicula().getNombre()
                + " | Franja: " + funcion.getFranjaHoraria());
        funcion.mostrarMapaAsientos();

        System.out.print("Ingrese las sillas a comprar separadas por coma (ej: A3,B8,D9): ");
        String entrada = sc.nextLine();
        String[] idsSillas = entrada.split(",");

        Teatro.ResultadoCompra resultado = teatro.comprarSillas(sala, funcion, idsSillas);

        System.out.println("\n---- Resultado de la compra ----");
        for (int i = 0; i < resultado.totalMensajes; i++) {
            System.out.println(resultado.mensajes[i]);
        }
        if (resultado.sillasCompradas > 0) {
            System.out.println("Total de sillas compradas: " + resultado.sillasCompradas);
            System.out.printf("Total a pagar: $%.0f%n", resultado.totalPagar);
        } else {
            System.out.println("No se realizo ninguna compra.");
        }

        System.out.println("\nMapa actualizado de sillas:");
        funcion.mostrarMapaAsientos();
    }

    private static int pedirSala() {
        int salaId = 0;
        while (salaId < 1 || salaId > 3) {
            System.out.print("Seleccione la sala (1, 2 o 3): ");
            salaId = leerEntero();
        }
        return salaId;
    }

    private static int pedirFranja() {
        System.out.println("Franjas horarias disponibles:");
        for (int i = 0; i < Sala.FRANJAS.length; i++) {
            System.out.println((i + 1) + ". " + Sala.FRANJAS[i]);
        }
        int franja = 0;
        while (franja < 1 || franja > Sala.FRANJAS.length) {
            System.out.print("Seleccione la franja horaria: ");
            franja = leerEntero();
        }
        return franja - 1;
    }

    private static int leerEntero() {
        while (true) {
            try {
                String linea = sc.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.print("Por favor ingrese un numero valido: ");
            }
        }
    }
}