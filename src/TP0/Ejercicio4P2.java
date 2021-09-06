package TP0;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4P2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int nroRnd=generarNro();
		long inicio=System.nanoTime();
		System.out.println("Nro "+nroRnd);
		adivinarNro(sc,nroRnd);
		long fin= System.nanoTime();
		System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
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
	
	public static int generarNro() {
		Random generador= new Random();
		return generador.nextInt(100);
	}
	
	public static void adivinarNro(Scanner sc,int nroRnd) {
		boolean exito=false;
		int nro;
		System.out.println("Adivine el numero entre 1 y 100");
		System.out.print("Ingrese el numero entero entre 1 y 100 que crea que toco: ");
		while(!exito) {
			try {
				nro=sc.nextInt();
				if(nro==nroRnd) {
					System.out.println("GANADOR");
					exito=true;
				}else {
					if(nro>nroRnd) {
						System.out.println("El numero ingresado es mayor. Ingrese otro numero: ");
					}else {
						System.out.println("El numero ingresado es menor. Ingrese otro numero: ");
					}
				}
			}catch(InputMismatchException e) {
				System.err.println("Caracter ingresado invalido, debe ser un numero entero");
				sc.next();
			}
		}
	}
}
