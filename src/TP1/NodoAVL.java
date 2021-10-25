package TP1;

public class NodoAVL {
	private Comparable elem;
	private int altura=-1;
	private NodoAVL hijoIzq;
	private NodoAVL hijoDer;
	
	public NodoAVL(Comparable elem) {

		this.elem=elem;
		this.hijoIzq=null;
		this.hijoDer=null;
		this.altura=0;
	}
	
	public NodoAVL(Comparable unDato, NodoAVL unHijoIzq, NodoAVL unHijoDer) {

		this.elem=elem;
		this.hijoIzq=unHijoIzq;
		this.hijoDer=unHijoDer;
		this.auxRecalcularAltura();
	}

	
	public Comparable getElem() {
		return this.elem;
	}
	
	public NodoAVL getHijoIzq() {
		return this.hijoIzq;
	}
	
	public NodoAVL getHijoDer() {
		return this.hijoDer;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public void setElem(Comparable unDato) {
		this.elem=unDato;
	}
	
	public void setHijoIzq(NodoAVL unHijoIzq) {
		this.hijoIzq=unHijoIzq;
	}
	
	public void setHijoDer(NodoAVL unHijoDer) {
		this.hijoDer=unHijoDer;
	}
	public void setAltura(int unaAltura) {
		this.altura=unaAltura;
	}
	public void recalcularAltura() {
		this.auxRecalcularAltura();
	}
	
	private void auxRecalcularAltura() {
			int altI=-1;
			int altD=-1;
			if(this.getHijoIzq()!=null) {
				altI=this.getHijoIzq().getAltura();
			}
			if(this.getHijoDer()!=null) {
				altD=this.getHijoDer().getAltura();
			}
			if(altI>altD) {
				this.altura=altI+1;
			}else {
				this.altura=altD+1;
			}
	}
	
	
	
	
}
