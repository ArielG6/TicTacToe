package api;

public interface DiccionarioMultipleTDA {
	void InicializarDiccionario ();				//Sin condiciones
	void Agregar(int clave, int valor);			//Diccionario inicializado
	void Eliminar(int clave);					//Diccionario inicializado
	void EliminarValor(int clave, int valor);	//Diccionario inicializado
	ConjuntoTDA Recuperar(int clave);					//Diccionario inicializado y existe la clave
	ConjuntoTDA Claves();						//Diccionario inicializado
}
