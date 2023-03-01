package com.eryckavel.ms.email.controller;

import com.eryckavel.ms.email.dto.EmailDTO;
import com.eryckavel.ms.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService service;

    @PostMapping("/enviar")
    public ResponseEntity<EmailDTO> enviarEmail(@RequestBody @Valid EmailDTO dto){
        return service.enviarEmail(dto);
    }


}
