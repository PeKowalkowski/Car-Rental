package com.example.carRental.services;


import com.example.carRental.dtos.BranchDto;
import com.example.carRental.entities.Branch;
import com.example.carRental.mappers.BranchMapperImpl;
import com.example.carRental.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService {

    private BranchRepository branchRepository;

    private BranchMapperImpl branchMapper;


    public BranchService(BranchRepository branchRepository, BranchMapperImpl branchMapper) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
    }

    public BranchDto addBranch(BranchDto branchDto) {
        Branch branch = branchMapper.mapperDtoToEntity(branchDto);
        Branch branchOut = branchRepository.save(branch);
        return branchMapper.mapperEntityToDto(branchOut);
    }


    public List<BranchDto> getBranches() {
        List<BranchDto> branchDtoList = branchRepository.findAll()
                .stream().map(branch -> {
                    BranchDto branchDto = new BranchDto(branch.getId(), branch.getName(), branch.getBranchAddress(),
                            branch.getCarRental());
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
        Branch branch = new Branch(id, branchDto.getName(), branchDto.getBranchAddress());
        branchRepository.save(branch);
    }

}
