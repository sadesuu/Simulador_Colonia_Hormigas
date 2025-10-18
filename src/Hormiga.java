import java.util.Random;

/**
 * Clase abstracta que representa una hormiga en la simulación.
 * Extiende Thread para permitir que cada hormiga se ejecute en su propio hilo.
 * Contiene la lógica común para todos los tipos de hormigas.
 */
public abstract class Hormiga extends Thread{
    private final String id;
    private final TipoHormiga tipo;
    protected Posicion posicion;
    protected volatile boolean activa;
    private final Random random;
    private static final int[][] DIRECCIONES =
            {{0,1},
            {1,0},
            {0,-1},
            {-1,0}};

    /**
     * Constructor que inicializa una hormiga con sus atributos básicos.
     *
     * @param id Identificador único de la hormiga
     * @param tipo Tipo de hormiga (OBRERA, GUERRERA, REINA)
     * @param posicionInicial Posición inicial de la hormiga en el mapa
     * Complejidad: O(1)
     */
    public Hormiga(String id, TipoHormiga tipo, Posicion posicionInicial) {
        this.id = id;
        this.tipo = tipo;
        this.posicion = posicionInicial;
        this.activa = true;
        this.random = new Random();
    }

    /**
     * Obtiene el identificador único de la hormiga.
     *
     * @return ID de la hormiga
     * Complejidad: O(1)
     */
    public String getIdHormiga(){
        return id;
    }

    /**
     * Obtiene el tipo de hormiga.
     *
     * @return Tipo de hormiga (enum TipoHormiga)
     * Complejidad: O(1)
     */
    public TipoHormiga getTipo(){
        return tipo;
    }

    /**
     * Obtiene la posición actual de la hormiga en el mapa.
     *
     * @return Posición actual de la hormiga
     * Complejidad: O(1)
     */
    public Posicion getPosicion() {
        return posicion;
    }

    /**
     * Establece una nueva posición para la hormiga.
     * Método sincronizado para garantizar seguridad en entornos multihilo.
     *
     * @param nuevaPosicion Nueva posición a asignar
     * Complejidad: O(1)
     */
    public void setPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    /**
     * Verifica si la hormiga está activa en la simulación.
     *
     * @return true si la hormiga está activa, false si ha sido detenida
     * Complejidad: O(1)
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Detiene la ejecución del hilo de la hormiga.
     * Establece el flag 'activa' a false para finalizar el bucle en run().
     * Complejidad: O(1)
     */
    public void detener() {
        this.activa = false;
    }
}