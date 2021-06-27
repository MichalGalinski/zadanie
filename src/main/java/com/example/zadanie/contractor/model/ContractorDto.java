package com.example.zadanie.contractor.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ContractorDto {
    private String name;
    private String nip;
    private String adress;
    private String postalCode;
    private String city;
    private String country;
}
