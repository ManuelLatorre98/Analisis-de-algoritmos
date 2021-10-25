package TP1;

public class ArbolAVL {
	private NodoAVL raiz=null;
	
	public ArbolAVL() {
	}
	
	private int obtenerAltura(NodoAVL nodo) {//Hago esto porque si el nodo es nulo larga excepcion con getAltura y necesito que devuelva -1 en ese caso
		int altura;
		if(nodo==null) {
			altura=-1;
		}else {
			altura=nodo.getAltura();
		}
		return altura;
	}
	
	private NodoAVL rotacionSimpleDer(NodoAVL nodo) {//Nodo es el pivote
		//System.out.println("Rotacion der");
		NodoAVL aux=nodo.getHijoIzq();
		nodo.setHijoIzq(aux.getHijoDer());
		aux.setHijoDer(nodo);
		nodo.recalcularAltura();
		aux.recalcularAltura();
		
		if(this.raiz.equals(nodo)) {
			this.raiz=aux;
		}
		return aux;
	}
	
	private NodoAVL rotacionSimpleIzq(NodoAVL nodo) {//Nodo es el pivote
		//System.out.println("rotacion izq");
		NodoAVL aux=nodo.getHijoDer();
		nodo.setHijoDer(aux.getHijoIzq());
		aux.setHijoIzq(nodo);
		nodo.recalcularAltura();
		aux.recalcularAltura();
		if(this.raiz.equals(nodo)) {
			this.raiz=aux;
		}
		return aux;
	}
	
	private NodoAVL rotacionDobleIzquierdaDerecha(NodoAVL flagNodo) {
		NodoAVL piv1=flagNodo.getHijoIzq();
		NodoAVL piv2=flagNodo;
		NodoAVL aux;
		flagNodo.setHijoIzq(this.rotacionSimpleIzq(piv1));
		aux=this.rotacionSimpleDer(piv2);
		if(this.raiz.equals(flagNodo)) {
			this.raiz=aux;
		}
		return aux;
		
	}
	
	private NodoAVL rotacionDobleDerechaIzquierda(NodoAVL flagNodo) {
		NodoAVL piv1=flagNodo.getHijoDer();
		NodoAVL piv2=flagNodo;
		NodoAVL aux;
		flagNodo.setHijoDer(this.rotacionSimpleDer(piv1));
		aux=this.rotacionSimpleIzq(piv2);
		if(this.raiz.equals(flagNodo)) {
			this.raiz=aux;
		}
		return aux;
	}
	
	public boolean insertar(Comparable elem) {
		NodoAVL nuevo=new NodoAVL(elem);
		boolean exito=true;
		NodoAVL nodo=this.buscarNodo(this.raiz, elem, null);
		if(nodo==null) {//Si no existe el nodo lo intento insertar
			if(this.raiz==null) {
				this.raiz=nuevo;
			}else {
				this.raiz=this.insertarAux(nuevo, this.raiz);

			}
		}else {
			exito=false;
		}
		return exito;
	}
	
	public NodoAVL insertarAux(NodoAVL nuevo,NodoAVL flagNodo) {
		NodoAVL nuevoPadre=flagNodo;
		if(nuevo.getElem().compareTo(flagNodo.getElem())<0) {//Si el nuevo es menor a donde estoy parado
			if(flagNodo.getHijoIzq()==null) {//si el hijo es nulo lo inserto ahi ya que es menor
				flagNodo.setHijoIzq(nuevo);
			}else {
				flagNodo.setHijoIzq(this.insertarAux(nuevo, flagNodo.getHijoIzq()));//Si no es nulo bajo al hijo menor
				nuevoPadre=this.balancear(flagNodo);
			}
		}else {
			if(nuevo.getElem().compareTo(flagNodo.getElem())>0){//Si el nuevo es mayor a donde estoy parado
				if(flagNodo.getHijoDer()==null) {//Si el hijo es nulo lo inserto ahi ya que es mayor
					flagNodo.setHijoDer(nuevo);
					
				}else {
					flagNodo.setHijoDer(this.insertarAux(nuevo,flagNodo.getHijoDer()));//Si no es nulo bajo al hijo mayor
					nuevoPadre=this.balancear(flagNodo);
				}
			}
		}
		flagNodo.recalcularAltura();//Recalculo la altura siempre
		
		return nuevoPadre;
	}
	
