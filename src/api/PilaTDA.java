package api;

public interface PilaTDA {
	void InicializarPila();		//Sin condiciones
	void Apilar(int x);			//Pila iniciada
	void Desapilar();			//Pila inicializada y no vacía
	int Tope();					//Pila inicializada y no vacía
	boolean PilaVacia();		//Pila inicializada
}
