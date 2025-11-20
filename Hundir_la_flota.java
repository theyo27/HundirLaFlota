import java.time.Year;
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
    System.out.println("    0  1  2  3  4  5  6  7  8  9");
    System.out.println("  -------------------------------");
    for(int i=0;i<10;i++){
      System.out.print((char )('a'+i)+"|  ");
      for(int j=0;j<10;j++){
      if(tablero[i][j]==false)
        System.out.print("o  ");
      else
        System.out.print("1  ");
      }
      System.out.println("");
    }
    System.out.println("");
  }
  public static int[][] barcos_j1(){
    Scanner sc=new Scanner(System.in);
    int[][] barcosJ1=new int[5][4];
    for(int i=5;i>0;i--){
      if (i>3){
    System.out.println("Para crear su primer barco de "+i+ " casillas introduzca la coordenada inicial de este");
    barcosJ1[i][1]=((sc.next().charAt(0))-'a');
    System.out.println("Ahora introduzca la coordenada final de su barco");
    barcosJ1[i][1]=((sc.next().charAt(1))-'0');
    
    }
    else{
    System.out.println("introduzca la primera cordenada de un barco de 3 casillas ");
      barcosJ1[i][1]=((sc.next().charAt(0))-'a');
      barcosJ1[i][2]=((sc.next().charAt(1))-'0');
      System.out.println("introduzca la segunda cordenada de un barco de 3 casillas ");
      barcosJ1[i][3]=((sc.next().charAt(0))-'a');
      barcosJ1[i][4]=((sc.next().charAt(1))-'0');
    }
  }
  return barcosJ1;
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
