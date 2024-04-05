package org.iesalandalus.programacion.actividades.file;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.File;
import java.io.FileNotFoundException;

/*Escribir un programa en java que muestre por pantalla el árbol de contenidos de la carpeta actual.*/
public class MostrarArbol {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Dime el nombre del directorio: ");
        String mensaje = Entrada.cadena();
        File entrada = new File(mensaje);
        if (entrada.exists() && entrada.isDirectory()) {
            mostrarArbol(entrada, "");
        }else{
            throw new FileNotFoundException("No se ha encontrado el directorio o este no lo es.");
        }
    }

    private static void mostrarArbol(File carpeta, String espacio) {
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                if (i == archivos.length - 1) {
                    System.out.println(espacio + "└── " + archivos[i].getName());
                    /*https://www.asciitable.com/*/
                } else {
                    System.out.println(espacio + "├── " + archivos[i].getName());
                }
                if (archivos[i].isDirectory()) {
                    String nuevoEspacio;
                    if (i == archivos.length - 1) {
                        nuevoEspacio = espacio + "    ";
                    } else {
                        nuevoEspacio = espacio + "│   ";
                    }
                    mostrarArbol(archivos[i], nuevoEspacio);
                }
            }
        }
    }
}
