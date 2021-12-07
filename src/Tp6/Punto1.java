package Tp6;

public class Punto1 {
	public static void main(String[] args) {
		int n=10;
		int media=0;
		System.out.print("Fibonacci iterativo de "+n+": ");
		tiempoIterativo(n);
		System.out.println("______________________________________");
		System.out.print("Fibonacci recursivo de "+n+": ");
		tiempoRecursivo(n);
	}
	
	public static int encontrarNumeroFibonacci_iterativo(int n) {
		int index_anterior = 0; //n-2
		int index_actual = 1; //n-1
		int sumador = 1;
		int iteraciones = 0;
		while (n > 0 && iteraciones < n) {
	        sumador = index_actual + index_anterior;
	        index_anterior = index_actual;
	        index_actual = sumador;
	        iteraciones++;
	    }
		return sumador;
	}
	
	public static int encontrarNumeroFibonacci_recursivo(int n) {
		int res;
		if(n == 0 || n == 1){
	        res= 1;
	    }else {
	    	res=encontrarNumeroFibonacci_recursivo(n-1) + encontrarNumeroFibonacci_recursivo(n-2);
	    }
	    return res;
	}
	
	public static void tiempoIterativo(int n) {
		int media=0;
		for( int i = 0; i < n; i ++){
			long inicio=System.nanoTime();
			encontrarNumeroFibonacci_iterativo(n);
			long fin= System.nanoTime();
			System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
			media+=fin-inicio;
		}
		System.out.println("MEDIA RECURSIVO: "+ media/n+"ns \n");
	}
	
	public static void tiempoRecursivo(int n) {
		int media=0;
		for( int i = 0; i < n; i ++){
			long inicio=System.nanoTime();
			encontrarNumeroFibonacci_recursivo(n);
			long fin= System.nanoTime();
			System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
			media+=fin-inicio;
		}
		System.out.println("MEDIA RECURSIVO: "+ media/n+"ns \n");
	}
	
	
	
	
	
}
