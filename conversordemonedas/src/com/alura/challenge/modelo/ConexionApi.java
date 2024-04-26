package com.alura.challenge.modelo;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConexionApi {
    public Double respuestaApi(String buscarMoneda) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/e64be9bcfee3b5fcae99f98f/latest/USD"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();

        TipoOmdb tipoDeCambio = gson.fromJson(json, TipoOmdb.class);
        TipoOmdb tipoDeCambioCase = tipoDeCambio.conLowerCaseKey();

        TipoDeCambio miTipo = new TipoDeCambio(tipoDeCambioCase);

        Double valorMonedaBusqueda = miTipo.getValorTipoDeCambio().get(buscarMoneda.toLowerCase());
        return valorMonedaBusqueda;
    }
}
