package utiles;

public class UtilesMatrices {
	

	
	/**
	 * Genera una matriz al azar entre dos límites indicados
	 * @param m   Es la matriz que entregas al método para que rellene
	 * @param limInf    El número al azar mínimo que quieres que aparezca
	 * @param limSup	El número al azar máximo que quieres que aparezca
	 */
	public static void inicializaMatriz (int m[][], int limInf, int limSup) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = Utiles.obtenerNumeroAzar(limInf, limSup);
			}
		}
	}
	

	/**
	 * Imprime la matriz que se indique
	 * @param matriz Es la matriz que recibe indicando tipo (entero, double, etc). Al ser matriz lleva dos [][], para dos índices.
	 */
	public static void imprimeMatrizConTab(int matr[][]) {
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				System.out.print(matr[i][j] + "\t");  //añado un tabulador en vez de un espacio después de cada número de la matriz
			}
			System.out.println();  //al terminar de sacar en pantalla una fila imprime un salto de página y continúa imprimiendo la siguiente fila
		}
		
	}


	/**
	 * Imprime la matriz que se indique
	 * @param matriz Es la matriz que recibe indicando tipo (entero, double, etc). Al ser matriz lleva dos [][], para dos índices.
	 */
	public static void imprimeMatrizConEspacio(int matr[][]) {
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				System.out.print(matr[i][j] + " " + " ");  //añado un tabulador en vez de un espacio después de cada número de la matriz
			}
			System.out.println();  //al terminar de sacar en pantalla una fila imprime un salto de página y continúa imprimiendo la siguiente fila
		}
		
	}
	
	/**
	 * Método que crea una matriz de un array en orden normal. 
	 * @param array
	 */
	public static void creaMatrizfromArray(int[] array) {
		
		int raiz = (int) Math.sqrt(array.length);  //los arrays siempre seran cuadrados perfectos.
		System.out.println();
		System.out.println("La raiz es: " + raiz);		
		
		int[][] matriz = new int[raiz][raiz];
		
		int k = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = array[k];
				k++;
			}
		}
		System.out.println();	
		UtilesMatrices.imprimeMatrizConTab(matriz);
	}
	
	/**
	 * Método que verifica si una matriz está ordenada de izquireda a derecha y de arriba a abajo.
	 * @param m  matriz que recibimos para verificar.
	 */
	public static void estaOrdenadaMatriz (int[][] m) {
		
		boolean estaOrdenada = true;
			
		//verificamos las filas
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length - 1; j++) {
				if(m[i][j] > m[i][j + 1]){
					estaOrdenada = false;
				}
			}
		}
		
		//verificamos número final de fila(o cualquier número puesto que cumple la verificación anterior), con el siguiente número
		
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 0; j < m.length; j++) {
				if(m[i][m.length-1] > m[i + 1][0]){
					estaOrdenada = false;
				}
			}
		}
		
		if (estaOrdenada) System.out.println("La matriz está ordenada");
		else System.out.println("La matriz NO está ordenada");

	}
	
	
	
}