	private int calcularBalance(NodoAVL flagNodo) {
		int altIzq=this.obtenerAltura(flagNodo.getHijoIzq());
		int altDer=this.obtenerAltura(flagNodo.getHijoDer());
		int balance;
		balance=altIzq-altDer;
		return balance;
	}

	private NodoAVL buscarNodo(NodoAVL flagNodo, Comparable elem, NodoAVL nodo) {
		if(flagNodo!=null) {
			if(elem.compareTo(flagNodo.getElem())==0) {
				nodo=flagNodo;
			}else {
				if(flagNodo.getHijoIzq()!=null) {
					nodo=buscarNodo(flagNodo.getHijoIzq(),elem,nodo);
				}
				if(flagNodo.getHijoDer()!=null && nodo==null) {
					nodo=buscarNodo(flagNodo.getHijoDer(),elem,nodo);
				}
			}
		}
		return nodo;
	}
	
	private NodoAVL balancear(NodoAVL flagNodo) {
		NodoAVL nuevoPadre=flagNodo;
		if(this.calcularBalance(flagNodo)==2) {//Si esta caido a la izquierda
			if(this.calcularBalance(flagNodo.getHijoIzq())==0 || this.calcularBalance(flagNodo.getHijoIzq())==1 ) {
				nuevoPadre=this.rotacionSimpleDer(flagNodo);
			}else {
				nuevoPadre=this.rotacionDobleIzquierdaDerecha(flagNodo);
			}
		}else {
			if(this.calcularBalance(flagNodo)==-2) {//Si esta caido a la derecha
				if(this.calcularBalance(flagNodo.getHijoDer())==0 || this.calcularBalance(flagNodo.getHijoDer())==-1) {
					nuevoPadre=this.rotacionSimpleIzq(flagNodo);
				}else {
					nuevoPadre=this.rotacionDobleDerechaIzquierda(flagNodo);
				}
			}
		}
		return nuevoPadre;
	}

	public boolean eliminar(Comparable claveElim) {
		boolean exito=false;
		if(this.raiz!=null) {
			auxEliminar(this.raiz,null,claveElim);
			
		}
		return exito;
	}
	
	private NodoAVL auxEliminar(NodoAVL flagNodo, NodoAVL padre, Comparable claveElim ) {
		boolean exito=false;
		int balance;
		NodoAVL nuevoPadre=flagNodo;
		if(flagNodo!=null) {
			if(claveElim.compareTo(flagNodo.getElem())==0) {//Si el que elimino es la raiz
					this.eliminarEligeCaso(flagNodo, null);
			}else {
				if(flagNodo.getHijoIzq()!=null && claveElim.compareTo(flagNodo.getHijoIzq().getElem())==0) {//Si el que tengo que eliminar es el hi lo envio para eliminar
					this.eliminarEligeCaso(flagNodo.getHijoIzq(), flagNodo);
				}else {
					if(flagNodo.getHijoDer()!=null && claveElim.compareTo(flagNodo.getHijoDer().getElem())==0) {//Si es el derecho elimino ese hijo
						this.eliminarEligeCaso(flagNodo.getHijoDer(), flagNodo);
					}else {
						if(flagNodo.getHijoIzq()!=null && claveElim.compareTo(flagNodo.getElem())<0) {//Si el que tengo que eliminar esta a la izquierda de donde estoy parado
							flagNodo.setHijoIzq(this.auxEliminar(flagNodo.getHijoIzq(), flagNodo, claveElim));//a donde estaba parado le seteo el siguiente hijo, si llegara a haber una rotacion, el siguiente hijo sera el que retorne balancear
						}else {
							if(flagNodo.getHijoDer()!=null && claveElim.compareTo(flagNodo.getElem())>0) {
								flagNodo.setHijoDer(this.auxEliminar(flagNodo.getHijoDer(), flagNodo, claveElim));
							}
						}
					}	
				}
			}
			nuevoPadre=this.balancear(flagNodo);
		}
		return nuevoPadre;
	}
	
