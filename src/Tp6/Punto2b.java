package Tp6;

public class Punto2b {
	public static Lista listFibo=new Lista();
	public static int sum=0;
	public static void main(String[] args) {
		int n=10;
		for (int i = 0; i < n; i++) {
			System.out.println(sumarParesFibo(i));
		}
		sumarParesFibo(n);
		System.out.println("SUMA: "+sum);
	}
	
	
	public static int sumarParesFibo(int n) {
		int aux;
		if(n == 0 || n == 1 ){ //t(0) y t(1) = 1+1+1+1 = 4
	        aux= 1;
		}else {//t(n>1) = t(n-1) + t(n-2) +1 +18+ 7 + 2 = t(n-1) + t(n-2) + 28
	    	aux=sumarParesFibo(n-1)+sumarParesFibo(n-2); // += t(n-1) + t(n-2)+1
	    	if(listFibo.localizar(aux)==-1 && aux%2==0) {// += 5+1+1+1+1 + (7+2) =18	//Op lista = 5
	    		listFibo.insertar(aux, listFibo.longitud()+1);//5+1+1= 7
	    		sum=sum+aux;//1+1=2
	    	}
		}
	    return aux;  
	}
	
	/*Encontramos la expresion matematica que ayuda a predecir los tiempos del algoritmo recursivos
	 * { 
	 * 	 t(0)=4;
	 * 	 t(1)=4;
	 * 	 t(n)= t(n-1) + t(n-2) + 28;
	 * }
	 * */
}
