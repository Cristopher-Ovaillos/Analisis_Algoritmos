package ejemplos_InOut.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_1 {

    public static void main(String[] args) {
   
        String nombreArchivoEntrada = "src/ejemplos_InOut/Ejercicios/entrada.txt";
        String nombreArchivoSalida = "src/ejemplos_InOut/Ejercicios/sinEspacios.txt";
   
        String linea = null;

        try {
        
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);
         
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

         //readLine() es un metodo de la clase BufferedReader que lee una linea completa de texto desde un archivo o una fuente de datos.
            while ((linea = bufferLectura.readLine()) != null) {
                String lineaSinEspacio = linea.replaceAll(" ", "");
                bufferEscritura.write(lineaSinEspacio);
                bufferEscritura.newLine();
            }

         
            bufferLectura.close();
            bufferEscritura.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}