package com.alura.challenge.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Historico {
    private LocalDateTime fechaCoversion;
    private String monedaOrigen;
    private String monedaDestino;
    private Double valorOriginal;
    private Double valorConversion;
    private static ArrayList<Historico> bitacoraConsultas = new ArrayList<>();

    public Historico(LocalDateTime fechaCoversion, String monedaOrigen, String monedaDestino, Double valorOriginal, Double valorConversion) {
        this.fechaCoversion = fechaCoversion;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.valorOriginal = valorOriginal;
        this.valorConversion = valorConversion;
        bitacoraConsultas.add(this);
    }

    public Double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(Double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public static ArrayList<Historico> getBitacoraConsultas() {
        return bitacoraConsultas;
    }

    public static void setBitacoraConsultas(ArrayList<Historico> bitacoraConsultas) {
        Historico.bitacoraConsultas = bitacoraConsultas;
    }

    public LocalDateTime getFechaCoversion() {
        return fechaCoversion;
    }

    public void setFechaCoversion(LocalDateTime fechaCoversion) {
        this.fechaCoversion = fechaCoversion;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getValorConversion() {
        return valorConversion;
    }

    public void setValorConversion(double valorConversion) {
        this.valorConversion = valorConversion;
    }

    public static void impresionBitacora(){


        System.out.println("Fecha                        | Moneda Origen | Monto Origen       | Moneda Destino | Monto Conversion ");
        for (Historico historico:bitacoraConsultas){
            String valorOriginalFormato = String.format("%.4f",historico.getValorOriginal());
            String valorConversionFormato = String.format("%.4f", historico.getValorConversion());
            System.out.printf("%-29s| %-14s| %-19s| %-15s| %-17s \n", historico.getFechaCoversion(),historico.getMonedaOrigen(), valorOriginalFormato,historico.getMonedaDestino(), valorConversionFormato);
        }
    }
}
