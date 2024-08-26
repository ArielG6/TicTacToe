package imp;

import api.ColaTDA;

public class Cola implements ColaTDA {
	int[] arreglo;
	int indice;
	int auxiliar;
	
	public void InicializarCola() {
		arreglo = new int[100];
		indice = 0;
	}

	public void Acolar(int x) {
		//arreglo[indice] = x;
		//indice++;
		for (int i = indice; i>0 ;i--) {
			arreglo[i] = arreglo[i-1];
		}
		arreglo[0] = x;
		indice++;
	}

	public void Desacolar() {
		//for (int i = 0; i<indice-1 ;i++) {
		//	arreglo[i] = arreglo[i+1];
		//}
		indice--;
		
	}

	public int Primero() {
		return arreglo[indice-1];
		//return arreglo[0];
	}

	public boolean ColaVacia() {
		return (indice == 0);
	}

}
