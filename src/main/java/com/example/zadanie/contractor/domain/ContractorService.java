package com.example.zadanie.contractor.domain;

import com.example.zadanie.contractor.model.ContractorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractorService {
    private final ContractorRepository contractorRepository;

    public List<ContractorDto> getContractors() {
        return contractorRepository.findAllProjectedBy();
    }

    public ContractorDto createContractor(ContractorDto contractorDto) {
        Contractor contractor = Contractor.builder()
                .id(0)
                .city(contractorDto.getCity())
                .country(contractorDto.getCountry())
                .name(contractorDto.getName())
                .nip(contractorDto.getNip())
                .postalCode(contractorDto.getAdress())
                .adress(contractorDto.getAdress())
                .creationDate(LocalDateTime.now())
                .versionDate(LocalDateTime.now())
                .build();
        ContractorDto contractorDtoReturn = newResponse(contractorRepository.save(contractor));
        return (contractorDtoReturn);
    }

    public void deleteContractor(int contractorId) {
        contractorRepository.deleteById(contractorId);
    }

//    public Optional<ContractorDto> getContractorById(int contractorId) {
//        return contractorRepository.findByContractorId(contractorId);
//                //.map(this::newResponse);
//    }

    private ContractorDto newResponse(Contractor contractor){
        return ContractorDto.builder()
                .adress(contractor.getAdress())
                .city(contractor.getCity())
                .name(contractor.getName())
                .country(contractor.getCountry())
                .nip(contractor.getNip())
                .postalCode(contractor.getPostalCode())
                .build();
    }
}

