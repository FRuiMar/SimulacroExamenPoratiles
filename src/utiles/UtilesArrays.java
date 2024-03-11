package utiles;

import java.util.Scanner;

public class UtilesArrays {
	
	/**
	 * Imprime el array en consola, de forma que queda en una única línea y con
	 * un espacio en blanco entre valores
	 * @param num
	 */	
	public static void imprimeArrays (int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}
	
	/**
	 * Imprime el array en consola, de forma que queda en una única línea y con
	 * un espacio en blanco entre valores
	 * @param num
	 */	
	public static void imprimeArraysTexto (int[] a, String mensaje) {
		System.out.println(mensaje);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}
	
	
	/**
	 * Genera un array al azar entre dos límites indicados
	 * @param a
	 * @param limInf
	 * @param limSup
	 */
	public static void inicializaArray (int a[], int limInf, int limSup) {
		for (int i = 0; i < a.length; i++) {
			a[i] = Utiles.obtenerNumeroAzar(limInf, limSup);
		}
	}
	
	public static void cambiaSignoEnValores (int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				a[i] = -a[i];        //se puede hacer multiplicando por -1
			}
		}
	}
	
	/**
	 * Método que imprime una cadena de caracteres a la inversa.
	 * @param s  Es la cadena de caracteres que debe recibir para realizar la operación
	 */
	public static void imprimeInversa (String str) {   
		
		for(int i = str.length()-1; i > -1 ; i--)
		System.out.print(str.charAt(i));
	}
	

	/**
	 * Método que ordena los números del array de menor a mayor.
	 * @param a  Es el array que vamos a ordenar
	 */
	public static void ordenaBurbujaAscendente (int a[]) {
		
		boolean haycambios = false;
		int aux = 0;
		do {
			haycambios = false;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i+1]) {
					aux = a[i];
					a[i] = a[i+1];
					a[i+1] = aux;
					haycambios = true;				
				}
			}	
		} while (haycambios == true);			
	}
	
	
	/**
	 * Método que ordena los números del array de mayor a menor.. 
	 * es igual pero cambia en if el simbolo > por <..
	 * @param a  Es el array que vamos a ordenar
	 */
	public static void ordenaBurbujaDescendente (int a[]) {
		
		boolean haycambios = false;
		int aux = 0;
		do {
			haycambios = false;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] < a[i+1]) {
					aux = a[i];
					a[i] = a[i+1];
					a[i+1] = aux;
					haycambios = true;				
				}
			}	
		} while (haycambios == true);			
	}
	
	
	
	
	
	/**
	 * Método para que te pida la consola X números y se metan en un array de X longitud.
	 * Debes modificar la cantidad según necesidad.
	 * @return    devuelve un int array con los números introducidos.
	 */
	public static int[] pide10NumYCreaArray() {
		Scanner sc = new Scanner(System.in);

        int[] arrayNumeros = new int[10];
        sc.close();
        System.out.println("Introduce 10 números:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            arrayNumeros[i] = sc.nextInt();     
        }

        return arrayNumeros;
	}
	
	
	
	
	/**
	 * Método que añade nuevos números al final de un array, por si has borrado algunos antes. 
	 * @param array
	 * @param nuevoNum
	 * @return
	 */
	public static int[] addInteger (int[] array, int nuevoNum) {
		
		int[] arrayB = new int[array.length + 1];   
		
		for (int i = 0; i < arrayB.length ; i++) {
			if( i < arrayB.length - 1) {   //aquí el -1 indica el hueco que queda libre.. si hay más, lo cambias a -2, o lo que sea.
				arrayB[i] = array[i];
			}else {
				arrayB[i] = nuevoNum;
			}
		}
		return arrayB;
	}
	
	
	/**
	 * Método para pasar un array de números enteros a un string, usando StringBuffer.
	 * @param array  el array que recibimos de números 
	 * @return el string que se manda a main.
	 */
	public static String stringFromArray(int[]array) {
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < array.length; i++) {			//recordar esta forma. ahorra mucho tiempo.  for (int num : array), sb.append((char) num);  
            												//-- creas una variable nueva.. Significa (para cada num del array)
			sb.append((char)array[i]);    // si añades sólo el array[i] estás añadiendo el número al string buffer,
											//también puedes crear una variable antes char caracter = (char) array[i] y añadir append(caracter).										
											// se pueden añadir dos append??.
        }																								
		return sb.toString();
	}	
	
}
