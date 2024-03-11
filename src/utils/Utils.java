package utils;


public class Utils {

	/**
	 * Método que obtiene y devuelve un número al azar, entre 0 y 100.
	 * @return Número generado al azar entre 0 y 100
	 */
	public static int obtenerNumeroAzar () {
		 return (int) Math.round(Math.random() * 100);
	}

}
