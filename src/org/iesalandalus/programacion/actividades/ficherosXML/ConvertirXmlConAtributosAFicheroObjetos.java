package org.iesalandalus.programacion.actividades.ficherosXML;

import org.iesalandalus.programacion.UtilidadesXml;
import org.iesalandalus.programacion.actividades.serializacionObjetos.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.List;

public class ConvertirXmlConAtributosAFicheroObjetos {
    /*Escribir un programa en java que lea un fichero XML con datos sobre una persona
     que almacena los valores en atributos y los escriba como un fichero de objetos.*/
    private static final String FICHERO_OBJETOS = String.format("%s%s%s","ficheros", File.separator, "personas.dat");
    private static final String FICHERO_XML = String.format("%s%s%s", "ficheros", File.separator, "personasAtributos.xml");

    public static void main(String[] args) {
        Document documentoXml = UtilidadesXml.leerDocumentoXml(FICHERO_XML);
        if (documentoXml != null) {
            System.out.println("Fichero XML leído correctamente.");
            escribirXmlConAtributosAFicheroObjetos(documentoXml);
        }
    }

    private static void escribirXmlConAtributosAFicheroObjetos(Document documentoXml)  {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_OBJETOS))){
            NodeList personas = documentoXml.getElementsByTagName("persona");
            for (int i = 0; i < personas.getLength(); i++) {
                Node persona = personas.item(i);
                if (persona.getNodeType() == Node.ELEMENT_NODE) {
                    String nombre = ((Element)persona).getAttribute("nombre");
                    int edad = Integer.parseInt(((Element)persona).getAttribute("edad"));
                    salida.writeObject(new Persona(nombre, edad));
                }
            }
            System.out.println("Fichero escrito satisfactoriamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No puedo crear el fichero de salida.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
