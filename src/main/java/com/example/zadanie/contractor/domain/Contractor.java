package com.example.zadanie.contractor.domain;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Table(name="KONTRAHENT")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kontrahent_seq_gen")
    @SequenceGenerator(name = "kontrahent_seq_gen", sequenceName = "kontrahent_id_seq", allocationSize = 1)
    @Column(name="ID", nullable = false, unique = true)
    private Integer id;

    @Column(name="NAZWA", nullable = false)
    private String name;

    @Column(name="NIP", nullable = false)
    private String nip;

    @Column(name="ADRES", nullable = false)
    private String adress;

    @Column(name="KOD_POCZTOWY", nullable = false)
    private String postalCode;

    @Column(name="MIASTO", nullable = false)
    private String city;

    @Column(name="KRAJ", nullable = false)
    private String country;

    @Column(name="DATA_UTWORZENIA", nullable = false)
    private LocalDateTime creationDate;

    @Column(name="DATA_MODYFIKACJI", nullable = false)
    private LocalDateTime versionDate;

}
