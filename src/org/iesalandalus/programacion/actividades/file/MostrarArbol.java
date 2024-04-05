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
            String[] listaCarpetas = entrada.list();
            if (listaCarpetas != null) {
                for (String nombreCarpetaPadre : listaCarpetas) {
                    File carpeta = new File(entrada, nombreCarpetaPadre);
                    System.out.println(nombreCarpetaPadre);
                    if (carpeta.isDirectory()) {
                        String[] listaCarpetasHijas = carpeta.list();
                        if(listaCarpetasHijas != null){
                            for(String nombreCarpetaHija : listaCarpetasHijas){
                                File carpetaHija = new File(nombreCarpetaHija);
                                System.out.println("    " + nombreCarpetaHija);
                            }
                        }
                    }
                }
            }
        }
    }
}