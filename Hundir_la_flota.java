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
  public static int[][] inputBarcos(boolean[][] barcos){
    Scanner sc=new Scanner(System.in);
    int[][] barcosJ1=new int[5][4];
    String coordenada;
    boolean correcto=false;
    for(int i=0;i<barcosJ1.length;i++){
      correcto=false;
      if (i<2){
        do{
        System.out.println("Para crear su barco de "+(5-i)+ " casillas introduzca la coordenada inicial de este");
        coordenada=sc.next();
        barcosJ1[i][0]=((coordenada.charAt(0))-'a');
        barcosJ1[i][1]=((coordenada.charAt(1))-'0');
        System.out.println("Para crear su barco de "+(5-i)+ " casillas introduzca la coordenada final de este");
        coordenada=sc.next();
        barcosJ1[i][2]=((coordenada.charAt(0))-'a');
        barcosJ1[i][3]=((coordenada.charAt(1))-'0');
        correcto=validezInputCoordenadas(i,barcosJ1[i][0],barcosJ1[i][1],barcosJ1[i][2],barcosJ1[i][3],barcos);
        if(correcto==false){
          System.out.println("las coordenadas introducidas no son válidas, porfavor prueve otra vez");
        }
        else{
           barcosTablero(barcos, barcosJ1[i][0], barcosJ1[i][1], barcosJ1[i][2], barcosJ1[i][3]);
          imprimirArray(barcos);
        }
        }
        while(correcto==false);
      }
      else{
        do{
        System.out.println("introduzca la primera cordenada de un barco de 3 casillas ");
        coordenada=sc.next();
        barcosJ1[i][0]=((coordenada.charAt(0))-'a');
        barcosJ1[i][1]=((coordenada.charAt(1))-'0');
        System.out.println("introduzca la segunda cordenada de un barco de 3 casillas ");
        coordenada=sc.next();
        barcosJ1[i][2]=((coordenada.charAt(0))-'a');
        barcosJ1[i][3]=((coordenada.charAt(1))-'0');
        correcto=validezInputCoordenadas(i,barcosJ1[i][0],barcosJ1[i][1],barcosJ1[i][2],barcosJ1[i][3],barcos);
        if(correcto==false){
          System.out.println("las coordenadas introducidas no son válidas, porfavor prueve otra vez");
        }
        else{
          barcosTablero(barcos, barcosJ1[i][0], barcosJ1[i][1], barcosJ1[i][2], barcosJ1[i][3]);
          imprimirArray(barcos);
        }
        }
        while(correcto==false);
      }
    }
  return barcosJ1;
}
public static boolean validezInputCoordenadas(int i, int y1, int x1, int y2, int x2,boolean[][] barcos){
  boolean validez=false;
  if(i<2)     //ambas opciones del if comprueban si el barco está dentro del tablero y si es de las dimensiones indicadas
    validez=(((((((y1==y2)&&(((x1-x2)==(4-i))||((x2-x1)==(4-i))))||((x1==x2)&&(((y1-y2)==(4-i))||((y2-y1)==(4-i)))))&&(x1<10))&&(x2<10))&&(y1<10))&&(y2<10));
  else
    validez=(((((((y1==y2)&&(((x1-x2)==(2))||((x2-x1)==(2))))||((x1==x2)&&(((y1-y2)==(2))||((y2-y1)==(2)))))&&(x1<10))&&(x2<10))&&(y1<10))&&(y2<10));
  if(validez){              //comprueva si el nuevo barco se sobrepone con otro barco
    int y,x;
    x=numeroMenor(x1,x2);
    y=numeroMenor(y1,y2);
    if(x1==x2){
      for(int vary=y;((vary+y-y1-y2)<=0&&validez);vary++){
        if(barcos[vary][x])
          validez=false;
        }
    }
    else{
      for(int varx=x;(((varx+x-x1-x2)<=0)&&validez);varx++){
        if(barcos[y][varx])
          validez=false; 
      }
    }
  }
  return validez;
}
public static int numeroMenor(int i, int j){
  int k=0;
  if(i<j)
    k=i;
  else
    k=j;
  return k;
}
public static void barcosTablero(boolean[][] barcos, int y1, int x1, int y2, int x2){
 int y,x;
    x=numeroMenor(x1,x2);
    y=numeroMenor(y1,y2);
    if(x1==x2){
      for(int vary=y;(vary+y-y1-y2)<=0;vary++){
        barcos[vary][x]=true;
        }
    }
    else{
      for(int varx=x;((varx+x-x1-x2)<=0);varx++){
        barcos[y][varx]=true;
      }
    }
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
      int[][] barcos_j1=inputBarcos(tablero_j1);
      imprimirArray(tablero_j1);
      }
    else{


    }
           
    }
  }
