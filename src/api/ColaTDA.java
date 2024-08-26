package api;

public interface ColaTDA {
	void InicializarCola();		//Sin condiciones
	void Acolar(int x);			//Cola iniciada
	void Desacolar();			//Cola inicializada y no vacía
	int Primero();				//Cola inicializada y no vacía
	boolean ColaVacia();		//Cola inicializada
}
