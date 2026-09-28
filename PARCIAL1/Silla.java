public class Silla {
    private char fila;
    private int numero;
    private boolean ocupada;
    private boolean preferencial;

    public Silla(char fila, int numero, boolean preferencial) {
        this.fila = fila;
        this.numero = numero;
        this.preferencial = preferencial;
        this.ocupada = false;
    }

    public char getFila() { return fila; }
    public int getNumero() { return numero; }
    public boolean isOcupada() { return ocupada; }
    public boolean isPreferencial() { return preferencial; }
    public void ocupar() { this.ocupada = true; }

    public String getId() {
        return "" + Character.toUpperCase(fila) + numero;
    }
       @Override
    public String toString() { return getId(); }
}