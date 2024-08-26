package api;

public interface ColaPrioridadTDA {
	void InicializarCola();		//Sin condiciones
	void AcolarPrioridad(int x, int prioridad);			//Cola iniciada
	void Desacolar();			//Cola inicializada y no vacía
	int Primero();				//Cola inicializada y no vacía
	int Prioridad();			//Cola inicializada y no vacía
	boolean ColaVacia();		//Cola inicializada
}
