package modelo;

public class AppStore {
    private static final int MAX=4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego[MAX];
        indice = -1;
    }

    public Juego[] getJuegos() {
        return juegos;
    }

    public boolean agregarJuego(Juego j){
        //No se agregan juegos nulos, con datos invalidos, repetidos o sin espacio
        if(j != null && j.getNombre() != null && j.getCategoria() != null && j.getTamanio() > 0
                && j.getPrecio() > 0 && buscarJuego(j.getNombre()) == null && indice < MAX-1){
            juegos[++indice]= j;
            return true;
        }
        return false;
    }

    public Juego buscarJuego(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            for(int i =0; i <= indice; i++){
                if(juegos[i].getNombre().equalsIgnoreCase(nombre)){
                    return juegos[i];
                }
            }
            return null;
        }
        return null;

    }

    public boolean comprar(String nombre, int cantidad){
        Juego j = buscarJuego(nombre);
        if(j != null){
            return j.comprar(cantidad);
        }
        return false;
    }

    public double vender(String nombre, int cantidad){
        Juego j = buscarJuego(nombre);
        if(j != null){
            if(j.vender(cantidad)){
                return j.getPrecio()*cantidad;
            }
            return 0;
        }
        return 0;

    }

    public String juegoMasVendido() {
        String nombre = "";
        int mayor;
        if (indice >= 0) {
            nombre = juegos[0].getNombre();
            mayor = juegos[0].getLicenciasVendidas();
            for (Juego j : juegos) {
                if (j != null) {
                    if (j.getLicenciasVendidas() > mayor) {
                        mayor = j.getLicenciasVendidas();
                        nombre = j.getNombre();
                    }
                } else {
                    return nombre;
                }
            }
        }
        return nombre;
    }

    public void inicializarDatos(){
        Juego j1 = new Juego("FIFA2026", "Deportes", 10, 70, 50);
        Juego j2 = new Juego("Roblox", "Accion", 2, 1, 200);
        agregarJuego(j1);
        agregarJuego(j2);
    }

    //no se usa pq los datos se ingresan de uno en uno
    /*public void setJuegos(Juego juegos[]) {
        this.juegos = juegos;
    }*/
}
