package api;

public interface ABBTDA {	
	void InicializarABB();		//Sin Precondiciones
	int Raiz();					//ABB inicializado y no vacío
	ABBTDA HijoIzq();			//ABB inicializado y no vacío
	ABBTDA HijoDer();			//ABB inicializado y no vacío
	void AgregarElem(int x);	//ABB inicializado
	void EliminarElem(int x);	//ABB inicializado
	boolean ArbolVacio();			//ABB inicializado
}
