package imp;

import api.ConjuntoTDA;

public class ConjuntoLD implements ConjuntoTDA {

	public class Nodo {
		int info;
		Nodo sig;
	}
	
	Nodo conjunto;
	
	public void InicializarConjunto() {
		conjunto = null;
	}

	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			Nodo aux = new Nodo();
			aux.info = x;
			aux.sig = conjunto;
			conjunto = aux;
		}
	}

	public void Sacar(int x) {
		if(conjunto!=null) {
			if(conjunto.info==x) {
				conjunto=conjunto.sig;
			}
			else {
				Nodo aux = conjunto;
				while(aux!=null && aux.sig.info!=x) {
					aux=aux.sig;
				}
				if(aux.sig!=null) {
					aux.sig=aux.sig.sig;
				}
			}
		}
	}

	public int Elegir() {
		return conjunto.info;
	}

	public boolean Pertenece(int x) {
		Nodo aux = conjunto;
		while (aux!=null && aux.info!=x) {
			aux=aux.sig;
		}
		return aux!=null;
	}

	public boolean ConjuntoVacio() {
		return conjunto==null;
	}

}
