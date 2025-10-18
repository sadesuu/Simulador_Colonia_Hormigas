import java.util.Scanner;

/**
 * Clase principal que inicia la aplicación del simulador de colonia de hormigas.
 * Proporciona un menú interactivo para el usuario y gestiona el flujo del programa.
 *
 * @author Hugo Solís Torrijos
 */
public class Main {
    /**
     * Método principal que ejecuta el programa.
     * Muestra un menú de opciones al usuario y ejecuta la simulación según la elección.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     * Complejidad temporal: O(n²)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simulación de Hormigas - Versión Básica");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Iniciar simulación");
        System.out.println("2. Salir");

        int opcion = scanner.nextInt();
        if (opcion == 1) {
            System.out.println("Iniciando simulación...");
            SimuladorColoniaHormigas simulador = new SimuladorColoniaHormigas();
            simulador.ejecutar();
        } else {
            System.out.println("Saliendo del programa.");
        }

        scanner.close();
    }
}
