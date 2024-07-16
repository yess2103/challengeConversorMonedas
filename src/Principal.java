import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        Consulta consulta = new Consulta();
        Gson gson = new Gson();

        while (true) {

            System.out.println("""
                *****************************************************
                Bienvenido al Conversor de Monedas
                
                Elija la opcion que mas le agrade:
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real bresileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                
                *****************************************************
                """);
            int inputUsuario = teclado.nextInt();

            if (inputUsuario == 7) {
                break;

            } else if (inputUsuario > 7) {
                System.out.println("Por favor, elige una opción válida.");

            } else {
                String json = consulta.consultar(inputUsuario);

                ConversionRates conversionRates = gson.fromJson(json,ConversionRates.class);

                System.out.println("Ingresa el valor que desees convertir:");
                double valor = teclado.nextDouble();
                Calculos calculos = new Calculos();

                if (inputUsuario == 1) {
                    Double rate = conversionRates.conversion_rates().get("ARS");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[USD] equivale a: " + nuevoValor + "[ARS]");

                } else if (inputUsuario == 2) {
                    Double rate = conversionRates.conversion_rates().get("USD");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[ARS] equivale a: " + nuevoValor + "[USD]");

                } else if (inputUsuario == 3) {
                    Double rate = conversionRates.conversion_rates().get("BRL");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[USD] equivale a: " + nuevoValor + "[BRL]");

                } else if (inputUsuario == 4) {
                    Double rate = conversionRates.conversion_rates().get("USD");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[BRL] equivale a: " + nuevoValor + "[USD]");

                } else if (inputUsuario == 5) {
                    Double rate = conversionRates.conversion_rates().get("COP");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[USD] equivale a: " + nuevoValor + "[COP]");

                } else if (inputUsuario == 6) {
                    Double rate = conversionRates.conversion_rates().get("USD");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[COP] equivale a: " + nuevoValor + "[USD]");
                }
            }
        }
        System.out.println("""
                ***********************************************
                Gracias por usar el Conversor de Monedas
                ***********************************************
                """);
    }
}
