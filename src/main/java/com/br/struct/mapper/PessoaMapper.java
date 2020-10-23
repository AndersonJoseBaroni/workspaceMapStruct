package com.br.struct.mapper;

import java.util.Date;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.br.struct.dto.PessoaDto;
import com.br.struct.entity.Pessoa;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    //@Mapping(source = "nome", target = "nomePessoa")
    Pessoa toModel(PessoaDto pessoaDTO);

    //@Mapping(source = "nomePessoa", target = "nome")
    PessoaDto toDTO(Pessoa pessoa);
    
    List<PessoaDto> toDTOs(List<Pessoa> pessoas);
    
    void updateCarFromDto(PessoaDto pessoaDTO, @MappingTarget Pessoa pessoa);
 
    @IterableMapping(dateFormat = "dd-MM-yyyy")
    List<String> stringListToDateList(List<Date> dates);
}
