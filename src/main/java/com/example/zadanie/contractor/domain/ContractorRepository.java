package com.example.zadanie.contractor.domain;

import com.example.zadanie.contractor.model.ContractorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Integer> {

//    Optional<ContractorDto> findByContractorId(int contractorId);
    void deleteById(Integer contractorId);

    List<ContractorDto> findAllProjectedBy();
}
