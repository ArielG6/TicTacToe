package imp;

import api.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	public class Elemento{
		int valor;
		int prioridad;
	}
	Elemento[] elementos;
	int indice;

	public void InicializarCola() {
		elementos = new Elemento[100];
		indice = 0;

	}

	public void AcolarPrioridad(int x, int prioridad) {
		int i = indice;
		for(;i>0 && elementos[i-1].prioridad >= prioridad;i--) {
				elementos[i]= elementos[i-1];
		}
		elementos[i] = new Elemento();
		elementos[i].valor = x;
		elementos[i].prioridad = prioridad;
		indice++;
	}

	public void Desacolar() {
		elementos[indice-1]=null;
		indice--;

	}

	public int Primero() {
		return elementos[indice-1].valor;
	}

	public int Prioridad() {
		return elementos[indice-1].prioridad;
	}

	public boolean ColaVacia() {
		return (indice==0);
	}

}
