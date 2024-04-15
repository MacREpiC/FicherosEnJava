package org.iesalandalus.programacion.actividades.ficherosxml;

import org.iesalandalus.programacion.UtilidadesXml;
import org.iesalandalus.programacion.actividades.serializacionObjetos.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;

public class ConvertirXmlConElementosAFicheroObjetos {
    /*Escribir un programa en java que lea un fichero XML con datos sobre una
    persona que almacena los valores en elementos y los escriba como un fichero de objetos.*/
    private static final String FICHERO_OBJETOS = String.format("%s%s%s","ficheros", File.separator, "personas.dat");
    private static final String FICHERO_XML_ELEMENTOS = String.format("%s%s%s", "ficheros", File.separator, "personasElementos.xml");

    public static void main(String[] args) {
        Document documentoXml = UtilidadesXml.leerDocumentoXml(FICHERO_XML_ELEMENTOS);
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
                    String nombre = ((Element)persona).getElementsByTagName("nombre").item(0).getTextContent();
                    int edad = Integer.parseInt(((Element)persona).getElementsByTagName("edad").item(0).getTextContent());
                    salida.writeObject(new Persona(nombre, edad));
                }
            }
            System.out.println("Fichero escrito satisfactoriamente.");
        } catch (IOException e) {
            System.out.printf("No se ha podido escribir el fichero %s.%n", FICHERO_OBJETOS);
        }
    }
}
