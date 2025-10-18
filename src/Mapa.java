import java.util.HashMap;

/**
 * Clase que representa el mapa bidimensional donde se desarrolla la simulación.
 * Gestiona la matriz que representa el espacio de la colonia, el hormiguero
 * y la posición de todas las hormigas.
 */
public class Mapa{
    // Ancho del mapa en caracteres/celdas
    public static final int ANCHO = 50;

    // Alto del mapa en caracteres/celdas
    public static final int ALTO = 20;

    private final Posicion hormiguero;
    private final char[][] mapa;

    // Carácter que representa una celda vacía
    public static final char VACIO = '.';

    // Carácter que representa el hormiguero
    public static final char HORMIGUERO = 'H';

    /**
     * Constructor que inicializa el mapa con el hormiguero en el centro.
     * Crea la matriz bidimensional y la llena con espacios vacíos.
     * Complejidad: O(n²)
     */
    public Mapa() {
        this.mapa = new char[ALTO][ANCHO];
        this.hormiguero = new Posicion(ANCHO / 2, ALTO / 2);

        // Llenar el mapa con espacios vacíos
        for (int i = 0; i < ALTO; i++) {
            for (int j = 0; j < ANCHO; j++) {
                mapa[i][j] = VACIO;
            }
        }

        // Colocar el hormiguero en el centro
        mapa[hormiguero.getY()][hormiguero.getX()] = HORMIGUERO;
    }

    /**
     * Obtiene la posición del hormiguero en el mapa.
     *
     * @return Posición del hormiguero
     * Complejidad: O(1)
     */
    public Posicion getHormiguero(){
        return hormiguero;
    }

    /**
     * Verifica si una posición está dentro de los límites del mapa.
     *
     * @param posicion Posición a verificar
     * @return true si la posición es válida, false en caso contrario
     * Complejidad: O(1)
     */
    public boolean dentroLimites(Posicion posicion){
        return posicion.dentroLimites(ANCHO, ALTO);
    }

    /**
     * Muestra el mapa en la consola con bordes decorativos.
     * Método sincronizado para evitar problemas de concurrencia en la visualización.
     * Complejidad: O(n²)
     */
    public synchronized void mostrarMapa() {
        System.out.println("═".repeat(ANCHO + 2));
        for (int i = 0; i < ALTO; i++) {
            System.out.print("║");
            for (int j = 0; j < ANCHO; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println("║");
        }
        System.out.println("═".repeat(ANCHO + 2));
    }

    /**
     * Prepara el mapa para una nueva visualización.
     * Limpia el mapa, coloca el hormiguero y actualiza las posiciones de todas las hormigas.
     *
     * @param hormigas HashMap con todas las hormigas de la simulación
     * Complejidad: O(n²)
     */
    public void prepararMapa(HashMap<String, Hormiga> hormigas) {
        // Reiniciar el mapa
        for (int i = 0; i < ALTO; i++) {
            for (int j = 0; j < ANCHO; j++) {
                mapa[i][j] = VACIO;
            }
        }
        // Colocar el hormiguero
        mapa[hormiguero.getY()][hormiguero.getX()] = HORMIGUERO;
        // Colocar las hormigas
        for (Hormiga hormiga : hormigas.values()) {
            Posicion posicion = hormiga.getPosicion();
            if (dentroLimites(posicion) &&
                    !(posicion.getX() == hormiguero.getX() && posicion.getY() == hormiguero.getY())) {
                mapa[posicion.getY()][posicion.getX()] = hormiga.getTipo().getSimbolo().charAt(0);
            }
        }
    }
}