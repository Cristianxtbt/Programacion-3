public class Teatro {
    private static final int NUM_SALAS = 3;
    private static final int MAX_PELICULAS = 100;

    private Sala[] salas;
    private Pelicula[] peliculas;
    private int totalPeliculas;

    public Teatro() {
        salas = new Sala[NUM_SALAS];
        for (int i = 0; i < NUM_SALAS; i++) {
            salas[i] = new Sala(i + 1);
        }
        peliculas = new Pelicula[MAX_PELICULAS];
        totalPeliculas = 0;
    }

    public Sala[] getSalas() { return salas; }
    public Sala getSala(int id) { return salas[id - 1]; }

    public boolean registrarPelicula(Pelicula p) {
        if (totalPeliculas >= MAX_PELICULAS) return false;
        peliculas[totalPeliculas++] = p;
        return true;
    }

    public Pelicula[] getPeliculas() {
        Pelicula[] copia = new Pelicula[totalPeliculas];
        System.arraycopy(peliculas, 0, copia, 0, totalPeliculas);
        return copia;
    }

    public int getTotalPeliculas() { return totalPeliculas; }

    public String asignarFuncion(int salaId, int franjaIdx, Pelicula pelicula) {
        Sala sala = getSala(salaId);
        Funcion funcion = sala.getFuncion(franjaIdx);

        if (!sala.aceptaTipo(pelicula.getTipo())) {
            return "TIPO_INCOMPATIBLE";
        }
        if (funcion.tienePeliculaAsignada()) {
            return "FRANJA_OCUPADA";
        }
        funcion.asignarPelicula(pelicula);
        return "OK";
    }

    public static class ResultadoCompra {
        public int sillasCompradas = 0;
        public double totalPagar = 0;
        public String[] mensajes;
        public int totalMensajes = 0;

        public ResultadoCompra(int maxMensajes) {
            mensajes = new String[maxMensajes];
        }

        public void agregarMensaje(String m) {
            if (totalMensajes < mensajes.length) mensajes[totalMensajes++] = m;
        }
    }

    public ResultadoCompra comprarSillas(Sala sala, Funcion funcion, String[] idsSillas) {
        ResultadoCompra resultado = new ResultadoCompra(idsSillas.length);
        int generales = 0;
        int preferenciales = 0;

        for (String id : idsSillas) {
            String idLimpio = id.trim().toUpperCase();
            if (idLimpio.isEmpty()) continue;

            Silla silla = funcion.buscarSilla(idLimpio);
            if (silla == null) {
                resultado.agregarMensaje("ADVERTENCIA: la silla " + idLimpio + " no existe en esta sala.");
                continue;
            }
            if (silla.isOcupada()) {
                resultado.agregarMensaje("ADVERTENCIA: la silla " + idLimpio + " ya se encuentra ocupada.");
                continue;
            }

            silla.ocupar();
            double precio = sala.precioSilla(silla);
            resultado.totalPagar += precio;
            resultado.sillasCompradas++;
            if (silla.isPreferencial()) preferenciales++; else generales++;
        }

        if (generales > 0) {
            String tipoEtiqueta = sala.isSolo3D() ? "Boleta(s) 3D" : "Boleta(s) en General";
            resultado.agregarMensaje(generales + " " + tipoEtiqueta);
        }
        if (preferenciales > 0) {
            resultado.agregarMensaje(preferenciales + " Boleta(s) en Preferencial");
        }
        return resultado;
    }
}