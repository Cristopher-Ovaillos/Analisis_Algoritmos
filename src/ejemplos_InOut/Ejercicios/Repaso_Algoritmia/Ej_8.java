package ejemplos_InOut.Ejercicios.Repaso_Algoritmia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ej_8 {
    static final int CANTALUMNOS = 6;
    static final int CANT_MATERIAS = 5;
    //static final String NOMBRE_ARCHIVO_0= "src/ejemplos_InOut/Ejercicios/Repaso_algoritmia/notas.txt";
    static final String NOMBRE_ARCHIVO_0 = "src/ejemplos_InOut/Ejercicios/Repaso_algoritmia/nota_2.txt";
    //static final String NOMBRE_ARCHIVO_0 = "src/ejemplos_InOut/Ejercicios/Repaso_algoritmia/nota_3.txt";
    static final Alumno[] alumnos = new Alumno[CANTALUMNOS];

    private static void medioAlumno() {
        for (int i = 0; i < alumnos.length; i++) {
            float[] notas = alumnos[i].getNotas();  
            float promedio = calculoPromedio(notas);
            System.out.println("El promedio del alumno " + alumnos[i].getNombre() + " es: " + promedio);
        }
    }
	
	private static float calculoPromedio(float[] notas){
		float retornar=0;
		for (int i = 0; i < notas.length; i++) {
			retornar+=notas[i];
		}
		retornar=retornar/CANT_MATERIAS;
		return retornar;
	}

	private static void insertionSort(){
		for (int i = 1; i < alumnos.length; i++) {
			//auxiliar   alumno
			Alumno aux = alumnos[i];
			int j = i - 1;
	
			while (j >= 0 && calculoPromedio(alumnos[j].getNotas()) < calculoPromedio(aux.getNotas())) {
				alumnos[j + 1] = alumnos[j];
				j = j - 1;
			}
			alumnos[j + 1] = aux;
		}
	}
	
    private static void bubbleSort() {
        int n = alumnos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (calculoPromedio(alumnos[j].getNotas()) < calculoPromedio(alumnos[j + 1].getNotas())) {
                    Alumno temp = alumnos[j];
                    alumnos[j] = alumnos[j + 1];
                    alumnos[j + 1] = temp;
                }
            }
        }
    }

    private static void mediaAsignaturas() {
        for (int j = 0; j < CANT_MATERIAS; j++) {
            float sumaNotas = 0;
            for (int i = 0; i < alumnos.length; i++) {
                sumaNotas += alumnos[i].getNotas()[j];
            }
            float promedio = sumaNotas / CANTALUMNOS;
            System.out.println("La media de la asignatura " + (j + 1) + " es: " + promedio);
        }
    }
	private static void mediaTotalClase() {
        float sumaTotalNotas = 0;
        int totalNotas = CANTALUMNOS * CANT_MATERIAS;
        
        for (int i = 0; i < alumnos.length; i++) {
            float[] notas = alumnos[i].getNotas();
            for (int j = 0; j < notas.length; j++) {
                sumaTotalNotas += notas[j];
            }
        }
        
        float promedioTotal = sumaTotalNotas / totalNotas;
        System.out.println("La media total de la clase es: " + promedioTotal);
    }
	
    private static void leerArchivo_1() {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO_0));
            Scanner s = new Scanner(buff);
            for (int i = 0; i < CANTALUMNOS; i++) {
                float[] nota = new float[CANT_MATERIAS];
                for (int j = 0; j < CANT_MATERIAS; j++) {
                    nota[j] = s.nextFloat();
                }
                alumnos[i] = new Alumno(i + 1, nota); 
            }
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

	

    public static void main(String[] args) {
        leerArchivo_1();
        medioAlumno();
		mediaAsignaturas();
		mediaTotalClase();
		//insertionSort();
		//bubbleSort();
		for (int i = 0; i < alumnos.length; i++) {
			System.out.print("Id Alumno"+alumnos[i].getNombre()+"-	");
		}
    }	
}