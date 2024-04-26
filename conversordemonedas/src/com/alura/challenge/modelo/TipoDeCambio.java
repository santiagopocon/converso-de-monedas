package com.alura.challenge.modelo;

import java.util.HashMap;

public class TipoDeCambio {
        private String conexion;
        private String fechaActualizacion;
        private String baseTipoDeCambio;
        private HashMap<String, Double> valorTipoDeCambio;

    public TipoDeCambio(TipoOmdb tipoDeCambio) {
        this.conexion = tipoDeCambio.result();
        this.fechaActualizacion = tipoDeCambio.time_next_update_utc();
        this.baseTipoDeCambio = tipoDeCambio.base_code();
        this.valorTipoDeCambio = tipoDeCambio.conversion_rates();
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getBaseTipoDeCambio() {
        return baseTipoDeCambio;
    }

    public void setBaseTipoDeCambio(String baseTipoDeCambio) {
        this.baseTipoDeCambio = baseTipoDeCambio;
    }

    public HashMap<String, Double> getValorTipoDeCambio() {
        return valorTipoDeCambio;
    }

    public void setValorTipoDeCambio(HashMap<String, Double> valorTipoDeCambio) {
        this.valorTipoDeCambio = valorTipoDeCambio;
    }

    @Override
    public String toString() {
        return "Lista de tipos de cambio: " + valorTipoDeCambio;
    }
}
