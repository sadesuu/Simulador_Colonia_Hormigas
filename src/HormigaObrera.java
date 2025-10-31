import java.util.Random;

/**
 * Clase que representa una hormiga obrera en la simulación.
 * Las hormigas obreras son las trabajadoras de la colonia, encargadas de
 * recolectar recursos y mantener el hormiguero.
 * Cada hormiga obrera se ejecuta en su propio hilo de manera concurrente.
 */
public class HormigaObrera extends Hormiga {

    /**
     * Constructor que crea una nueva hormiga obrera.
     *
     * @param id              Identificador único de la hormiga obrera
     * @param posicionInicial Posición inicial en el mapa donde aparecerá la hormiga
     *                        Complejidad: O(1)
     */
    public HormigaObrera(String id, Posicion posicionInicial) {
        super(id, TipoHormiga.OBRERA, posicionInicial);
    }


}
