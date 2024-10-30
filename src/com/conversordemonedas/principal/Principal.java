package com.conversordemonedas.principal;

import com.conversordemonedas.modelos.Moneda;
import com.conversordemonedas.utilidades.ApiDivisas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        int opcion = 0;
        Scanner lectura = new Scanner(System.in);

        try{
            while(opcion != 7){
                Moneda moneda;
                String datos;
                double valorAconvertir;
                double equivalente;
                System.out.println("""
                ****************************************
                MENU DE OPCIONES
                1. Dolar (USD) a Peso Colombiano (COP)
                2. Peso Colombiano (COP) a Dolar (USD)
                3. Dolar (USD) a Peso Argentino (ARS)
                4. Peso Argentino (ARS) a Dolar (USD)
                5. Dolar (USD) a Real Brasileño (BRL)
                6. Real Brasileño (BRL) a Dolar (USD)
                7. Salir
                Elija una opcion valida.
                ****************************************
                """);

                opcion = lectura.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Digite la cantidad que deseas convertir: ");
                        valorAconvertir = lectura.nextDouble();
                        datos = ApiDivisas.pedirDatos("USD", "COP");
                        equivalente = valorAconvertir*ApiDivisas.obtenerMoneda(datos).getConversion_rate();
                        System.out.println("El valor de " + valorAconvertir+" (USD) corresponde al valor final de " + equivalente+ " (COP)");
                        break;
                    case 2:
                        System.out.println("Digite la cantidad que deseas convertir: ");
                        valorAconvertir = lectura.nextDouble();
                        datos = ApiDivisas.pedirDatos("COP", "USD");
                        equivalente = valorAconvertir*ApiDivisas.obtenerMoneda(datos).getConversion_rate();
                        System.out.println("El valor de " + valorAconvertir+" (COP) corresponde al valor final de " + equivalente+ " (USD)");
                        break;
                    case 3:
                        System.out.println("Digite la cantidad que deseas convertir: ");
                        valorAconvertir = lectura.nextDouble();
                        datos = ApiDivisas.pedirDatos("USD", "ARS");
                        equivalente = valorAconvertir*ApiDivisas.obtenerMoneda(datos).getConversion_rate();
                        System.out.println("El valor de " + valorAconvertir+" (USD) corresponde al valor final de " + equivalente+ " (ARS)");
                        break;
                    case 4:
                        System.out.println("Digite la cantidad que deseas convertir: ");
                        valorAconvertir = lectura.nextDouble();
                        datos = ApiDivisas.pedirDatos("ARS", "USD");
                        equivalente = valorAconvertir*ApiDivisas.obtenerMoneda(datos).getConversion_rate();
                        System.out.println("El valor de " + valorAconvertir+" (ARS) corresponde al valor final de " + equivalente+ " (USD)");
                        break;
                    case 5:
                        System.out.println("Digite la cantidad que deseas convertir: ");
                        valorAconvertir = lectura.nextDouble();
                        datos = ApiDivisas.pedirDatos("USD", "BRL");
                        equivalente = valorAconvertir*ApiDivisas.obtenerMoneda(datos).getConversion_rate();
                        System.out.println("El valor de " + valorAconvertir+" (USD) corresponde al valor final de " + equivalente+ " (BRL)");
                        break;
                    case 6:
                        System.out.println("Digite la cantidad que deseas convertir: ");
                        valorAconvertir = lectura.nextDouble();
                        datos = ApiDivisas.pedirDatos("BRL", "USD");
                        equivalente = valorAconvertir*ApiDivisas.obtenerMoneda(datos).getConversion_rate();
                        System.out.println("El valor de " + valorAconvertir+" (BRL) corresponde al valor final de " + equivalente+ " (USD)");
                        break;
                    case 7:
                        System.out.println("Saliendo de la aplicacion...");
                        break;
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Opcion no valida, solo puede digitar numeros enteros");
        }
    }
}
