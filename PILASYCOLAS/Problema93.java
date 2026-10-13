import java.util.Scanner;

// 9.3: verificar el equilibrio de paréntesis, llaves y corchetes
public class Problema93 {

    // Pila simple (guarda enteros; los caracteres también caben)
    static class Pila {
        int[] datos;
        int cantidad = 0;

        Pila(int capacidad) {
            datos = new int[capacidad];
        }

        void push(int x) {
            if (cantidad == datos.length) {
                System.out.println("Pila llena, no se puede agregar " + x);
            } else {
                datos[cantidad] = x;
                cantidad++;
            }
        }

        int pop() {
            if (cantidad == 0) {
                System.out.println("Pila vacía");
                return -1;
            }
            cantidad--;
            return datos[cantidad];
        }

        int peek() {
            if (cantidad == 0) {
                return -1;
            }
            return datos[cantidad - 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe la expresión: ");
        String exp = sc.nextLine();

        Pila pila = new Pila(exp.length() + 1);
        int error = 0;   // pasa a 1 si encontramos un error

        for (int i = 0; i < exp.length() && error == 0; i++) {
            char c = exp.charAt(i);

            // Si abre, se apila
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }

            // Si cierra, se saca de la pila y se revisa que sea su pareja
            if (c == ')' || c == ']' || c == '}') {
                if (pila.cantidad == 0) {
                    System.out.println("Sobra un '" + c + "'");
                    error = 1;
                } else {
                    char abierto = (char) pila.pop();
                    if (c == ')' && abierto != '(') error = 1;
                    if (c == ']' && abierto != '[') error = 1;
                    if (c == '}' && abierto != '{') error = 1;
                    if (error == 1) {
                        System.out.println("'" + abierto + "' no se cierra con '" + c + "'");
                    }
                }
            }
        }

        // Si quedó algo en la pila, falta cerrarlo
        if (error == 0 && pila.cantidad > 0) {
            char falta = (char) pila.peek();
            if (falta == '(') System.out.println("Falta un paréntesis ')'");
            if (falta == '[') System.out.println("Falta un corchete ']'");
            if (falta == '{') System.out.println("Falta una llave '}'");
            error = 1;
        }

        if (error == 0) {
            System.out.println("La expresión está equilibrada");
        }
    }
}