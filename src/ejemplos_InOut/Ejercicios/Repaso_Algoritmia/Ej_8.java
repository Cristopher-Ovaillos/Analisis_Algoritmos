package ejemplos_InOut.Ejercicios.Repaso_Algoritmia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Podemos usar una instancia de la clase Scanner para poder leer datos de forma más comoda que con
 * un Reader "pelado". Recordamos que un reader solo nos provee operaciones para leer o un byte o
 * una linea completa (hasta el siguiente \n o \r ).
 *
 * Scanner nos permite encapsular un objeto Reader, un Stream (como System.in) o un String y obtener a
 * partir de ese objeto secuencialmente datos de tipos primitivos o incluso substrings separados sin
 * que necesitemos controlar manualmente como se reconocen esos datos.
 *
 * https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
 * @author jpinero
 */
public class Ej_8 {
    static final int CANTALUMNOS = 6;
	static final int CANT_MATERIAS = 5;
    static final int MAX_VALOR = 1000000;
    static final String NOMBRE_ARCHIVO = "src/ejemplos_InOut/Ejercicios/Repaso_algoritmia/notas.txt";
	static final Alumno[] alumnos= new Alumno[CANTALUMNOS];

    private static void leerArchivo_1(){
    	try{
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
    		Scanner s = new Scanner(buff);
    		for (int i = 0; i < CANTALUMNOS  ; i++){
				
				float[] nota= new float[CANT_MATERIAS];
				for (int j = 0; j < CANT_MATERIAS; j++) {
					nota[j]=s.nextFloat();

				}
				
				alumnos[i] = new Alumno(i + 1, nota); 
    		
    		}

		
    		buff.close();
    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }


    public static void main(String[] args) {
		//System.out.println("Ruta del archivo: " + new java.io.File(NOMBRE_ARCHIVO).getAbsolutePath());

    	leerArchivo_1();
    	//leerArchivo_2();
    }
}