	private boolean eliminarEligeCaso(NodoAVL flagNodo, NodoAVL padre) {
		if(flagNodo.getHijoIzq()==null && flagNodo.getHijoDer()==null) {
			eliminarCaso1(flagNodo,padre);
		}else {
			if(flagNodo.getHijoIzq()!=null && flagNodo.getHijoDer()!=null) {
				eliminarCaso3(flagNodo);
			}else {
				eliminarCaso2(flagNodo,padre);
			}
		}
		
		return true;
	}
	
	private void eliminarCaso1(NodoAVL flagNodo, NodoAVL padre) {
		if(padre==null) {//El caso de la raiz
			this.raiz=null;
		}else {
			if(padre.getHijoIzq()!=null && flagNodo.getElem().compareTo(padre.getHijoIzq().getElem())==0) {//Si el izquierdo es el que tengo que eliminar
				padre.setHijoIzq(null);
			}else {//Si el derecho es el que tengo que eliminar
				padre.setHijoDer(null);
			}
			padre.recalcularAltura();//Re calculo la altura del padre del eliminado
			
		}
		
	}
	
	private void eliminarCaso2(NodoAVL flagNodo, NodoAVL padre) {
		if(padre==null) {//El caso de eliminar raiz
			if(flagNodo.getHijoIzq()!=null) {//Si el de la izquierda es el no nulo asigno ese a la raiz
				this.raiz=flagNodo.getHijoIzq();
			}else {
				this.raiz=flagNodo.getHijoDer();//Si es el de la derecha el no nulo asigno ese
			}
		}else {
			if(padre.getHijoIzq()!=null && flagNodo.getElem().compareTo(padre.getHijoIzq().getElem())==0) {//Si el izquierdo es el que tengo que eliminar
				if(flagNodo.getHijoIzq()!=null) {
					padre.setHijoIzq(flagNodo.getHijoIzq());
				}else {
					padre.setHijoIzq(flagNodo.getHijoDer());
				}
			}else {
				if(flagNodo.getHijoIzq()!=null) {
					padre.setHijoDer(flagNodo.getHijoIzq());
				}else {
					padre.setHijoDer(flagNodo.getHijoDer());
				}
			}
			padre.recalcularAltura();//Re calculo la altura del padre del eliminado
		}
	}

	private void eliminarCaso3(NodoAVL flagNodo) {
		NodoAVL candidato= flagNodo.getHijoIzq();
		NodoAVL padre=flagNodo;
		while(candidato.getHijoDer()!=null) {
			padre=candidato;
			candidato=candidato.getHijoDer();
		}
		flagNodo.setElem(candidato.getElem());
		if(candidato.getHijoDer()==null && candidato.getHijoIzq()==null) {
			eliminarCaso1(candidato,padre);
		}else {
			eliminarCaso2(candidato,padre);
		}
		flagNodo.setHijoIzq(this.balancear(padre));//Balanceo al padre que perdio al hijo candidat
	}
	
	

	
	public String toString() {
		String cadena="";
		if(this.raiz!=null) {
			cadena=auxToString(this.raiz,cadena);
		}
		return cadena;
	}
	
	private String auxToString(NodoAVL flagNodo, String cadena) {
		if(flagNodo!=null) {
			cadena+="Nodo: "+flagNodo.getElem()+"("+flagNodo.getAltura()+"), HI: ";
			if(flagNodo.getHijoIzq()!=null) {
				cadena+=flagNodo.getHijoIzq().getElem()+"("+flagNodo.getHijoIzq().getAltura()+")";
			}
			cadena+=", HD:";
			if(flagNodo.getHijoDer()!=null) {
				cadena+= flagNodo.getHijoDer().getElem()+"("+flagNodo.getHijoDer().getAltura()+")";
			}
			cadena+="\n";
			cadena=auxToString(flagNodo.getHijoIzq(),cadena);
			cadena=auxToString(flagNodo.getHijoDer(),cadena);
		}
		return cadena;
	}
}
