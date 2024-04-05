package org.iesalandalus.programacion.actividades.file;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.LocalDate;

/*
Escribir un programa en java que muestre por pantalla las propiedades de
un fichero que pida por consola y si es un directorio debe mostrar
también su contenido. Este proceso lo repetirá mientras no introduzcamos
como nombre de fichero: FIN.
*/
public class MostrarPropiedades {
    public static void main(String[] args) throws FileNotFoundException {
        String mensaje;
        System.out.print("Dime el nombre del fichero o directorio: ");
        mensaje = Entrada.cadena();
        while(!mensaje.equals("FIN")){
            File entrada = new File(mensaje);
            if(!entrada.exists()){
                throw new FileNotFoundException("No se pudo encontrar el fichero o carpeta.");
            } else {
                if (entrada.isFile()) {
                    System.out.printf("%n%s es un fichero.%n--------------%n", entrada.getName());
                    if(entrada.isHidden()){
                        System.out.println("Oculto: " + true);
                    }else{
                        System.out.println("Oculto: " + false);
                    }
                    LocalDate ultimaModificacion = new Timestamp(entrada.lastModified()).toLocalDateTime().toLocalDate();
                    System.out.println("Tamaño: " + entrada.length() + " bytes.");
                    System.out.println("Última modificación: " +ultimaModificacion);
                } else{
                    System.out.printf("%n%s es una carpeta.%n--------------%n", entrada.getName());
                    if(entrada.isHidden()){
                        System.out.println("Oculto: " + true);
                    }else{
                        System.out.println("Oculto: " + false);
                    }

                    File[] listaCarpetas = entrada.listFiles();

                    if (listaCarpetas != null) {
                        mostrarArbol(entrada, "");
                    } else {
                        System.out.println("La carpeta está vacía.");
                    }
                    LocalDate ultimaModificacion = new Timestamp(entrada.lastModified()).toLocalDateTime().toLocalDate();
                    System.out.println("Tamaño: " + entrada.length() + " bytes.");
                    System.out.println("Última modificación: " +ultimaModificacion);
                    System.out.printf("%n-------------------------------------------------");

                }
            }
            System.out.printf("%nDime el nombre del fichero o directorio: ");
            mensaje = Entrada.cadena();
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
