package imp;

import api.TatetiTDA;

public class Tateti implements TatetiTDA {
	int[][] matriz;
	
	public void Inicializar() {
		matriz = new int[3][3];
	}

	
	public void Turno(int x) {
		if(x == 0) {
			matriz[1][1]=1;
			imprimirTablero();
		}
		else {
			imprimirTablero();
		}
	}

	
	public int Jugar(int x, int y) {
		if(matriz[y][x] == 0) {
			matriz[y][x] = 10;
			int i = 0;
			int j = 0;
			int resultado = 0;
			int auxi = 0;
			int auxj = 0;
			int auxres = 0;
			boolean empateAnterior = false;
			boolean victoriaAnterior = false;
			boolean continuar = true;
			while(i<3 & continuar) {
				while(j<3 & continuar) {
					if (matriz[i][j]==0) {
						matriz[i][j]=1;
						resultado =  MinMax(matriz,10);
						if (resultado == 10) {
							matriz[i][j]=0;
						}
						else if(resultado == 1 && !victoria1(matriz) && !victoriaAnterior) {
							matriz[i][j] = 0;
							auxi = i;
							auxj = j;
							victoriaAnterior = true;
							auxres = 1;
						}
						else if(resultado == 5 && !empateAnterior && !victoriaAnterior) {
							matriz[i][j] = 0;
							auxi = i;
							auxj = j;
							empateAnterior = true;
						}
						else if(resultado == 1 && victoria1(matriz)) {
							empateAnterior = false;
							victoriaAnterior = false;
							continuar = false;
						}
						else
							matriz[i][j] = 0;
					}
					j++;
				}
				j = 0;
				i++;
			}
			if(empateAnterior || victoriaAnterior) {
				matriz[auxi][auxj] = 1;
			}
			imprimirTablero();
			if(auxres == 1)
				return 1;
			if(victoria1(matriz))
				return 1;
			else if(victoria10(matriz))
				return 10;
			int suma = 0;
			for (int ii = 0;ii<3;ii++) {
				for (int jj = 0;jj<3;jj++) {
					suma += matriz[ii][jj];
				}
			}
			if((suma==54||suma==45)) {
				return 0;
			}
			return 5;
		}
		else {
			System.out.println("Ingrese una casilla valida");
			return 5;
		}
	}
	
	
	private void imprimirTablero() {
		
		for(int i = 0; i<3; i++) {
			System.out.println("-------------");
			System.out.print("|");
			for(int j = 0; j<3; j++) {
				if(matriz[i][j] == 1)
					System.out.print(" X |");
				else if(matriz[i][j] == 10)
					System.out.print(" O |");
				else {
					System.out.print(" - |");
				}
				if(j == 2)
					System.out.println();
			}
		}
		System.out.println("-------------");
	}
	
	private boolean victoria1(int [][] tablero) {
		if(tablero[0][0]+tablero[0][1]+tablero[0][2]==3||
				   tablero[1][0]+tablero[1][1]+tablero[1][2]==3||
				   tablero[2][0]+tablero[2][1]+tablero[2][2]==3||
				   tablero[0][0]+tablero[1][0]+tablero[2][0]==3||
				   tablero[0][1]+tablero[1][1]+tablero[2][1]==3||
				   tablero[0][2]+tablero[1][2]+tablero[2][2]==3||
				   tablero[0][0]+tablero[1][1]+tablero[2][2]==3||
				   tablero[0][2]+tablero[1][1]+tablero[2][0]==3)
			return true;
		return false;
	}
	
	private boolean victoria10(int [][] tablero) {
		if (tablero[0][0]+tablero[0][1]+tablero[0][2]==30||
				 tablero[1][0]+tablero[1][1]+tablero[1][2]==30||
				 tablero[2][0]+tablero[2][1]+tablero[2][2]==30||
				 tablero[0][0]+tablero[1][0]+tablero[2][0]==30||
				 tablero[0][1]+tablero[1][1]+tablero[2][1]==30||
				 tablero[0][2]+tablero[1][2]+tablero[2][2]==30||
				 tablero[0][0]+tablero[1][1]+tablero[2][2]==30||
				 tablero[0][2]+tablero[1][1]+tablero[2][0]==30)
			return true;
		return false;
	}
	
	private int MinMax(int[][] tablero, int turno) {
		//MinMax devuelve 1 si gana X, 10 si gana O y 5 si empata
		int valor;
		int valorHoja;
		//Verificacion si alguien gano (caso base 1)
		if(victoria1(tablero)) {
			return 1;
		}
		else if (victoria10(tablero)){
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
							valorHoja = MinMax(tablero,1);
							tablero[i][j]=0;
							if (valor<valorHoja) {
								valor=valorHoja;
							}
						}
						else {
							tablero[i][j]=1;
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
