package com.example.carRental.servicesImpl;

import com.example.carRental.dtos.BranchDto;
import com.example.carRental.dtos.CarRentalDto;
import com.example.carRental.entities.Address;
import com.example.carRental.entities.Branch;
import com.example.carRental.entities.CarRental;
import com.example.carRental.repositories.BranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl /*implements DefaultService<Branch>*/ {

    @Autowired
    private BranchRepository branchRepository;

    private static ModelMapper modelMapper;



    public BranchDto addBranch(BranchDto branchDto) {
        Branch branch = mapperToBranch(branchDto);
        Branch branchOut = branchRepository.save(branch);
        return mapBranchToBranchDto(branchOut);
    }

    private BranchDto mapBranchToBranchDto(Branch branch) {
        BranchDto branchDto = modelMapper.map(branch, BranchDto.class);
        return branchDto;
    }

    private Branch mapperToBranch(BranchDto branchDto) {
        return new Branch(branchDto.getName(), branchDto.getCarDtoList());
    }

    public List<BranchDto> getBranches() {
        List<BranchDto> branchDtoList = branchRepository.findAll()
                .stream().map(branch -> {
                    BranchDto branchDto = new BranchDto(branch.getId(), branch.getName(), branch.getCarRental());
                    return branchDto;
                })
                .collect(Collectors.toList());
        return branchDtoList;
    }

    public Optional<Branch> findById(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        return branch;
    }

    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    public void updateBranchById(Long id, BranchDto branchDto) {
        Branch branch = new Branch(id, branchDto.getName());
        branchRepository.save(branch);
    }
}
