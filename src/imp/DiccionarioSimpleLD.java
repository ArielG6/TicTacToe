package imp;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimpleLD implements DiccionarioSimpleTDA {

	public class Nodo{
		int valor;
		int clave;
		Nodo sig;
	}
	
	Nodo origen;
	
	public void InicializarDiccionario() {
		origen = null;
	}

	public void Agregar(int clave, int valor) {
		Nodo nc = Clave2Nodo(clave);
		if(nc==null) {
			nc = new Nodo();
			nc.clave = clave;
			nc.sig = origen;
			origen = nc;
			
		}
		nc.valor = valor;
	}
	
	private Nodo Clave2Nodo(int clave) {
		Nodo aux = origen;
		while(aux!=null && aux.clave!=clave) {
			aux = aux.sig;
		}
		return aux;
	}
	public void Eliminar(int clave) {
		if (origen!=null) {
			if (origen.clave==clave) {
				origen = origen.sig;
			}
		}
		else {
			Nodo aux = origen;
			while(aux.sig!=null && aux.sig.clave!=clave) {
				aux = aux.sig;
			}
			if (aux.sig!=null) {
				aux.sig = aux.sig.sig;
			}
		}
	
	}

	public int Recuperar(int clave) {
		Nodo n = Clave2Nodo(clave);
		return n.valor;
	}

	public ConjuntoTDA Claves() {
		Nodo aux = origen;
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();
		while(aux!=null) {
			claves.Agregar(aux.clave);
			aux = aux.sig;
		}
		return claves;
	}

}
