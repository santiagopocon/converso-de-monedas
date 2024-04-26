package com.alura.challenge.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record TipoOmdb(String result, String time_next_update_utc, String base_code, HashMap<String, Double> conversion_rates) {

    public TipoOmdb conLowerCaseKey(){
        HashMap<String, Double> nuevaConversionRates =new HashMap<>();
        for (Map.Entry<String, Double> entry: this.conversion_rates.entrySet()){
            nuevaConversionRates.put(entry.getKey().toLowerCase(),entry.getValue());
        }
        return new TipoOmdb(this.result, this.time_next_update_utc,this.base_code,nuevaConversionRates);
    }

}
