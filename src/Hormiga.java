import java.util.Random;

public abstract class Hormiga extends Thread {
    protected final String id;
    protected final TipoHormiga tipo;
    protected volatile Posicion posicion;
    protected volatile boolean activa;
    protected final Random random;
    protected static final int[][] direcciones = new int[0][];

    public Hormiga(String id, TipoHormiga tipo, Posicion posicionInicial) {
        this.id = id;
        this.tipo = tipo;
        this.posicion = posicionInicial;
        this.activa = true;
        this.random = new Random();
    }

    public String getIdentificador() {
        return id;
    }

    public TipoHormiga getTipo() {
        return tipo;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicionInicial) {
        this.posicion = posicionInicial;
    }

    public boolean isActiva() {
        return activa;
    }

    public void detener() {
        this.activa = false;
    }
}
