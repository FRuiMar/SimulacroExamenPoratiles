package utiles;

import java.util.Scanner;

public class Ejercicio03_Array150MetodoOrdenacionShell {

	public static void main(String[] args) {
		
//		int[] a = new int [] {77, 74, 54, 52, 31, 65, 8, 49, 55, 28, 36, 58, 47, 72, 100, 82, 0, 78, 40, 82};

		int[] a = new int [150];
		utiles.UtilesArrays.inicializaArray(a, 0, 100);
		System.out.println("El array inicial es: ");
		utiles.UtilesArrays.imprimeArrays(a);
		
		ordenaShell(a, 10);
		
		System.out.println("\nEl array ordenado por Selección es: ");
		utiles.UtilesArrays.imprimeArrays(a);
	}
		
	public static void ordenaShell (int a[], int tamanioShellInicial) {
	
		int temp;
		boolean estaOrdenado;
		int distancia = tamanioShellInicial;
		
		
		do {
			do {
				estaOrdenado = true;
				
				for(int i = 0; i < a.length - distancia; i++) {		
					if (a[i] > a[i + distancia]) {
						temp = a[i + distancia];
						a[i + distancia] = a[i];
						a[i] = temp;
						
						estaOrdenado = false;
					}
					
				}
			} while (estaOrdenado == false);	
			
			distancia /= 2;
			
		} while  (distancia > 0);
	}		
}
