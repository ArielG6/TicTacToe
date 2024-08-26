package imp;

import api.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	int[] conjunto;
	int cant;
	
	public void InicializarConjunto() {
		conjunto = new int[100];
		cant = 0;
	}

	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			conjunto[cant] = x;
			cant++;
		}
	}

	public void Sacar(int x) {
		int i=0;
		while (i<cant && conjunto[i]!=x) {
			i++;
		}
		if (i<cant) {
			conjunto[i] = conjunto[cant-1];
			cant--;
		}
	}

	public int Elegir() {
		return conjunto[cant-1];
	}

	public boolean Pertenece(int x) {
		int i=0;
		while (i<cant && conjunto[i]!=x) {
			i++;
		}
		return i<cant;
	}

	public boolean ConjuntoVacio() {
		return cant==0;
	}

}
