package com.conversordemonedas.utilidades;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.conversordemonedas.modelos.Moneda;

public class ApiDivisas {

    public static String pedirDatos(String base, String destino) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/721b3a36b38f792abdd46a36/pair/"+base+"/"+destino;
        String json="";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();

        } catch (NumberFormatException e) {
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }
        return json;
    }
    public static Moneda obtenerMoneda(String json){
        Moneda moneda = new Moneda();
        Gson gson = new Gson();
        moneda = gson.fromJson(json, Moneda.class);
        return  moneda;
    }

}
