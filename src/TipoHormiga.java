public enum TipoHormiga {
    OBRERA("O", "Hormiga Obrera"),
    GUERRERA("G", "Hormiga Guerrera"),
    REINA("R", "Hormiga Reina");

    private final String simbolo;
    private final String nombre;

    TipoHormiga(String simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }
}
