package ejemplos_InOut.Ejercicios.Repaso_Algoritmia;

import java.util.Scanner;

public class Ej_3 {
    

    public static boolean esPrimo(int num) {
        return num > 1 && (num == 2 || num % 2 != 0 && esPrimo(num, 3));
    }


    private static boolean esPrimo(int num, int divisor) {
      boolean retornar;
        if (divisor * divisor > num) {
            retornar=true;
        }else{

            retornar=num % divisor != 0 && esPrimo(num, divisor + 2);
        }
        return retornar;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un número n: ");
        int n = scanner.nextInt();
        
        int conteoPrimos = contarPrimos(n);
        
        System.out.println("Cantidad de números primos entre 1 y " + n + ": " + conteoPrimos);
        
        scanner.close();
    }


    private static int contarPrimos(int n) {
        int conteo = 0;
        for (int i = 1; i <= n; i++) {
            if (esPrimo(i)) {
                conteo++;
            }
        }
        return conteo;
    }
}
