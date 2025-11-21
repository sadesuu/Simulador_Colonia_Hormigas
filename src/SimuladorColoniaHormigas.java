import java.util.HashMap;
import java.util.Random;

import static java.lang.IO.println;

/**
 * Clase principal que gestiona la simulación de la colonia de hormigas.
 * Coordina el movimiento de todas las hormigas, actualiza el mapa y
 * maneja la visualización en tiempo real de la simulación.
 */
public class SimuladorColoniaHormigas {
    // Número de hormigas en la simulación
    private static final int numHormigas = 6;

    // Tiempo entre actualizaciones del mapa en milisegundos
    private static final int duracionSimulacion = 2000;

    // Matriz de direcciones posibles: arriba, derecha, abajo, izquierda
    private static final int [][] DIRECCIONES =
            {{0,1},
            {1,0},
            {0,-1},
            {-1,0}};

    private Mapa mapa;
    private final HashMap<String, Hormiga> hormigas;
    private volatile boolean simulacionActiva;
    private final Random random;

    /**
     * Constructor que inicializa el simulador.
     * Crea el mapa, inicializa las estructuras de datos y prepara el generador aleatorio.
     * Complejidad: O(n²)
     */
    public SimuladorColoniaHormigas() {
        this.mapa = new Mapa();
        this.hormigas = new HashMap<>();
        this.simulacionActiva = false;
        this.random = new Random();
    }

    /**
     * Genera todas las hormigas obreras en posiciones aleatorias válidas.
     * Cada hormiga se inicia en su propio hilo de ejecución.
     * Complejidad: O(n)
     */
    public void generarHormigas(){
        for(int i = 0; i < numHormigas; i++){
            String id = "OBRERA" + (i + 1);
            //Generar posicion aleatoria valida
            Posicion posicion;
            do{
                int x = random.nextInt(Mapa.ANCHO);
                int y = random.nextInt(Mapa.ALTO);
                posicion = new Posicion(x, y);
            }while(posicion.getX() == mapa.getHormiguero().getX() && posicion.getY() == mapa.getHormiguero().getY());
            HormigaObrera obrera = new HormigaObrera(id, posicion);
            hormigas.put(id, obrera);
            obrera.start();
        }
    }

    /**
     * Ejecuta la simulación completa.
     * Genera las hormigas, espera a que se inicien y comienza el bucle de visualización.
     * Complejidad: O(n)
     */
    public void ejecutar(){
        simulacionActiva = true;
        generarHormigas();
        actualizarVisualizacion();
    }

    /**
     * Detiene la simulación y todos los hilos de las hormigas.
     * Complejidad: O(n)
     */
    public void detenerSimulacion(){

        simulacionActiva = false;
        for(Hormiga hormiga : hormigas.values()){
            hormiga.detener();
        }
    }

    /**
     * Mueve todas las hormigas activas a nuevas posiciones aleatorias.
     * Método sincronizado para evitar condiciones de carrera entre hilos.
     * Complejidad: O(n)
     */
    synchronized void moverTodasLasHormigas() {
        for (Hormiga hormiga : hormigas.values()) {
            if (hormiga.isActiva()) {
                moverHormigaAleatoriamente(hormiga);
            }
        }
    }

    /**
     * Mueve una hormiga específica en una dirección aleatoria válida.
     * Verifica que la nueva posición esté dentro de los límites y no sea el hormiguero.
     * Método sincronizado para garantizar movimientos atómicos.
     *
     * @param hormiga La hormiga a mover
     * Complejidad: O(1)
     */
    private synchronized void moverHormigaAleatoriamente(Hormiga hormiga) {
        int[] direccion = DIRECCIONES[random.nextInt(DIRECCIONES.length)];
        Posicion nuevaPosicion = hormiga.getPosicion().mover(direccion[0], direccion[1]);

        if (mapa.dentroLimites(nuevaPosicion)) {
            if (!(nuevaPosicion.getX() == mapa.getHormiguero().getX() &&
                    nuevaPosicion.getY() == mapa.getHormiguero().getY())) {
                hormiga.setPosicion(nuevaPosicion);
            }
        }
    }

    /**
     * Bucle principal de actualización de la visualización.
     * Limpia la consola, mueve hormigas, actualiza el mapa y muestra estadísticas.
     * Se ejecuta mientras la simulación esté activa.
     * Complejidad: O(n²)
     */
    private void actualizarVisualizacion(){
        while (simulacionActiva) {
            try {
                limpiarConsola();
                moverTodasLasHormigas();
                mapa.prepararMapa(hormigas);
                mapa.mostrarMapa();
                mostrarEstadisticas();
                Thread.sleep(duracionSimulacion);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    /**
     * Limpia la consola imprimiendo múltiples líneas en blanco.
     * Método simple para simular limpieza de pantalla.
     * Complejidad: O(1)
     */
    private void limpiarConsola(){
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
    }

    /**
     * Muestra las estadísticas actuales de la simulación.
     * Incluye número de hormigas activas, intervalo de actualización y posición del hormiguero.
     * Complejidad: O(1)
     */
    private void mostrarEstadisticas(){
        System.out.println("Estadísticas de la Colonia de Hormigas:");
        System.out.println("Hormigas activas: " + hormigas.size());
        System.out.println("Actualización cada: " + duracionSimulacion + " ms");
        System.out.println("Hormiguero en: (" + mapa.getHormiguero().getX() + ", " + mapa.getHormiguero().getY() + ")");
    }
}