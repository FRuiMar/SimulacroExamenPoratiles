package utiles;

import java.util.Random;

public class PruebasOrdenacionBucleJ {
    public static void main(String[] args) {
        int[] array = new int[5];
        inicializaArrayAleatorio(array, 0, 100);
        imprimeArray(array);

        desplazaCiclicoDerecha(array);
        imprimeArray(array);
    }

    public static void desplazaCiclicoDerecha(int[] a) {
        int n = a.length;
        int temp = a[n - 1];  // Guarda el último elemento del array
        for (int i = n - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = temp;  // Coloca el último elemento en la primera posición
    }

    public static void inicializaArrayAleatorio(int[] array, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(max - min + 1) + min;
        }
    }

    public static void imprimeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
