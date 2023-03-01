package com.eryckavel.ms.email.dto;

import com.eryckavel.ms.email.model.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EmailDTO {

    @NotBlank(message = "Necessario a referencia de propietario!")
    private String refpropietario;
    @NotBlank(message = "Nessesario email de origem!")
    private String emailorigem;
    @NotBlank(message = "Necessario email do destinatario")
    private String emaildestino;
    @NotBlank(message = "Necessario preencher o titulo do email")
    private String titulo;
    @NotBlank(message = "Necessairio preencher o corpo do email!")
    private String texto;
    private LocalDateTime enviodoemail;
    private String statusemail;

    public EmailDTO(Email email){
        refpropietario = email.getRefpropietario();
        emailorigem = email.getEmailorigem();
        emaildestino = email.getEmaildestino();
        titulo = email.getTitulo();
        texto = email.getTexto();
        enviodoemail = email.getEnviodoemail();
        statusemail = email.getStatusemail().toString();
    }

}
