package ejemplos_InOut.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import ejemplos_InOut.Aleatorio;
public class Ejercicio_3 {
    static final int CANTNUMEROS = 100;
    static final int MIN_VALOR = -100;
    static final int MAX_VALOR = 100;
	static final String NOMBRE_ARCHIVO = "src/ejemplos_InOut/Ejercicios/numeros.txt";

    private static void generarArchivo() {
    	try {
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    	
    		for (int i = 0; i < CANTNUMEROS; i++) {
    			double num = Aleatorio.doubleAleatorio(MIN_VALOR, MAX_VALOR);
    			buff.write(num + "\n");
    			System.out.println(num);
    		}
    		buff.close();
    	} catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    private static double[] leerArchivo() {
    	double[] arreglo = new double[CANTNUMEROS];
    	try {
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
    		for (int i = 0; i < CANTNUMEROS; i++) {
    			// Convertir cada línea leída en un double
    			arreglo[i] = Double.parseDouble(buff.readLine());
    		}
    		buff.close();
    	} catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    	return arreglo;
    }

    private static void mostrarLosNMasGrandesDelArchivo(int n, double[] arreglo) {
        Arrays.sort(arreglo); // Reemplazar esta llamada por sus propios metodos de ordenamiento.
        int tope = Math.max(0, arreglo.length - n);
        System.out.println("Los " + n + " números más grandes son:");
        for (int i = arreglo.length - 1; i >= tope; i--) {
        	System.out.println(arreglo[i]);
        }
    }

    public static void main(String[] args) {
    	// Generar el archivo con números aleatorios
    	generarArchivo(); // Una vez que ya tenemos un archivo generado, no hace falta generar uno nuevo.
    	
    	// Leer los números del archivo generado
    	double[] arregloGenerado = leerArchivo();
    	
    	// Tomar la hora del sistema en nanosegundos
    	long inicio = System.nanoTime(); 
    	
    	// Mostrar los N números más grandes del arreglo
    	mostrarLosNMasGrandesDelArchivo(CANTNUMEROS, arregloGenerado);
    	
    	long fin = System.nanoTime();
    	System.out.println("Se tardo: " + (fin - inicio) + " nanosegundos en obtener los numeros mas grandes");
    }
}
