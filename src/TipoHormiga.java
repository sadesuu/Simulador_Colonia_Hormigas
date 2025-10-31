/**
 * Enumeración que define los diferentes tipos de hormigas en la colonia.
 * Cada tipo tiene un símbolo único para su representación visual en el mapa
 * y un nombre descriptivo.
 */
public enum TipoHormiga {

    OBRERA("O", "Obrera"),

    GUERRERA("G", "Guerrera"),

    REINA("R", "Reina");

    private final String simbolo;
    private final String nombre;

    /**
     * Constructor del enum que inicializa el símbolo y nombre del tipo de hormiga.
     *
     * @param simbolo Carácter que representa la hormiga en el mapa
     * @param nombre Nombre del tipo de hormiga
     * Complejidad: O(1)
     */
    TipoHormiga(String simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    /**
     * Obtiene el símbolo visual de la hormiga.
     *
     * @return Símbolo de un carácter que representa el tipo de hormiga
     * Complejidad: O(1)
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Obtiene el simbolo del tipo de hormiga.
     *
     * @return Nombre del tipo de hormiga
     * Complejidad: O(1)
     */
    public String getNombre() {
        return nombre;
    }
}
