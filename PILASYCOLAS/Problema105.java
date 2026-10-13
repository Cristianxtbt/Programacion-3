import java.util.Scanner;

// 10.5: Repartidores de propaganda.
//  - Se crea una COLA con el número de seguridad social de cada repartidor
//    y la entidad anunciada, para un único día de trabajo.
//  - Se actualiza una LISTA ENLAZADA (que ya existe con contenido) con los datos de la cola:
//      * si el repartidor ya está en la lista con esa entidad, se suma un día de trabajo
//      * si no está, se agrega a la lista con 1 día
public class Problema105 {

    // Un dato de la cola: un repartidor y la entidad anunciada ese día
    static class Registro {
        String ss;        // número de seguridad social
        String entidad;   // entidad anunciada

        Registro(String ss, String entidad) {
            this.ss = ss;
            this.entidad = entidad;
        }
    }

    // Cola simple de registros
    static class Cola {
        Registro[] datos;
        int cantidad = 0;

        Cola(int capacidad) {
            datos = new Registro[capacidad];
        }

        void encolar(Registro r) {
            if (cantidad == datos.length) {
                System.out.println("Cola llena");
            } else {
                datos[cantidad] = r;
                cantidad++;
            }
        }

        Registro desencolar() {
            if (cantidad == 0) {
                System.out.println("Cola vacía");
                return null;
            }
            Registro primero = datos[0];
            for (int i = 0; i < cantidad - 1; i++) {
                datos[i] = datos[i + 1];
            }
            cantidad--;
            return primero;
        }

        void mostrar() {
            if (cantidad == 0) {
                System.out.println("  (cola vacía)");
            }
            for (int i = 0; i < cantidad; i++) {
                System.out.println("  " + datos[i].ss + " - " + datos[i].entidad);
            }
        }
    }

    // Nodo de la lista enlazada
    static class Nodo {
        String ss;
        String entidad;
        int dias;         // días trabajados para esa entidad
        Nodo siguiente;

        Nodo(String ss, String entidad, int dias) {
            this.ss = ss;
            this.entidad = entidad;
            this.dias = dias;
            this.siguiente = null;
        }
    }

    static Nodo inicio = null;   // primer nodo de la lista

    // Agrega un nodo al principio de la lista
    static void agregar(String ss, String entidad, int dias) {
        Nodo nuevo = new Nodo(ss, entidad, dias);
        nuevo.siguiente = inicio;
        inicio = nuevo;
    }

    // Actualiza la lista con todos los datos de la cola
    static void actualizarLista(Cola cola) {
        while (cola.cantidad > 0) {
            Registro r = cola.desencolar();

            // Buscar si ya existe ese repartidor con esa entidad
            Nodo p = inicio;
            int encontrado = 0;
            while (p != null && encontrado == 0) {
                if (p.ss.equals(r.ss) && p.entidad.equals(r.entidad)) {
                    p.dias++;
                    encontrado = 1;
                } else {
                    p = p.siguiente;
                }
            }

            // Si no estaba, se agrega nuevo con 1 día
            if (encontrado == 0) {
                agregar(r.ss, r.entidad, 1);
            }
        }
    }

    static void mostrarLista() {
        if (inicio == null) {
            System.out.println("  (lista vacía)");
        }
        Nodo p = inicio;
        while (p != null) {
            System.out.println("  " + p.ss + " - " + p.entidad + " - " + p.dias + " día(s)");
            p = p.siguiente;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // La lista ya existe con contenido
        agregar("111", "Pepsi", 3);
        agregar("222", "Nike", 1);
        agregar("333", "Pepsi", 2);

        Cola cola = new Cola(100);

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== REPARTIDORES =====");
            System.out.println("1. Agregar repartidor del día a la cola");
            System.out.println("2. Mostrar la cola");
            System.out.println("3. Actualizar la lista con los datos de la cola");
            System.out.println("4. Mostrar la lista");
            System.out.println("0. Salir");
            System.out.print("Elige: ");
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                System.out.print("Número de seguridad social: ");
                String ss = sc.nextLine();
                System.out.print("Entidad anunciada: ");
                String entidad = sc.nextLine();
                cola.encolar(new Registro(ss, entidad));
            }

            if (opcion == 2) {
                System.out.println("Cola (seguridad social - entidad):");
                cola.mostrar();
            }

            if (opcion == 3) {
                actualizarLista(cola);
                System.out.println("Lista actualizada");
            }

            if (opcion == 4) {
                System.out.println("Lista (seguridad social - entidad - días):");
                mostrarLista();
            }
        }
    }
}