// COLA: el primero en entrar es el primero en salir (FIFO)
class Cola {
    int[] datos = new int[5];   // capacidad máxima: 5
    int cantidad = 0;           // cuántos elementos hay

    // encolar: agrega un elemento al final
    void encolar(int x) {
        if (cantidad == datos.length) {
            System.out.println("Cola llena, no se puede agregar " + x);
        } else {
            datos[cantidad] = x;
            cantidad++;
        }
    }

    // desencolar: quita y devuelve el primero
    int desencolar() {
        if (cantidad == 0) {
            System.out.println("Cola vacía");
            return -1;
        }
        int primero = datos[0];
        // corremos todos una posición hacia el frente
        for (int i = 0; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1];
        }
        cantidad--;
        return primero;
    }

    // verFrente: mira el primero sin quitarlo
    int verFrente() {
        if (cantidad == 0) {
            System.out.println("Cola vacía");
            return -1;
        }
        return datos[0];
    }

    // vaciar: borra todo
    void vaciar() {
        cantidad = 0;
    }

    // mostrar: imprime del frente al final
    void mostrar() {
        System.out.print("Cola (frente -> final): ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }
}

// Ejemplo real: fila de un banco, cada cliente tiene un número de ficha
public class EjemploCola {
    public static void main(String[] args) {
        Cola fila = new Cola();

        System.out.println("Llegan los clientes con fichas 1, 2 y 3");
        fila.encolar(1);
        fila.encolar(2);
        fila.encolar(3);
        fila.mostrar();

        System.out.println("Clientes en la fila: " + fila.cantidad);
        System.out.println("Siguiente en atender (verFrente): " + fila.verFrente());

        System.out.println("Atendemos a la ficha (desencolar): " + fila.desencolar());
        fila.mostrar();

        System.out.println("Llenamos la fila");
        fila.encolar(4);
        fila.encolar(5);
        fila.encolar(6);
        fila.encolar(7);   // no cabe
        fila.mostrar();

        System.out.println("Vaciamos la fila");
        fila.vaciar();
        fila.mostrar();
        fila.desencolar();   // no hay nadie que atender
    }
}