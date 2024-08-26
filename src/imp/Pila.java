package imp;

import api.PilaTDA;

public class Pila implements PilaTDA {
	int[] arreglo;
	int indice;
	
	public void InicializarPila() {
		arreglo = new int[100];
		indice = 0;
	}
	public void Apilar(int x) {
		arreglo[indice] = x;
		indice++;
		/*for (int i=indice;i<0;i--) {
			arreglo[i]=arreglo[i-1];
		}
		arreglo[0]=x;
		indice++;*/
	}
	public void Desapilar() {
		indice--;
		/*for (int i=0;i<indice;i++) {
			arreglo[i]=arreglo[i+1];
		}
		indice--;*/
	}
	public int Tope() {
		return arreglo[indice-1];
		/*return arreglo[0];*/
	}
	public boolean PilaVacia() {
		return (indice==0);
	}
}
