/**
 * Clase que representa una posición en el mapa bidimensional.
 * Utiliza coordenadas cartesianas (x, y) para ubicar elementos en el espacio.
 * Esta clase es inmutable, lo que garantiza la seguridad en entornos multihilo.
 */
public class Posicion {
    private final int x;
    private final int y;

    /**
     * Constructor que inicializa una posición con coordenadas específicas.
     *
     * @param x Coordenada horizontal (columna)
     * @param y Coordenada vertical (fila)
     * Complejidad: O(1)
     */
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene la coordenada X (horizontal) de la posición.
     *
     * @return Valor de la coordenada X
     * Complejidad: O(1)
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene la coordenada Y (vertical) de la posición.
     *
     * @return Valor de la coordenada Y
     * Complejidad: O(1)
     */
    public int getY() {
        return y;
    }

    /**
     * Verifica si la posición está dentro de los límites especificados.
     * Los límites son inclusivos en el origen (0,0) y exclusivos en los máximos.
     *
     * @param maxX Límite máximo en el eje X (ancho)
     * @param maxY Límite máximo en el eje Y (alto)
     * @return true si la posición está dentro de los límites, false en caso contrario
     * Complejidad: O(1)
     */
    public boolean dentroLimites(int maxX, int maxY) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

    /**
     * Crea una nueva posición aplicando un desplazamiento a la posición actual.
     * No modifica la posición original (inmutabilidad).
     *
     * @param deltaX Desplazamiento en el eje X (puede ser negativo)
     * @param deltaY Desplazamiento en el eje Y (puede ser negativo)
     * @return Nueva instancia de Posicion con las coordenadas desplazadas
     * Complejidad: O(1)
     */
    public Posicion mover(int deltaX, int deltaY) {
        return new Posicion(x + deltaX, y + deltaY);
    }
}
