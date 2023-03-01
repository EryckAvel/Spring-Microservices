package com.eryckavel.ms.email.model;

import com.eryckavel.ms.email.model.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String refpropietario;
    private String emailorigem;
    private String emaildestino;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String texto;
    private LocalDateTime enviodoemail;
    private StatusEmail statusemail;
}
