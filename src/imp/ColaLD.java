package imp;

import api.ColaTDA;

public class ColaLD implements ColaTDA {
	
	public class Nodo{
		int info;
		Nodo sig;
	}
	 Nodo primero;
	 Nodo ultimo;
	public void InicializarCola() {
		primero = null;
		ultimo = null;
	}

	public void Acolar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = null;
		//Si la cola no est� vac�a
		if (ultimo!=null) {
			ultimo.sig = aux;
		}
		ultimo = aux;
		//Si la cola est� vac�a
		if (primero==null) {
			primero = ultimo;
		}
	}

	public void Desacolar() {
		primero = primero.sig;
		//Si la cola queda vac�a
		if (primero==null) {
			ultimo = primero;
		}
		
	}

	public int Primero() {
		return primero.info;
	}

	public boolean ColaVacia() {
		return (ultimo==null);
	}

}
