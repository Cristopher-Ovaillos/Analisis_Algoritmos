package ejemplos_InOut.Ejercicios.Repaso_Algoritmia;
import java.util.Scanner;

public class Ej_3 {
    
    // metodo para verificar si un num es primo
    public static boolean esPrimo(int numero) {
        boolean esPrimo = true;  
    
        if (numero <= 1) {
            esPrimo = false;  
        } else {
            int i = 2;
            //no es necesario verificar todos los posibles divisores [2-numero]
            //basta con que sea de  [2- raiz cuadrada de (numero)]
            int cantDivisores = (int) Math.sqrt(numero);
            while (i <= cantDivisores && esPrimo) {
                if (numero % i == 0) {
                    esPrimo = false;  // si es divisor, entonces no es primo
                }
                i++;
            }
        }
    
        return esPrimo; 
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa un número n: ");
        int n = scanner.nextInt();
        
        int contadorPrimos = 0;
        
        // Contamos los números primos entre 1 y n
        for (int i = 1; i <= n; i++) {
            if (esPrimo(i)) {
                contadorPrimos++;
            }
        }
        
        System.out.println("Hay " + contadorPrimos + " numeros primos entre 1 y " + n + ".");
        
        scanner.close();
    }
}
