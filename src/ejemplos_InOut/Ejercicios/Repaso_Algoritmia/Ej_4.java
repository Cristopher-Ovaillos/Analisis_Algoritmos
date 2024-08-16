package ejemplos_InOut.Ejercicios.Repaso_Algoritmia;

import java.util.Scanner;
import java.util.Random;
import ejemplos_InOut.Aleatorio;//importo un archivo, con los metodos que utilizaremos
public class Ej_4 {

    public static void main(String[] args) {
        //creo un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        //Defino mi rango 
        int rangoInferior = 1;
        int rangoSuperior = 100;
        //Con ayuda de Aleatorio.java podemos buscar el numero que sera secreto
        int numSecreto = Aleatorio.intAleatorio(rangoInferior, rangoSuperior);
        //var para almacenar las adivinansas
        int adivinanza = 0;
        System.out.println("Numero entre " + rangoInferior + " y " + rangoSuperior + " generado. ¡Intenta adivinarlo!");
        //System.out.println(numSecreto);
        // Bucle hasta que lo adivine
        while (adivinanza != numSecreto) {
            System.out.print("Introduce un numero: ");
            adivinanza = scanner.nextInt();
            
            //comparamos el numero ingresado con el numero secreto
            if (adivinanza < numSecreto) {
                System.out.println("El num secreto es mayor.");
            } else if (adivinanza > numSecreto) {
                System.out.println("El num secreto es menor.");
            } else {
                System.out.println("Felicidades!!!!!!! adivinaste el numero.");
            }
        }
        
        scanner.close();
    }
}

