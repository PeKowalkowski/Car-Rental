package com.example.carRental.mappers;

import com.example.carRental.dtos.BranchDto;
import com.example.carRental.entities.Branch;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchMapperImpl implements Mapper<Branch, BranchDto> {

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public BranchDto mapperEntityToDto(Branch branch) {
        BranchDto branchDto = modelMapper.map(branch, BranchDto.class);
        return branchDto;
    }

    @Override
    public Branch mapperDtoToEntity(BranchDto branchDto) {
        return new Branch(branchDto.getName());
    }
}
