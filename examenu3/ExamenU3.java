package examenu3;

import java.util.Scanner;

public class ExamenU3 {

     public static void main(String[] args) {
         
         Scanner leer = new Scanner(System.in);
         ColaDinamica envioNodo = new ColaDinamica();
         int opc;
         int i = 0;
         int j=0;
         do {
             System.out.println("~~~~~~~~~~~~~~Menú~~~~~~~~~~~~~~");
             System.out.println("");
             System.out.println("1.- Nuevo Cliente");
             System.out.println("2.- Pasar a Ventanilla");
             System.out.println("3.- Mostrar Colas");
             System.out.println("4.- Terminar Ventanilla");
             System.out.println("5.- Salir");
             System.out.print("Seleccione una opción: ");
             opc = leer.nextInt();
             switch (opc) {
                 case 1:
                     boolean VIP = VIP();
                         if(i<=0){
                         i=(int)(Math.random()*10+1);
                         }else{
                             i++;
                         }
                         if (VIP) {
                         System.out.println("Cliente VIP:"+i+ "VIP"+i);
                         envioNodo.Cliente("VIP", VIP, i);
                         } else{                         
                         System.out.println("Cliente Común:"+i+ "Común"+i);
                         envioNodo.Cliente("Comun", VIP, i);
                     }                         
                     System.out.println("");
                     break;
                     
                 case 2:
                     if (!envioNodo.Vacio()) {
                         envioNodo.Pasa();
                     } else {
                         System.out.println("No existe ningún cliente en las colas");
                     }
                     System.out.println("");
                     break;
                 case 3:
                     envioNodo.Mostrar();
                     System.out.println("");
                     break;
                 case 4:
                     if (!envioNodo.Vacio()) {
                         int n = (int) (Math.random() * 3);
                         envioNodo.Ventana(n);
                     } else {
                         System.out.println("Las colas estan vacias");
                     }
                     System.out.println("");
                      break;
                 case 5:
                     System.out.println("Finalizado");
                     break;
                default:
                     System.out.println("Opción no valida, intente de nuevo");
            } 
         } while (opc != 5);
     }

     public static boolean VIP() {
         int num;
             num= (int) (Math.random() * 2);         
         return num == 0;
      }
}
