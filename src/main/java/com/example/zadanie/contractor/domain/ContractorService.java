package com.example.zadanie.contractor.domain;

import com.example.zadanie.contractor.exception.ContractorNotFoundException;
import com.example.zadanie.contractor.model.ContractorDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.MessageUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContractorService {
    private final ContractorRepository contractorRepository;

    public List<ContractorDto> getContractors() {
        log.info("Pobrano wszystkich kontrahentów info");
        return contractorRepository.findAllProjectedBy();
    }

    public ContractorDto getContractorById(Integer contractorId) {
        Optional<Contractor> optionalContractor = contractorRepository.findById(contractorId);
        ContractorDto contractorDto = optionalContractor.map(
                contractor -> newResponseContractor(optionalContractor.get())
        )
                .orElseThrow(ContractorNotFoundException::new);
        log.info(String.format("Pobrano kontrahenta o ID [%d]", contractorId));
        return contractorDto;
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
        log.info(String.format("Dodano nowego kontrahenta [%1$s] [%2$s] [%3$s] [%4$s] [%5$s] [%6$s]", contractor.getName(), contractor.getAdress()
                , contractor.getCountry(), contractor.getNip(), contractor.getCity(), contractor.getPostalCode()));
        return newResponseContractor(contractorRepository.save(contractor));
    }

    public void deleteContractor(int contractorId) {
        log.info(String.format("Usunięto kontrahenta o ID [%d]", contractorId));
        contractorRepository.deleteById(contractorId);
    }

    public void setContractorNameById(int contractorId, String name) {
        log.info(String.format("Zakutlizowano nazwę kontrahenta o ID [%d] na [%s]", contractorId, name));
        contractorRepository.setContractorNameById(contractorId, name);
    }

    private ContractorDto newResponseContractor(Contractor contractor) {
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

