package com.alura.challenge.modelo;

import java.io.IOException;

public class Conversion {
    String monedaOrigen;
    String moneda1;
    String moneda2;
    String valorBase = "USD";
    Double valor;

    public Double conversionMoneda (String moneda1, String moneda2,Double valor) throws IOException, InterruptedException {

            ConexionApi respuesta = new ConexionApi();
            Double valorOrigen = respuesta.respuestaApi(moneda1);
            Double respuestaTipoDeCambio = respuesta.respuestaApi(moneda2);
            Double valorBase1 = respuesta.respuestaApi(valorBase);

            Double valor1 = ((valor*1)/valorOrigen);
            Double valorNuevo = ((valor1 * respuestaTipoDeCambio)/valorBase1);
            return valorNuevo;
    }
}
