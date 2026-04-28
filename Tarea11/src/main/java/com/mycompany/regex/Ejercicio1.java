package com.mycompany.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ejercicio1 {


    public static boolean validarCarnet(String carnet) {
        String regex = "^\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(carnet);
        return matcher.matches();
    }


    public static boolean validarCorreo(String correo) {
        String regex = "^[a-zA-Z0-9]+[a-zA-Z0-9._]*@usac\\.edu\\.gt$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static boolean validarTelefono(String telefono) {
        String regex = "^[3-6]\\d{3}-?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }

    public static String resultado(boolean esValido){
        if(esValido){
            return "Valido";
        }else{
            return "Invalido";
        }
    }
    
    
    
    public static void main(String[] args) {
        System.out.println("=== VALIDADOR DE DATOS ===");

        System.out.println("=== Carnet ===");
        System.out.println("202300123: " + resultado(validarCarnet("202300123")));
        System.out.println("202512345: " + resultado(validarCarnet("202512345")));
        System.out.println("20230012: " + resultado(validarCarnet("20230012")));
        System.out.println("2023ABC12: " + resultado(validarCarnet("2023ABC12")));

        System.out.println("=== Correo ===");
        System.out.println("juan.perez@usac.edu.gt: " + resultado(validarCorreo("juan.perez@usac.edu.gt")));
        System.out.println("carla_001@usac.edu.gt: " + resultado(validarCorreo("carla_001@usac.edu.gt")));
        System.out.println("juan@gmail.com: " + resultado(validarCorreo("juan@gmail.com")));
        System.out.println(".juan@usac.edu.gt: " + resultado(validarCorreo(".juan@usac.edu.gt")));

        System.out.println("===Telefono ===");
        System.out.println("5555-1234: " + resultado(validarTelefono("5555-1234")));
        System.out.println("30001234: " + resultado(validarTelefono("30001234")));
        System.out.println("1234-5678: " + resultado(validarTelefono("1234-5678")));
        System.out.println("555-1234: " + resultado(validarTelefono("555-1234")));
    }
}