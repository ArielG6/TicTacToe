package api;

public interface ColaTDA {
	void InicializarCola();		//Sin condiciones
	void Acolar(int x);			//Cola iniciada
	void Desacolar();			//Cola inicializada y no vac�a
	int Primero();				//Cola inicializada y no vac�a
	boolean ColaVacia();		//Cola inicializada
}
