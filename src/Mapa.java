import java.util.HashMap;

public class Mapa {

    public static final int ancho = 7;
    public static final int alto = 7;
    public static final int posicionHormiguero = ancho / 2;
    private final char[][] mapa;
    public static final char vacio = '.';
    public static final char hormiguero = 'H';

    public Mapa(){
        mapa = new char[ancho][alto];
        for (int i = 0;i < ancho; i++){
            for (int j = 0;j < alto;j++){
                mapa[i][j] = vacio;
            }
        }
        mapa[posicionHormiguero][posicionHormiguero] = hormiguero;
    }

    public void mostrarMapa(){
        for(int i = 0;i < ancho;i++){
            for(int j = 0;j < alto;j++){
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Posicion getHormiguero(){
        return new Posicion(posicionHormiguero,posicionHormiguero);
    }

}
