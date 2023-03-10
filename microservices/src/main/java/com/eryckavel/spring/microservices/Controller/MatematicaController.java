package com.eryckavel.spring.microservices.Controller;

import com.eryckavel.spring.microservices.exception.UnsuportedMathOperationException;
import com.eryckavel.spring.microservices.service.MatematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matematica")
public class MatematicaController {

    @Autowired
    MatematicaService service;

    @GetMapping("/soma/{numeroum}/{numerodois}")
    public Double soma(@PathVariable("numeroum") String numeroum,
                       @PathVariable("numerodois") String numerodois) throws Exception {
        if (!service.isNumeric(numeroum) || !service.isNumeric(numerodois)){
            throw new UnsuportedMathOperationException("Porfavor insira um valor numerico!");
        }
        Double soma = service.convertToDouble(numeroum) + service.convertToDouble(numerodois);
        return soma;
    }

    @GetMapping("/sub/{numeroum}/{numerodois}")
    public Double subtracao(@PathVariable("numeroum") String numeroum,
                       @PathVariable("numerodois") String numerodois) throws Exception {
        if (!service.isNumeric(numeroum) || !service.isNumeric(numerodois)){
            throw new UnsuportedMathOperationException("Porfavor insira um valor numerico!");
        }
        Double sub = service.convertToDouble(numeroum) - service.convertToDouble(numerodois);
        return sub;
    }

    @GetMapping("/multi/{numeroum}/{numerodois}")
    public Double multiplicacao(@PathVariable("numeroum") String numeroum,
                       @PathVariable("numerodois") String numerodois) throws Exception {
        if (!service.isNumeric(numeroum) || !service.isNumeric(numerodois)){
            throw new UnsuportedMathOperationException("Porfavor insira um valor numerico!");
        }
        Double multi = service.convertToDouble(numeroum) * service.convertToDouble(numerodois);
        return multi;
    }

    @GetMapping("/divi/{numeroum}/{numerodois}")
    public Double divisao(@PathVariable("numeroum") String numeroum,
                       @PathVariable("numerodois") String numerodois) throws Exception {
        if (!service.isNumeric(numeroum) || !service.isNumeric(numerodois)){
            throw new UnsuportedMathOperationException("Porfavor insira um valor numerico!");
        }
        Double div = service.convertToDouble(numeroum) / service.convertToDouble(numerodois);
        return div;
    }

    @GetMapping("/med/{numeroum}/{numerodois}")
    public Double media(@PathVariable("numeroum") String numeroum,
                          @PathVariable("numerodois") String numerodois) throws Exception {
        if (!service.isNumeric(numeroum) || !service.isNumeric(numerodois)){
            throw new UnsuportedMathOperationException("Porfavor insira um valor numerico!");
        }
        Double med = (service.convertToDouble(numeroum) + service.convertToDouble(numerodois))/2;
        return med;
    }

    @GetMapping("/raiz/{numero}")
    public Double raizQuadrada(@PathVariable("numero") String numero) throws Exception {
        if (!service.isNumeric(numero)){
            throw new UnsuportedMathOperationException("Porfavor insira um valor numerico!");
        }
        Double raiz = Math.sqrt(service.convertToDouble(numero));
        return raiz;
    }


}
