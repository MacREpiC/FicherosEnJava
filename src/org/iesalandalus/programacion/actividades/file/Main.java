package org.iesalandalus.programacion.actividades.file;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Especifica la ruta de la carpeta
        String rutaCarpeta = "C:\\Users\\brosg\\IdeaProjects\\Ficheros_en_Java\\out";

        // Crea un objeto File que representa la carpeta
        File carpeta = new File(rutaCarpeta);

        // Verifica si la ruta especificada es una carpeta
        if (carpeta.isDirectory()) {
            // Obtiene la lista de archivos y subdirectorios en la carpeta
            String[] contenidoCarpeta = carpeta.list();

            // Muestra el contenido de la carpeta en la consola
            if (contenidoCarpeta != null) {
                for (String nombreArchivo : contenidoCarpeta) {
                    System.out.println(nombreArchivo);
                }
            } else {
                System.out.println("La carpeta está vacía.");
            }
        } else {
            System.out.println("La ruta especificada no es una carpeta.");
        }
    }
}
