package api;

public interface ABBTDA {	
	void InicializarABB();		//Sin Precondiciones
	int Raiz();					//ABB inicializado y no vac�o
	ABBTDA HijoIzq();			//ABB inicializado y no vac�o
	ABBTDA HijoDer();			//ABB inicializado y no vac�o
	void AgregarElem(int x);	//ABB inicializado
	void EliminarElem(int x);	//ABB inicializado
	boolean ArbolVacio();			//ABB inicializado
}
