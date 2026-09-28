public class Funcion {
    private String franjaHoraria;
    private Pelicula pelicula; 
    private Silla[][] asientosGenerales;    
    private Silla[][] asientosPreferenciales; 

    private static final int FILAS_GENERALES = 6;
    private static final int SILLAS_GENERAL = 12;
    private static final int FILAS_PREFERENCIALES = 2;
    private static final int SILLAS_PREFERENCIAL = 9;

    public Funcion(String franjaHoraria, boolean tienePreferencial) {
        this.franjaHoraria = franjaHoraria;
        this.pelicula = null;

        asientosGenerales = new Silla[FILAS_GENERALES][SILLAS_GENERAL];
        for (int f = 0; f < FILAS_GENERALES; f++) {
            char letraFila = (char) ('a' + f);
            for (int c = 0; c < SILLAS_GENERAL; c++) {
                asientosGenerales[f][c] = new Silla(letraFila, c + 1, false);
            }
        }

        if (tienePreferencial) {
            asientosPreferenciales = new Silla[FILAS_PREFERENCIALES][SILLAS_PREFERENCIAL];
            for (int f = 0; f < FILAS_PREFERENCIALES; f++) {
                char letraFila = (char) ('g' + f);
                for (int c = 0; c < SILLAS_PREFERENCIAL; c++) {
                    asientosPreferenciales[f][c] = new Silla(letraFila, c + 1, true);
                }
            }
        } else {
            asientosPreferenciales = null;
        }
    }

    public String getFranjaHoraria() { return franjaHoraria; }
    public Pelicula getPelicula() { return pelicula; }
    public boolean tienePeliculaAsignada() { return pelicula != null; }
    public void asignarPelicula(Pelicula p) { this.pelicula = p; }

    public Silla buscarSilla(String id) {
        if (id == null || id.length() < 2) return null;
        char letra = Character.toLowerCase(id.charAt(0));
        int numero;
        try {
            numero = Integer.parseInt(id.substring(1));
        } catch (NumberFormatException e) {
            return null;
        }

        if (letra >= 'a' && letra <= 'f') {
            int filaIdx = letra - 'a';
            int colIdx = numero - 1;
            if (filaIdx >= 0 && filaIdx < FILAS_GENERALES && colIdx >= 0 && colIdx < SILLAS_GENERAL) {
                return asientosGenerales[filaIdx][colIdx];
            }
        } else if (asientosPreferenciales != null && (letra == 'g' || letra == 'h')) {
            int filaIdx = letra - 'g';
            int colIdx = numero - 1;
            if (colIdx >= 0 && colIdx < SILLAS_PREFERENCIAL) {
                return asientosPreferenciales[filaIdx][colIdx];
            }
        }
        return null;
    }

    public int contarDisponibles() {
        int total = 0;
        for (Silla[] fila : asientosGenerales)
            for (Silla s : fila)
                if (!s.isOcupada()) total++;
        if (asientosPreferenciales != null)
            for (Silla[] fila : asientosPreferenciales)
                for (Silla s : fila)
                    if (!s.isOcupada()) total++;
        return total;
    }

    public void mostrarMapaAsientos() {
        System.out.println();
        if (asientosPreferenciales != null) {
            System.out.println("      -- Seccion Preferencial --");
            for (int f = FILAS_PREFERENCIALES - 1; f >= 0; f--) {
                char letra = (char) Character.toUpperCase('g' + f);
                StringBuilder sb = new StringBuilder();
                sb.append(letra).append("  ");
                for (Silla s : asientosPreferenciales[f]) {
                    sb.append(s.isOcupada() ? "X " : "_ ");
                }
                System.out.println(sb.toString());
            }
            System.out.println(" -");
        }
        System.out.println("      -- Seccion General --");
        for (int f = FILAS_GENERALES - 1; f >= 0; f--) {
            char letra = (char) Character.toUpperCase('a' + f);
            StringBuilder sb = new StringBuilder();
            sb.append(letra).append("  ");
            for (Silla s : asientosGenerales[f]) {
                sb.append(s.isOcupada() ? "X " : "_ ");
            }
            System.out.println(sb.toString());
        }
        System.out.println("[ PANTALLA ]");
        System.out.println("Sillas disponibles: " + contarDisponibles());
        System.out.println();
    }
}