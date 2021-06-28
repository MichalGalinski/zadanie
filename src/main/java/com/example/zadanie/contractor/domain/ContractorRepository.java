package com.example.zadanie.contractor.domain;

import com.example.zadanie.contractor.model.ContractorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Integer> {

//    Optional<ContractorDto> findByContractorId(int contractorId);

    @Modifying
    @Query(value = "update kontrahent set nazwa = :name WHERE id = :contractorId", nativeQuery = true)
    void setContractorNameById(Integer contractorId,  String name);

    void deleteById(Integer contractorId);

    List<ContractorDto> findAllProjectedBy();
}
