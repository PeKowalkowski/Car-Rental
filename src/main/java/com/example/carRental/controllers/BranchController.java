package com.example.carRental.controllers;

import com.example.carRental.dtos.BranchDto;
import com.example.carRental.entities.Branch;
import com.example.carRental.entities.CarRental;
import com.example.carRental.repositories.BranchRepository;
import com.example.carRental.repositories.CarRentalRepository;
import com.example.carRental.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/branches")
public class BranchController {


    @Autowired
    private BranchService branchService;

    @Autowired
    private CarRentalRepository carRentalRepository;

    @Autowired
    private BranchRepository branchRepository;

    public BranchController(BranchService branchService, CarRentalRepository carRentalRepository,
                            BranchRepository branchRepository) {
        this.branchService = branchService;
        this.carRentalRepository = carRentalRepository;
        this.branchRepository = branchRepository;
    }

    @PostMapping
    ResponseEntity<BranchDto> addBranch(@RequestBody BranchDto branchDto){
        BranchDto branchDto1 = branchService.addBranch(branchDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(branchDto1);

    }
    @GetMapping
    ResponseEntity<List<BranchDto>> getBranches(){
        List<BranchDto> branchDtoList = branchService.getBranches();
        return ResponseEntity.ok(branchDtoList);
    }
    @GetMapping("/{id}")
    ResponseEntity<Optional<Branch>> getById(@PathVariable Long id){
        Optional<Branch> branch = branchService.findById(id);
        return ResponseEntity.ok(branch);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBranchById(@PathVariable Long id){
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    ResponseEntity<Void> updateBranchById(@PathVariable Long id, @RequestBody BranchDto branchDto){
        branchService.updateBranchById(id, branchDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{branchId}/carRental/{carRentalId}")
    private Branch addBranchToCarRental(@PathVariable Long carRentalId, @PathVariable Long branchId){
        Branch branch1 = branchRepository.findById(branchId).get();
        CarRental carRental1 = carRentalRepository.findById(carRentalId).get();

        branch1.setCarRental(carRental1);
        return branchRepository.save(branch1);
    }


}
