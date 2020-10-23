package com.br.struct.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {

	 private Long id;

	
	 private String descEnderecoDto;
	 
	 
	 private Long numEnderecoDto;
}
