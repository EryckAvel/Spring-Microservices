package com.eryckavel.spring.microservices.service;

import org.springframework.stereotype.Service;

@Service
public class MatematicaService {

    public Double convertToDouble(String strnumero) {
        if (strnumero == null) return 0D;
        String numero = strnumero.replaceAll(",", ".");
        if (isNumeric(numero)) return Double.parseDouble(numero);
        return 0D;
    }

    public boolean isNumeric(String strnumero) {
        if (strnumero == null) return false;
        String numero = strnumero.replaceAll(",", ".");
        return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
