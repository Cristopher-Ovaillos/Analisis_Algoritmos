package ejemplos_InOut.Ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ejemplos_InOut.Aleatorio;
public class Ejercicio_4 {

    static final int CANT_CADENAS = 10000; // Cantidad de cadenas a generar
    static final int LONGITUD_CADENA = 10; // Longitud de cada cadena alfanumérica
    static final String NOMBRE_ARCHIVO = "src/ejemplos_InOut/Ejercicios/cadenas.txt"; // Archivo de salida
        
    public static void main(String[] args) {
      
        try {
            BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
      
            for (int i = 0; i < CANT_CADENAS; i++) {
                bufferEscritura.write(Aleatorio.stringAleatorioConNumeros(LONGITUD_CADENA) + "\n");
            }

            bufferEscritura.close();
        } catch (IOException ex) {
            System.err.println("Error escribiendo en el archivo: " + ex.getMessage());
        }
    }
}

