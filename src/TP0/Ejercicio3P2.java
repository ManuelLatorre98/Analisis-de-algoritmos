package TP0;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3P2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//int n=ingreso(sc);
		
		System.out.println("Cantidad de primos entre 1 y "+1000+": "+ calculoPrimosWhileStop(1000));
		
	}
	
	public static int ingreso(Scanner sc) {
		int n=0;
		boolean exito=false;
		while(!exito) {
			try {
				System.out.println("Ingrese un numero N para saber cuantos numeros primos hay entre 1 y N");
				n = sc.nextInt();
				System.out.println("Numero Ingresado "+n);
				exito=true;
			}catch(InputMismatchException e) {
				System.err.println("Caracter ingresado invalido, debe ser un numero entero");
				sc.next();
			}
		}
		return n;
	}
	
	public static int calculoPrimos(int n) { //Intermedio
		int cant=0;
		int j;
		boolean corto=false;
		long inicio=System.nanoTime();
		for (int i = 2; i <= n; i++) {
			corto=false;
			j=i;
		
			while(j>0 && !corto) {
				//System.out.print("Analizo: "+i+"  Lo divido por: "+j+" CORTO: ");
				if(i%j==0 && (j!=1 && j!=i)) {//Si es divisible por un numero diferente a 1 y si mismo corto
					//System.out.print(true);
					corto=true;
				}
				//System.out.println("\n");
				j--;
			}
			
			if(!corto) {//Si solo fue divisible por si mismo y 1
				cant++;
			}
		}
		long fin= System.nanoTime();
		System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
		return cant;
	}
	
	public static int calculoPrimosFor(int n) { //Mas eficiente
		int cant=0;
		int contDiv=0;
		long inicio=System.nanoTime();
		for (int i = 2; i <= n; i++) {
			contDiv=0;
			for (int j = i; j > 0; j--) {
				if(i%j==0) {
					contDiv++;
				}
			}
			if(contDiv<=2) {//Si solo fue divisible por si mismo y 1
				cant++;
			}
		}
		long fin= System.nanoTime();
		System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
		return cant;
		
	}

	public static int calculoPrimosWhileStop(int n) { //Menos eficiente
		int cant=0;
		int contDiv=0;
		int j;
		long inicio=System.nanoTime();
		for (int i = 2; i <= n; i++) {
			contDiv=0;
			j=i;
			while(j>0 && contDiv<=2) {
				//System.out.print("Analizo: "+i+"  Lo divido por: "+j+" EXITO: ");
				if(i%j==0) {
					//System.out.print(true);
					contDiv++;
				}
				//System.out.println("\n");
				j--;
			}
			if(contDiv<=2) {//Si solo fue divisible por si mismo y 1
					cant++;
				}
		}
		long fin= System.nanoTime();
		System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
			return cant;
		
	}
}
