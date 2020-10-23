package com.br.struct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.br.struct.dto.EnderecoDto;
import com.br.struct.dto.EnderecoEntregaDto;
import com.br.struct.dto.PessoaDto;
import com.br.struct.entity.EnderecoEntrega;
import com.br.struct.entity.Pessoa;

@Mapper
public interface EnderecoMapper {
	
	EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);
	
	@Mapping(source = "pessoaDto.nome", target = "nomePessoaEntrega")
	@Mapping(source = "enderecoDto.descEnderecoDto", target = "descEnderecoEntregaEntity")
    @Mapping(source = "enderecoDto.numEnderecoDto", target = "numEndEntregaEntity")
	@Mapping(target = "id", ignore = true)
	EnderecoEntrega pessoaAndEnderecoToEnderecoEntrega(PessoaDto pessoaDto, EnderecoDto enderecoDto);
	
	@Mapping(source = "descEnderecoEntregaEntity", target = "descEndEntregaDto")
	@Mapping(source = "numEndEntregaEntity", target = "numEndEntregaDto")
	EnderecoEntregaDto toDTO(EnderecoEntrega enderecoEntrega);
}
