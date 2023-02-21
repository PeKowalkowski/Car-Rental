package com.example.carRental.mappers;

import com.example.carRental.dtos.BranchDto;
import com.example.carRental.entities.Branch;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BranchMapperImpl implements Mapper<Branch, BranchDto> {

    private ModelMapper modelMapper;

    public BranchMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BranchDto mapperEntityToDto(Branch branch) {
        BranchDto branchDto = modelMapper.map(branch, BranchDto.class);
        return branchDto;
    }

    @Override
    public Branch mapperDtoToEntity(BranchDto branchDto) {
        return new Branch(branchDto.getName(), branchDto.getBranchAddress());
    }
}
