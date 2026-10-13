// PILA: el último en entrar es el primero en salir (LIFO)
class Pila {
    int[] datos = new int[5];   // capacidad máxima: 5
    int cantidad = 0;           // cuántos elementos hay

    // push: agrega un elemento arriba
    void push(int x) {
        if (cantidad == datos.length) {
            System.out.println("Pila llena, no se puede agregar " + x);
        } else {
            datos[cantidad] = x;
            cantidad++;
        }
    }

    // pop: quita y devuelve el elemento de arriba
    int pop() {
        if (cantidad == 0) {
            System.out.println("Pila vacía");
            return -1;
        }
        cantidad--;
        return datos[cantidad];
    }

    // peek: mira el elemento de arriba sin quitarlo
    int peek() {
        if (cantidad == 0) {
            System.out.println("Pila vacía");
            return -1;
        }
        return datos[cantidad - 1];
    }

    // vaciar: borra todo
    void vaciar() {
        cantidad = 0;
    }

    // mostrar: imprime de arriba hacia abajo
    void mostrar() {
        System.out.print("Pila (arriba -> abajo): ");
        for (int i = cantidad - 1; i >= 0; i--) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }
}

// Ejemplo real: pila de platos numerados en un restaurante
public class EjemploPila {
    public static void main(String[] args) {
        Pila platos = new Pila();

        System.out.println("Apilamos los platos 1, 2 y 3");
        platos.push(1);
        platos.push(2);
        platos.push(3);
        platos.mostrar();

        System.out.println("Platos en la pila: " + platos.cantidad);
        System.out.println("Plato de arriba (peek): " + platos.peek());

        System.out.println("Sacamos un plato (pop): " + platos.pop());
        platos.mostrar();

        System.out.println("Llenamos la pila");
        platos.push(4);
        platos.push(5);
        platos.push(6);
        platos.push(7);   // no cabe
        platos.mostrar();

        System.out.println("Vaciamos la pila");
        platos.vaciar();
        platos.mostrar();
        platos.pop();     // no hay nada que sacar
    }
}