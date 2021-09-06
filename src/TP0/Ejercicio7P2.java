package TP0;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Hashtable;
import java.util.Random;

public class Ejercicio7P2 {
	public static void main(String[] args) {
		int [] array= {5,3,1,2,4};
		Lista lista=new Lista();
		Random generador = new Random();//Genero una lista con 5 numeros random que no se repiten
		int max=6;
		int min=1;
		int contNum=0;
		int num;
		int maxNum=5;
		Hashtable hash= new Hashtable();
		while(contNum<maxNum) {
			num=(generador.nextInt(max - min) + min);
			if(hash.get(num)==null) {
				lista.insertar(num, lista.longitud()+1);
				hash.put(num, num);
				contNum++;
			}
		}
		System.out.println(lista.toString());
		quickSort(lista,1,lista.longitud());
		System.out.println(lista.toString());
		
		
	}
	
	public static void quickSort(Lista lista, int izq, int der) {
		int pivote = (int)lista.recuperar(izq);//Elijo el primero como pivote
		int i=izq;
		int j=der;
		
		Object auxIntercambio;
		Object objJ;
		while(i<j) {
			while(((int)lista.recuperar(i))<=pivote && i<j) {
				i++;
			}
			
			while(((int)lista.recuperar(j))>pivote) {
				j--;
			}
			
			if(i<j) {
				auxIntercambio= lista.recuperar(i);
				lista.setElem(lista.recuperar(j), i);
				lista.setElem(auxIntercambio, j);
			}
		}
		
		lista.setElem(lista.recuperar(j), izq);
		lista.setElem(pivote, j);
		if(izq < j-1) {
			quickSort(lista,izq,j-1);
		}
		if(j+1<der) {
			quickSort(lista,j+1,der);
		}
	}
	
	
}
