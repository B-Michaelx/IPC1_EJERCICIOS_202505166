
package com.mycompany.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ejercicio2 {

    private static final String TEXTO = 
        "UNIVERSIDAD DE SAN CARLOS DE GUATEMALA\n" +
        "Facultad de Ingeniería — Boletín Informativo 2024-04-25\n" +
        "Actividades programadas:\n" +
        "- Conferencia el 2024-05-01 a las 10:30 en el Edificio T3\n" +
        "- Examen parcial el 2024-05-15 a las 08:00 en el Edificio S11\n" +
        "- Defensa de proyecto el 2024-06-10 a las 14:30 en el Edificio T7\n" +
        "Contactos del departamento:\n" +
        "- Coordinador: coord.ipc1@ingenieria.usac.edu.gt Tel: 2418-8000\n" +
        "- Auxiliar 1: aux01_ipc1@ingenieria.usac.edu.gt Tel: 5555-1234\n" +
        "- Auxiliar 2: aux02.ipc1@gmail.com Tel: 4321-9876";

    public static void extraerFechas() {
        System.out.println("=== Fechas Encontradas ===");
        String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(TEXTO);

        while (matcher.find()) {
            System.out.println("Anio: " + matcher.group(1) + " | Mes: " + matcher.group(2) + " | Dia: " + matcher.group(3));
        }
        System.out.println();
    }

    
    public static void extraerCorreos() {
        System.out.println("=== Correos Encontrados ===");
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(TEXTO);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println();
    }

    public static String censurarDatosSensibles(String texto) {
        String resultado = texto;

        String regexCorreo = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern patternCorreo = Pattern.compile(regexCorreo);
        Matcher matcherCorreo = patternCorreo.matcher(resultado);
        resultado = matcherCorreo.replaceAll("[CORREO]");

        String regexTelefono = "\\d{4}-\\d{4}";
        Pattern patternTelefono = Pattern.compile(regexTelefono);
        Matcher matcherTelefono = patternTelefono.matcher(resultado);
        resultado = matcherTelefono.replaceAll("[TEL]");

        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("=== Extractor y Transformador de Texto ===");

        extraerFechas();
        extraerCorreos();

        System.out.println("=== Censuras de Datos Sensibles ===");
        System.out.println("Prueba 1");
        String ejemplo1 = "Llama a 5555-1234 o escribe a juan@usac.edu.gt para mas info.";
        System.out.println("Original: " + ejemplo1);
        System.out.println("Censurado: " + censurarDatosSensibles(ejemplo1));
        
        System.out.println("Prueba 2");
        String ejemplo2 = "Contacta a pedro@gmail.com o llama al 1234-5678";
        System.out.println("Original: " + ejemplo2);
        System.out.println("Censurado: " + censurarDatosSensibles(ejemplo2));
        
        System.out.println("Prueba 3");
        String ejemplo3 = "Texto normal sin datos sensibles";
        System.out.println("Original: " + ejemplo3);
        System.out.println("Censurado: " + censurarDatosSensibles(ejemplo3));
    }
}