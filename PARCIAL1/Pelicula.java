public class Pelicula {
    private String nombre;
    private String idioma;
    private String tipo; // "35mm" o "3D"
    private int duracionMinutos;

    public Pelicula(String nombre, String idioma, String tipo, int duracionMinutos) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.tipo = tipo;
        this.duracionMinutos = duracionMinutos;
    }

    public String getNombre() { return nombre; }
    public String getIdioma() { return idioma; }
    public String getTipo() { return tipo; }
    public int getDuracionMinutos() { return duracionMinutos; }

    public boolean es3D() { return tipo.equalsIgnoreCase("3D"); }

    @Override
    public String toString() {
        return String.format("%-25s | Idioma: %-10s | Tipo: %-4s | Duracion: %d min",
                nombre, idioma, tipo, duracionMinutos);
    }
}