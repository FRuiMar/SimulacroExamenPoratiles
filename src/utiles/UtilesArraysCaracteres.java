package utiles;

import java.util.Scanner;

public class UtilesArraysCaracteres {
	
	
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
	
	
	
	
	
	
	/**
	 * Método que cuenta las vocales y consonantes de la cadena String.
	 * @param s  Es la cadena de caracteres que debe recibir para realizar la operación
	 */
	public static void calculaConsonantesYVocales (String s) {   
		int contVocal = 0,contConso = 0;			//contadores de vocales y consonantes
		

		for(int i = 0; i < s.length(); i++) {
			if ( s.charAt(i) >= 'A'  && s.charAt(i) <= 'Z' || 			//bucle para localizar las letras de la cadena (tanto mayusculas como minúsculas)
					s.charAt(i) >= 'a'  && s.charAt(i) <= 'z') {
				
				
				if (s.charAt(i) == 'A'|| s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' ||               //IF para verificar cuales de esas letras son vocales
						s.charAt(i) == 'U' || s.charAt(i) == 'a' || s.charAt(i) == 'e' ||  s.charAt(i) == 'i' || 
						s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				contVocal++;											//contador vocales (si entra en cualquiera de los casos)
				}
				else
					contConso++;										//contador consonantes ( si no entra en los casos previos)
			}
		}
		System.out.println("El número de vocales es: " + contVocal + "\nY el número de consonantes es: " + contConso);
	}
	
	
	
	
	
	/**
	 * Método que cuenta las vocales y consonantes de la cadena con Switch.
	 * @param s  Es la cadena de caracteres que debe recibir para realizar la operación
	 */
	public static void cuentaConsonantesYVocalesSwitch (String str) {   
		int contVocal = 0,contConso = 0;
		
		for(int i = 0; i < str.length(); i++) {						//bucle para localizar las letras de la cadena (tanto mayusculas como minúsculas)
			if ( str.charAt(i) > 64  && str.charAt(i) < 91 || 
					str.charAt(i) > 96  && str.charAt(i) < 123) {
								
				
				switch (str.charAt(i)) {		//switch para verificar cuales de esas letras son vocales
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					contVocal++;				//contador vocales (si entra en cualquiera de los casos)
					break;
				default:
					contConso++;				//contador consonantes ( si no entra en los casos previos)
					break;			
				}
			}
		}
		System.out.println("El número de vocales es: " + contVocal + "\nY el número de consonantes es: " + contConso);
	}
	
	
	
	
	
	
	/**
	 * Método para quitar los espacios en una cadena de caracteres String
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static String quitaLosEspacios(String str1, String str2) {
		for (int i = 0; i < str1.length(); i++) {						// saco variable char caracter para trabajar más cómodo
			char caracter = str1.charAt(i);								//para cada valor del caracter diferente de espacio, añado el caracter a la string2
			if (caracter != ' ') {										//añado el caracter a la string2
				str2 += caracter;  	//Concatena el caracter a la cadena... (me ahorro crear una array de char y luego el string obtenerlo de ese array)
			}						// Se puede crear un charArray[i] = caracter, y luego String str2 = new String (charArray);
			
		}
		return str2;
	}
	

	
	
		/**
		 * Método que cuenta las veces que aparece una subcadena (str2) en una cadena dada (str1)
		 * @param str1
		 * @param str2
		 * @return
		 */
		public static int cuentaOcurrencias (String str1, String str2) {
		
//		if (str2 == "") {
//			return 0;
//		}
		
		
		int numOcur = 0;
				
		for (int i = 0; i <= str1.length() - str2.length(); i++) {     //hago esa resta porque daba error al intentar comparar una subcadena cuyo primer indice, coincidia con el último índice de la cadena principal.
			
			char caracterCadena = str1.charAt(i);
			char caracterSubcadena = str2.charAt(0);
			
			if (caracterCadena == caracterSubcadena) {
				
				boolean hayOcurrencia = true; 
				
				for (int j = 0; j < str2.length(); j++) {              //puedo hacer que la j empiece por el siguiente valor, ya que se ha comparado antes.
					if (str1.charAt(i + j) != str2.charAt(j)) {
						hayOcurrencia = false;
					}
										
				}
				
				if (hayOcurrencia) {
					numOcur++;
				}
				
				
			}
		
		}	
						
		return numOcur;		
	}
	
	
		
		
		/**
		 * Método que cuenta localiza la palabra más larga
		 * @param str1
		 * @return
		 */
		public static String localizaPalabraMasLarga (String str1) {
			
			String candidata = "";
			String masLarga = "";
			
			for (int i = 0; i < str1.length(); i++) {						
				char caracter = str1.charAt(i);
				if (caracter != ' ' ) {   // estás en palabra
					candidata += caracter;               //almacena las letras en la palabra hasta encontrar el espacio en blanco                    
				} else {		
					if	(candidata.length() > masLarga.length())	 {	
						masLarga = candidata;
					}
					candidata = "";
				}
		
			}
			return masLarga;
		}
		
	
}
