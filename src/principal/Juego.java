package principal;

import java.util.Scanner;

import imp.Tateti;

public class Juego {

	public static void main(String[] args) {
		
		Tateti juego = new Tateti();
		juego.Inicializar();
		Scanner in = new Scanner(System.in);
		System.out.println("TA TE TI");
		System.out.println("Quien juega primero? (ordenador 0, Jugador 1)");
		juego.Turno(in.nextInt());
		int resultado = 5;
		int x;
		int y;
		System.out.print("Elegir posicion X: ");
		x = in.nextInt();
		while(x > 2 || x < 0) {
			System.out.print("Elija una posicion valida de X");
			x = in.nextInt();
		}
		System.out.print("Elegir posicion Y: ");
		y = in.nextInt();
		while(y > 2 || y < 0) {
			System.out.print("Elija una posicion valida de Y");
			y = in.nextInt();
		}
		resultado = juego.Jugar(x, y);
		//System.out.println(resultado);
		while(resultado==5) {
			System.out.print("Elegir posicion X: ");
			x = in.nextInt();
			while(x > 2 || x < 0) {
				System.out.print("Elija una posicion valida de X");
				x = in.nextInt();
			}
			System.out.print("Elegir posicion Y: ");
			y = in.nextInt();
			while(y > 2 || y < 0) {
				System.out.print("Elija una posicion valida de Y");
				y = in.nextInt();
			}
			resultado = juego.Jugar(x, y);
			//System.out.println(resultado);
		}
		if (resultado == 1) {
			System.out.println("Gana X");
		}
		else if (resultado == 10) {
			System.out.println("Gana O");
		}
		else if (resultado == 0){
			System.out.println("Empate");
		}
		in.close();;
		//Lineas para hacer pruebas de funcionamiento de MinMax
		/*int[][] matriz;
		matriz = new int[3][3];
		matriz[0][0]=1;
		matriz[0][1]=10;
		matriz[0][2]=0;
		matriz[1][0]=0;
		matriz[1][1]=10;
		matriz[1][2]=0;
		matriz[2][0]=0;
		matriz[2][1]=0;
		matriz[2][2]=0;
		System.out.println(MinMax(matriz,1));*/
	}
	
	public static int MinMax(int[][] tablero, int turno) {
		//MinMax devuelve 1 si gana X, 10 si gana O y 5 si empata
		//Impresion del tablero para pruebas
		for(int i = 0; i<3; i++)
			for(int j = 0; j<3; j++) {
				if(tablero[i][j] == 1)
					System.out.print(" X ");
				else if(tablero[i][j] == 10)
					System.out.print(" O ");
				else {
					System.out.print(" - ");
				}
				if(j == 2)
					System.out.println();
			}
		System.out.println();

		int valor;
		int valorHoja;
		//Verificacion si alguien gano (caso base 1)
		if(tablero[0][0]+tablero[0][1]+tablero[0][2]==3||
		   tablero[1][0]+tablero[1][1]+tablero[1][2]==3||
		   tablero[2][0]+tablero[2][1]+tablero[2][2]==3||
		   tablero[0][0]+tablero[1][0]+tablero[2][0]==3||
		   tablero[0][1]+tablero[1][1]+tablero[2][1]==3||
		   tablero[0][2]+tablero[1][2]+tablero[2][2]==3||
		   tablero[0][0]+tablero[1][1]+tablero[2][2]==3||
		   tablero[0][2]+tablero[1][1]+tablero[2][0]==3) {
			return 1;
		}
		else if (tablero[0][0]+tablero[0][1]+tablero[0][2]==30||
				 tablero[1][0]+tablero[1][1]+tablero[1][2]==30||
				 tablero[2][0]+tablero[2][1]+tablero[2][2]==30||
				 tablero[0][0]+tablero[1][0]+tablero[2][0]==30||
				 tablero[0][1]+tablero[1][1]+tablero[2][1]==30||
				 tablero[0][2]+tablero[1][2]+tablero[2][2]==30||
				 tablero[0][0]+tablero[1][1]+tablero[2][2]==30||
				 tablero[0][2]+tablero[1][1]+tablero[2][0]==30){
			return 10;
		}
		else {
			//Si nadie gana se evaluan las posibles jugadas
			if(turno == 10) {
				valor = 1;
			}
			else {
				valor = 10;
			}
			
			/*
			 * Se recorren los espacios vacios del tablero para evaluar todas las jugadas
			 * posibles remanentes 
			 */
		
			for (int i = 0;i<3;i++) {
				for (int j = 0;j<3;j++) {
					if (tablero[i][j]==0) {
						if (turno == 10) {
							tablero[i][j]=10;
							//valor = Max(valor,MinMax(tablero,1));
							valorHoja = MinMax(tablero,1);
							tablero[i][j]=0;
							if (valor<valorHoja) {
								valor=valorHoja;
							}
						}
						else {
							tablero[i][j]=1;
							//valor = Min(valor,MinMax(tablero,1));
							valorHoja = MinMax(tablero,10);
							tablero[i][j]=0;
							if (valor>valorHoja) {
								valor=valorHoja;
							}
						}
					}
				}
			}
			
		}
		//Verifica si el tablero esta lleno, si lo esta quiere decir 
		//que hubo empate (caso base 2)
		int suma = 0;
		for (int i = 0;i<3;i++) {
			for (int j = 0;j<3;j++) {
				suma += tablero[i][j];
			}
		}
		if(suma==54||suma==45) {
			valor = 5;
		}
		return valor;
	}
}
