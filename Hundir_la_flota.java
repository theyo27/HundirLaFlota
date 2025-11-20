import java.util.Scanner;
public class Hundir_la_flota{
  public static void tutorial(){         //introduce el tutorial siempre que el jugador lo pida
    
  }
  public static void iniciarFalso(boolean[][] tablero){
    for(int i=0;i<10;i++){
      for(int j=0;j<10;j++){
      tablero[i][j]=false;
     }
    }
  }
  public static void imprimirArray(boolean[][] tablero){    //para imprimir el array(provisional para testear)
    for(int i=0;i<10;i++){
      for(int j=0;j<10;j++){
      if(tablero[i][j]==false)
        System.out.print("0  ");
      else
        System.out.print("1  ");
      }
      System.out.println("");
    }
    System.out.println("");
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    boolean[][] tablero_j1=new boolean[10][10];             //el tablero del jugador 1 que ser� atacado por el j2 o la m�quina
    iniciarFalso(tablero_j1);
    System.out.println("¿Deseas jugar contra otra persona?(Y/N)");
    char modo=sc.next().toLowerCase().charAt(0);
    if(modo=='y'){         //inicia el programa de forma que jueguen dos personas
      boolean[][] tablero_j2=new boolean[10][10];
      iniciarFalso(tablero_j2);
      imprimirArray(tablero_j1);
      
      
    }
      
  }
}