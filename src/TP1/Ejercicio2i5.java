package TP1;

import java.util.Hashtable;
import java.util.Random;

public class Ejercicio2i5 {
	public static void main(String[] args) {
		int n=10000;
		int []array= new int [n];
		ArbolAVL arbol=new ArbolAVL();//Creo AVL
		long inicio=System.nanoTime();
		esPar(n);//O(1)
		llenarArray(array,n);//O(n)
		llenarAVL(array,arbol);//O(n log n)
		long fin= System.nanoTime();
		long tiempo=fin-inicio;
		System.out.println("Tiempo de ejecucion: "+tiempo+"ns");
		
		/*//Testeo, antes no asigne a variables a esPar(n) para no agregar tiempo por eso la llamo de nuevo
		if(esPar(n)) {//O(1)
			System.out.println("El numero "+n+" es par");
		}else {
			System.out.println("El numero "+n+" es impar");
		}
		
		escribirArray(array);
		System.out.println(arbol.toString());*/
	}
	
	public static boolean esPar(int n) { //O(1)
		return n%2==0;//TA1=1 --> O(1)
	}
	
	public static void llenarArray(int[]array,int n) {//
		int cont=n;//Ts1=1
		for (int i = 0; i < array.length; i++) {//Ts2= n* (1+4+2) + 1= 7n+1
			array[i]=cont; //Ts3=1+1=2
			cont--;//Ts4=2
		}//TA2= 1+7n+1= 7n+2 --> O(n)
		
	}
	
	public static void llenarAVL(int[]array, ArbolAVL arbol) {//
		for (int i = 0; i < array.length; i++) {//Tt1=n * (1+log n+2) + 1= Tt1= n+nlogn+2n+1= n logn+3n+1 --> O(n log n)
			arbol.insertar(array[i]);//Tt3= log n (explicado en la narrativa de arriba)
		}
	}
	
	public static void escribirArray(int []array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
		System.out.println("]");
	}
	
	
	//El tiempo de orden seria O(n . log(n)) ya que al ser una ejecucion secuencial los algoritmos se suman
	//Por lo que el orden total seria el mas costoso 
}
