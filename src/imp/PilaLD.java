package imp;

import api.PilaTDA;

public class PilaLD implements PilaTDA {
	
	public class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	
	public void InicializarPila() {
		primero = null;
	}
	public void Apilar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = primero;
		primero = aux;
	}
	public void Desapilar() {
		primero = primero.sig;
	}
	public int Tope() {
		return primero.info;
	}
	public boolean PilaVacia() {
		return (primero==null);
	}
}
