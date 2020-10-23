package com.br.struct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntregaDto {
    
	private Long id;
	
	private String descEndEntregaDto;
	
	private Long numEndEntregaDto;
}
