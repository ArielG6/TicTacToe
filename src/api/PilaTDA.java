package api;

public interface PilaTDA {
	void InicializarPila();		//Sin condiciones
	void Apilar(int x);			//Pila iniciada
	void Desapilar();			//Pila inicializada y no vac�a
	int Tope();					//Pila inicializada y no vac�a
	boolean PilaVacia();		//Pila inicializada
}
