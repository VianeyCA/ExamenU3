package examenu3;

public class NodoCola {
     String tipo;
     boolean VIP;
     int i;
     NodoCola siguiente;

     public NodoCola(String t, boolean v, int i) {
         this.tipo = t;
         this.VIP = v;
         this.i = i;
         this.siguiente = null;
    }
}
