package com.alianza.clients.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id", nullable = false)
    private long id;

    @NotBlank
    @Column(name = "shared_key", unique = true, length = 10, nullable = false)
    private String sharedKey;

    @NotBlank
    @Column(name = "business_id", length = 20, nullable = false)
    private String businessId;

    @Email
    @Column(name = "email", unique = true, length = 100, nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private long phone;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "date_added", nullable = false)
    private LocalDate dataAdded;
}
