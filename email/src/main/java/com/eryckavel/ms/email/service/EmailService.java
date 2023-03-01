package com.eryckavel.ms.email.service;

import com.eryckavel.ms.email.dto.EmailDTO;
import com.eryckavel.ms.email.model.Email;
import com.eryckavel.ms.email.model.enums.StatusEmail;
import com.eryckavel.ms.email.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository repository;

    @Autowired
    private JavaMailSender sender;

    @Transactional
    public ResponseEntity<EmailDTO> enviarEmail(EmailDTO dto) {
        var email = new Email();
        copiarDTOparaEntidade(email, dto);
        email.setEnviodoemail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(dto.getEmaildestino());
            message.setFrom(dto.getEmailorigem());
            message.setSubject(dto.getTitulo());
            message.setText(dto.getTexto());
            sender.send(message);
            email.setStatusemail(StatusEmail.ENVIADO);
        }catch (MailException e){
            email.setStatusemail(StatusEmail.ERRO);
        }finally {
            email = repository.save(email);
            return ResponseEntity.status(HttpStatus.CREATED).body(new EmailDTO(email));
        }
    }

    public void copiarDTOparaEntidade(Email entidade, EmailDTO dto){
        entidade.setRefpropietario(dto.getRefpropietario());
        entidade.setEmailorigem(dto.getEmailorigem());
        entidade.setEmaildestino(dto.getEmaildestino());
        entidade.setTitulo(dto.getTitulo());
        entidade.setTexto(dto.getTexto());
    }

}
