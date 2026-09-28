public class Sala {
    public static final String[] FRANJAS = {"05:00 - 04:30", "45:30 - 19:00", "19:00 - 21:00"};
    public static final double PRECIO_GENERAL = 8000;
    public static final double PRECIO_PREFERENCIAL = 12000;
    public static final double PRECIO_SALA3 = 10000;

    private int id;
    private boolean tienePreferencial;
    private boolean solo3D; // true unicamente para la sala 3
    private Funcion[] funciones;

    public Sala(int id) {
        this.id = id;
        this.tienePreferencial = (id == 1 || id == 2);
        this.solo3D = (id == 3);
        this.funciones = new Funcion[FRANJAS.length];
        for (int i = 0; i < FRANJAS.length; i++) {
            funciones[i] = new Funcion(FRANJAS[i], tienePreferencial);
        }
    }

    public int getId() { return id; }
    public boolean tienePreferencial() { return tienePreferencial; }
    public boolean isSolo3D() { return solo3D; }
    public Funcion[] getFunciones() { return funciones; }
    public Funcion getFuncion(int franjaIdx) { return funciones[franjaIdx]; }

    public boolean aceptaTipo(String tipoPelicula) {
        boolean es3D = tipoPelicula.equalsIgnoreCase("3D");
        if (solo3D) return es3D;      
        return !es3D;                  
    }

public double precioSilla(Silla s) {
        if (solo3D) return PRECIO_SALA3;
        return s.isPreferencial() ? PRECIO_PREFERENCIAL : PRECIO_GENERAL;
    }
}