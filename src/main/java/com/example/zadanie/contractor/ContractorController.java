package com.example.zadanie.contractor;

import com.example.zadanie.contractor.domain.Contractor;
import com.example.zadanie.contractor.domain.ContractorService;
import com.example.zadanie.contractor.model.ContractorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contractor")
@RequiredArgsConstructor
public class ContractorController {
    private final ContractorService contractorService;

    @GetMapping("/getContractors")
    public ResponseEntity<List<ContractorDto>> findAll() {
        return ResponseEntity.ok(contractorService.getContractors());
    }

    @PostMapping("/createContractor")
    public ResponseEntity<ContractorDto> createContractor(@RequestBody final ContractorDto contractorDto){
        contractorService.createContractor(contractorDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteContractor")
    public ResponseEntity<ContractorDto> deleteContractor(@RequestParam int contractorId){
        contractorService.deleteContractor(contractorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/setContractorNameById")
    public ResponseEntity<ContractorDto> setContractorNameById(@RequestParam int contractorId, @RequestParam String name){
        contractorService.setContractorNameById(contractorId, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getContractorById")
    public ResponseEntity<ContractorDto> getContractorById(@RequestParam int contractorId) {
        return  ResponseEntity.ok(contractorService.getContractorById(contractorId));
    }
}
