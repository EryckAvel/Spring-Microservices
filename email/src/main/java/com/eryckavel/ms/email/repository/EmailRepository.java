package com.eryckavel.ms.email.repository;

import com.eryckavel.ms.email.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}