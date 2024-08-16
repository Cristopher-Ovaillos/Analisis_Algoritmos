package ejemplos_InOut.Ejercicios.Repaso_Algoritmia;


import ejemplos_InOut.Aleatorio;//importo un archivo, con los metodos que utilizaremos

public class Ej_9 {
    static final int TAMANIO_A = 100;
    static final int TAMANIO_B = 60;

    private static void mostrarArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] listaA = new int[TAMANIO_A];
        int[] listaB = new int[TAMANIO_B];
        for (int i = 0; i < TAMANIO_A; i++) {
            listaA[i] = Aleatorio.intAleatorio(1, 1000);
        }
        for (int i = 0; i < TAMANIO_B; i++) {
            listaB[i] = Aleatorio.intAleatorio(1, 1000);
        }

        mergeSort(listaA, 0, listaA.length - 1);
        mostrarArray(listaA);
        System.out.println();
        mergeSort(listaB, 0, listaB.length - 1);
        mostrarArray(listaB);
        System.out.println();
        //creo la lista C a partir de la mezcla de listaA y listaB
        int[] listaC = fusionLista(listaA, listaB);
        System.out.println("Lista C (mezcla de A y B ordenadas):");
        mostrarArray(listaC);
        System.out.println();
  

    }


  private static void mergeSort(int[] array, int izq, int der) {
    if (izq < der) {
        int mid = (izq + der) / 2;
        mergeSort(array, izq, mid);
        mergeSort(array, mid + 1, der);
        merge(array, izq, mid, der);
    }
}

//meetodo para fusionar dos mitades ordenadas
private static void merge(int[] array, int izq, int mid, int der) {
    int n1 = mid - izq + 1;
    int n2 = der - mid;
    //creo arrays tempo para las dos mitades
    int[] arrayIzq = new int[n1];
    int[] arrayDer = new int[n2];
    //copio datos a  los arrays temporales
    for (int i = 0; i < n1; i++) {
        arrayIzq[i] = array[izq + i];
    }
    for (int j = 0; j < n2; j++) {
        arrayDer[j] = array[mid + 1 + j];
    }
    // fusiono los arrays temp de vuelta al array originall
    int i = 0, j = 0;
    int k = izq;
    while (i < n1 && j < n2) {
        if (arrayIzq[i] <= arrayDer[j]) {
            array[k++] = arrayIzq[i++];
        } else {
            array[k++] = arrayDer[j++];
        }
    }

    // Copiar los elementos restantes de arrayIzq, si hay alguno
    while (i < n1) {
        array[k++] = arrayIzq[i++];
    }

    // Copiar los elementos restantes de arrayDer, si hay alguno
    while (j < n2) {
        array[k++] = arrayDer[j++];
    }
}

// metodo para fusionar dos listas ordenadas
private static int[] fusionLista(int[] listaA, int[] listaB) {
    int[] listaC = new int[listaA.length + listaB.length];
    int i = 0, j = 0, k = 0;

    while (i < listaA.length && j < listaB.length) {
        if (listaA[i] <= listaB[j]) {
            listaC[k++] = listaA[i++];
        } else {
            listaC[k++] = listaB[j++];
        }
    }

    // Copio los elementos restantes de listaA
    while (i < listaA.length) {
        listaC[k++] = listaA[i++];
    }

    // Copio los elementos restantes de listaB
    while (j < listaB.length) {
        listaC[k++] = listaB[j++];
    }

    return listaC;
}

}
