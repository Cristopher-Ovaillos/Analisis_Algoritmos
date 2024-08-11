package ejemplos_InOut.Ejercicios.Repaso_Algoritmia;

public class Ej_2 {
    public static void main(String[] args) {
        char[] matriz = {'e', 'u', 'o', 'i', 'a'};
        metodo(matriz);
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i]);
        }
    }

    public static void metodo(char[] vocales) {
        char aux;

        for (int i = 1; i < vocales.length; i++) {
            if (vocales[i - 1] > vocales[i]) {
                aux = vocales[i - 1];
                vocales[i - 1] = vocales[i];
                vocales[i] = aux;
            }
        }
    }
}

