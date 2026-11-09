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
        if(j != null && indice < MAX-1){
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




    //no se usa pq los datos se ingresan de uno en uno
    /*public void setJuegos(Juego juegos[]) {
        this.juegos = juegos;
    }*/
}