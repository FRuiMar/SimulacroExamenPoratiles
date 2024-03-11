package utils;

public class UtilsArrays {

	/**
	 * Imprime el array en consola, de forma que queda en una única línea y con
	 * un espacio en blanco entre valores
	 * @param num
	 */
	public static void imprimeArray (int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}


	
	/**
	 * Inicializa Array con límites dados
	 * 
	 * 
	 * @param a
	 * @param limInf
	 * @param limSup
	 */
	public static void inicializaArrayLimites (int array[], int limInf, int limSup) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}
	}
	
	

}
