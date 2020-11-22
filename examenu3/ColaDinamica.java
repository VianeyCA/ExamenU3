package examenu3;

public class ColaDinamica {
     NodoCola inicioComun, finComun;
     NodoCola inicioVIP, finVIP;
     NodoCola Arreglo[];

     public ColaDinamica() {
         this.inicioComun = null;
         this.finComun = null;
         this.inicioVIP = null;
         this.finVIP = null;
         this.Arreglo = new NodoCola[3];
     }

     public boolean Vacio() {
         return VIPVacio() && ComunVacio();
     }

     boolean VIPVacio() {
         return inicioVIP == null;
     }

     boolean ComunVacio() {
         return inicioComun == null;
     } 

     public void Cliente(String tipo, boolean VIP, int i) {
         if (VIP) {
             AgregarVIP(tipo, VIP, i);
         } else {
             AgregarComun(tipo, VIP, i);
         }
     }

     private void AgregarVIP(String tipo, boolean VIP, int i) {
         NodoCola nuevo = new NodoCola(tipo, VIP, i);
         if (VIPVacio()) {
             inicioVIP = nuevo;
         } else {
             finVIP.siguiente = nuevo;
         }
         finVIP = nuevo;
     }

     private void AgregarComun(String tipo, boolean VIP, int i) {
         NodoCola nuevo = new NodoCola(tipo, VIP, i);
         if (ComunVacio()) {
             inicioComun = nuevo;
         } else {
             finComun.siguiente = nuevo;
         }
         finComun = nuevo;
     }

     private NodoCola QuitarVIP() {
         NodoCola aux = inicioVIP;
         inicioVIP = inicioVIP.siguiente;
         return aux;
     }

     private NodoCola QuitarComun() {
         NodoCola aux = inicioComun;
         inicioComun = inicioComun.siguiente;
         return aux;
     }

     public void Pasa() {
         int i = 0;
         for (; i < Arreglo.length; i++) {
             if (!VIPVacio()) {
                 Arreglo[i] = QuitarVIP();
                 System.out.println("Ventanilla"+(i + 1)+" "+Arreglo[i].tipo+" "+Arreglo[i].i);
                 Arreglo[i] = null;
             } else {
                 break;
             }
         }
         if (i < Arreglo.length) {
             for (; i < Arreglo.length; i++) {
                 if (!ComunVacio()) {
                     Arreglo[i] = QuitarComun();
                     System.out.println("Ventanilla"+(i + 1)+" "+Arreglo[i].tipo+" "+Arreglo[i].i);
                     Arreglo[i] = null;
                 } else {
                     break;
                 }
             }
         }
     }

     public void Ventana(int i) {
         if (i >= 0 && i < Arreglo.length) {
             if (!VIPVacio()) {
                 Arreglo[i] = QuitarVIP();
                 System.out.println("Ventanilla"+(i + 1)+" "+Arreglo[i].tipo+" "+Arreglo[i].i);
                 Arreglo[i] = null;
             } else if (!ComunVacio()) {
                 Arreglo[i] = QuitarComun();
                 System.out.println("Ventanilla"+(i + 1)+" "+Arreglo[i].tipo+" "+Arreglo[i].i);
                 Arreglo[i] = null;
             }
         }
     }

     public void Mostrar() {
         NodoCola uno= inicioVIP, dos= inicioComun;
         System.out.print("Cliente VIP: ");
         while (uno != null) {
             System.out.print(uno.tipo+uno.i+" ");
             uno = uno.siguiente;
         }
         System.out.print("\nCliente Común: ");
         while (dos != null) {
             System.out.print(dos.tipo+dos.i+" ");
             dos = dos.siguiente;
         } 
    }
     
}
