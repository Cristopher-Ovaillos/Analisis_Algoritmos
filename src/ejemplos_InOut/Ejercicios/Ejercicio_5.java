package ejemplos_InOut.Ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import ejemplos_InOut.Aleatorio;//importo un archivo, con los metodos que utilizaremos

public class Ejercicio_5 {
    static final int CANT_NUMEROS = 50; // Cantidad de cadenas a generar
   
    static final String NOMBRE_ARCHIVO = "src/ejemplos_InOut/Ejercicios/ejercicio5.txt"; // Archivo de salida

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rangoInferior = 1;
        int rangoSuperior = 1000;
        Set<Integer> set = new HashSet<>();
        while (set.size()<=CANT_NUMEROS) {
            int random= Aleatorio.intAleatorio(rangoInferior, rangoSuperior);
            set.add(random);
        }
        try {
            BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
            bufferEscritura.write(set.toString());
            bufferEscritura.close();
        } catch (IOException ex) {
            System.err.println("Error escribiendo en el archivo: " + ex.getMessage());
        }
    }
}
