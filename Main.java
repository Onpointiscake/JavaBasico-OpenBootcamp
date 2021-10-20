package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // 1.
         devuelveStringDelReves("Hola");
        // 2,
        String[] nuevoArray02 = new String[]{"0","1","2","3","4"};
        returnValuesOfArray(nuevoArray02);
        // 3.
        int[][] nuevoArray03 = {{3, 4}, {5, 6}};
        returnValuesOfBiDimensionalArray(nuevoArray03);
        // 4.
        Vector<String> vector = new Vector<>();
        vector.add("Coche");
        vector.add("Moto");
        vector.add("Camion");
        vector.add("Patinete");
        vector.add("Furgoneta");
        vectorExample(vector);
        // 5.
        // Ver abajo

        // 6. Crear un Array con 4 elementos. Copialo a un LinkedList. E itera en ambos
        // imprimiendo solo los valores
        ArrayList<String> miPrimerArrayList = new ArrayList<String>();
        miPrimerArrayList.add("Elemento0");
        miPrimerArrayList.add("Elemento1");
        miPrimerArrayList.add("Elemento2");
        miPrimerArrayList.add("Elemento3");
        miPrimerArrayList.remove("Elemento3");

        for ( String elemento : miPrimerArrayList ) { System.out.println(elemento); }
        String miArrayDesdeLinkedList[] = new String[miPrimerArrayList.size()];
        for( String elemento : miArrayDesdeLinkedList ) {
            System.out.println(elemento);
        }
        System.out.println(miArrayDesdeLinkedList);


        // 7. Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
        // A continuación, con otro bucle, recórrelo y elimina los numeros pares.
        // Por último, vuelve a recorrerlo y muestra el ArrayList final.
        ArrayList<Integer> miSegundoArrayList = new ArrayList<Integer>();
        for(int i = 1; i <12; i++){
            miSegundoArrayList.add(i);
        }

        ArrayList<Integer> arrayDeIndicesAEliminar = new ArrayList<Integer>();
        for(int i=1; i < 11; i++){
            if(miSegundoArrayList.get(i) % 2 != 0){
                int elementoAEliminar = miSegundoArrayList.get(i);
                arrayDeIndicesAEliminar.add(elementoAEliminar);
            }
        }
        for(int i=1; i < miSegundoArrayList.size(); i++){
            for(int j=0; j <arrayDeIndicesAEliminar.size(); j++){
                if (miSegundoArrayList.get(i) == arrayDeIndicesAEliminar.get(j)){
                    miSegundoArrayList.remove(i-1);
                }
            }
        }
        miSegundoArrayList.remove(miSegundoArrayList.size()-1);
        System.out.println(miSegundoArrayList);

        
        // 8. Crea una función DividePorCero. Esta, debe generar una excepción ("throws")
        // a su llamante del tipo ArithmeticException que será capturada por su llamante (desde "main", por ejemplo).
        // Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
        // Finalmente, mostraremos en cualquier caso: "Demo de código".
        DividePorCero();

        //9.
        readAndCopy("password.txt", "destino.txt");
        //10:
        myFinalProgram();
    }


    //// METHODS //////////////////////-----------------------------------------------
    // 1. Escribe el código que devuelva una cadena al revés.
    //    Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".
    public static String devuelveStringDelReves (String palabra){
        for (int i = palabra.length() -1; i > -1; i--) {
            System.out.println(palabra.charAt(i));
        }
        return  palabra;
    }

    // 2. Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
    public static void returnValuesOfArray (String[] arrayUnidimensional){
        for (int i = 0; i < arrayUnidimensional.length; i++) {
            System.out.print(arrayUnidimensional[i]);
        }
    }

    // 3. Crea un array bidimensional de enteros y recórrelo,
    //    mostrando la posición y el valor de cada elemento en ambas dimensiones.
        public static void returnValuesOfBiDimensionalArray (int[][] arrayBiDimensional){
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    System.out.println("arr[" + i + "][" + j + "] = "
                            + arrayBiDimensional[i][j]);
        }

    // 4. Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
    //    Elimina el 2o y 3er elemento y muestra el resultado final.
          public static void vectorExample (Vector<String> vector){
                vector.remove(1);
                vector.remove(2);
              System.out.println(vector);
          }

          //5. Indica cuál es el problema de utilizar un Vector
    // con la capacidad por defecto si tuviésemos 1000 elementos
    //para ser añadidos al mismo.
    // Respuesta: Que es una operacion muy costosa en cuanto a recursos de memoria, porque cada vez
    // que sobrepasa el limite inicial debe crear nuevos arrays copiendo lo que hay en el anterior

    //6. Ver arriba

    // 7. Ver arriba

    // 8. Crea una función DividePorCero. Esta, debe generar una excepción ("throws")
    //    a su llamante del tipo ArithmeticException que será capturada por su llamante (desde "main", por ejemplo).
    //    Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
    //    Finalmente, mostraremos en cualquier caso: "Demo de código".
    public static void DividePorCero () throws ArithmeticException {
        System.out.println("Demo de Código");
        System.out.println("Introduce dos números");

        Scanner scanner = new Scanner(System.in);
        int numeroA = scanner.nextInt();
        int numeroB = scanner.nextInt();

        try { int z = numeroA / numeroB; } catch (Exception e) {
            System.out.println("Esto No Puede Hacerse");
        }
    }

    // 9. Utilizando InputStream y PrintStream,
    // crea una función que reciba dos parámetros: "fileIn" y "fileOut".
    // La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".
    public static void readAndCopy (String fileIn, String fileOut) throws FileNotFoundException {
        // Crear archivo y rellenarlo con algun texto random:
        PrintStream info = new PrintStream(fileIn);
        info.println("Hola Mundo");

        // Leer y copiar
        try {
            InputStream in = new FileInputStream(fileIn);
            byte []datos = in.readAllBytes();

            PrintStream out = new PrintStream(fileOut);
            out.write(datos);

        } catch (Exception e) {
            System.out.println("No se pudo encontrar el fichero " + e.getMessage());
        }

    }

    // 10. Sorpréndenos creando un programa de tu elección
    // que utilice InputStream, PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.

        public static void myFinalProgram() throws FileNotFoundException {

            LinkedList<String> enfermeras = new LinkedList<String>();
            enfermeras.add("Paula");
            enfermeras.add("Maria");
            enfermeras.add("Ainhoa");
            enfermeras.add("Rebeca");
            enfermeras.add("Marta");

            HashMap<String, String> enfermerasDepartamentos = new HashMap<String, String>();
            enfermerasDepartamentos.put("Paula", "Traumatología");
            enfermerasDepartamentos.put("Maria", "Radioterapia");
            enfermerasDepartamentos.put("Ainhoa", "Digestivo");
            enfermerasDepartamentos.put("Rebeca", "Urgencias");
            enfermerasDepartamentos.put("Marta", "Rehabilitación");

            // Obtener el departamento al que pertenece la primera enfemera de la lista
            System.out.println(enfermerasDepartamentos.get(enfermeras.getFirst()));

            // Añadir la ultima enfermera que ha entrado en el Hospital a un departamento
            enfermerasDepartamentos.put(enfermeras.getLast(), "Urgencias");

            // Crear archivo de texto con la lista de enfemeras
            PrintStream info = new PrintStream("listaEnfermeras.txt");
            for(int i=0, max=enfermeras.size(); i<max; i++) {
                info.println(enfermeras.get(i));
            }

            try {
                InputStream in = new FileInputStream("listaEnfermeras.txt");
                byte []datos = in.readAllBytes();

                PrintStream out = new PrintStream("listaActualizadaEnfermeras.txt");
                out.write(datos);

            } catch (Exception e) {
                System.out.println("No se pudo encontrar el fichero " + e.getMessage());
            }

        }

}

