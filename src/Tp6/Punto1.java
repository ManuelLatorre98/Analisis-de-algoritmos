package Tp6;

public class Punto1 {
	public static void main(String[] args) {
		int n=10;
		int media=0;
		System.out.println(n+" ejecuciones iterativas");
		for( int i = 0; i < n; i ++){
			long inicio=System.nanoTime();
			System.out.print(encontrarNumeroFibonacci_iterativo(n));
			long fin= System.nanoTime();
			System.out.println(": EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
			media+=fin-inicio;
		}
		System.out.println("MEDIA ITERATIVO: "+ media/n+"ns");
		
		System.out.println("______________________________________");
		System.out.println(n+" ejecuciones recursivas");
		media=0;
		for( int i = 0; i < n; i ++){
			long inicio=System.nanoTime();
			System.out.print(encontrarNumeroFibonacci_recursivo(n));
			long fin= System.nanoTime();
			System.out.println(": EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
			media+=fin-inicio;
		}
		System.out.println("MEDIA RECURSIVO: "+ media/n+"ns");
		
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
		if(n == 0 || n == 1){
	        return 1;
	    }

	    return encontrarNumeroFibonacci_recursivo(n-1) + encontrarNumeroFibonacci_recursivo(n-2);
	}
	

}
