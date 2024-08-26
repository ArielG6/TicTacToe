package api;

public interface ColaPrioridadTDA {
	void InicializarCola();		//Sin condiciones
	void AcolarPrioridad(int x, int prioridad);			//Cola iniciada
	void Desacolar();			//Cola inicializada y no vac�a
	int Primero();				//Cola inicializada y no vac�a
	int Prioridad();			//Cola inicializada y no vac�a
	boolean ColaVacia();		//Cola inicializada
}
