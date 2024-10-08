package imp;

import api.ABBTDA;

public class ABB implements ABBTDA {

	public class NodoABB {
		int info;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	}
	
	NodoABB raiz;
	
	public void InicializarABB() {
		raiz = null;
	}

	public int Raiz() {
		return raiz.info;
	}

	public ABBTDA HijoIzq() {
		return raiz.hijoIzq;
	}

	public ABBTDA HijoDer() {
		return raiz.hijoDer;
	}

	public void AgregarElem(int x) {
		if (raiz==null) {
			raiz = new NodoABB();			
			raiz.info = x;
			raiz.hijoIzq = new ABB();
			raiz.hijoIzq.InicializarABB();
			raiz.hijoDer = new ABB();
			raiz.hijoDer.InicializarABB();
		}
		else if (raiz.info > x) {
			raiz.hijoIzq.AgregarElem(x);
		}
		else if (raiz.info < x) {
			raiz.hijoDer.AgregarElem(x);
		}
	}

	public void EliminarElem(int x) {
		if(raiz != null) {
			if (raiz.info == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {
				raiz = null;
			}
			else if (raiz.info == x && !raiz.hijoIzq.ArbolVacio()) {
				raiz.info = this.mayor(raiz.hijoIzq);	
				raiz.hijoIzq.EliminarElem(raiz.info);
			}
			else if (raiz.info == x && !raiz.hijoDer.ArbolVacio()) {
				raiz.info = this.menor(raiz.hijoDer);
				raiz.hijoDer.EliminarElem(raiz.info);
			}
			else if (raiz.info > x) {
				raiz.hijoIzq.EliminarElem(x);
			}
			else {
				raiz.hijoDer.EliminarElem(x);
			}
		}
	}
	
	private int mayor (ABBTDA a) {
		if(a.HijoDer().ArbolVacio())
			return a.Raiz();
		else {
			return mayor(a.HijoDer());
		}
	}
	
	private int menor (ABBTDA a) {
		if(a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else {
			return menor(a.HijoIzq());
		}
	}
	
	public boolean ArbolVacio() {
		return raiz==null;
	}

}
