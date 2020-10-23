package com.br.struct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.struct.dto.EnderecoDto;
import com.br.struct.dto.EnderecoEntregaDto;
import com.br.struct.dto.PessoaDto;
import com.br.struct.dto.PessoaEnderecoDto;
import com.br.struct.entity.EnderecoEntrega;
import com.br.struct.entity.Pessoa;
import com.br.struct.mapper.EnderecoMapper;
import com.br.struct.mapper.PessoaMapper;
import com.br.struct.repository.EnderecoEntregaRepository;
import com.br.struct.repository.PessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {
	
	private final PessoaRepository pessoaRepository;
	
	private final EnderecoEntregaRepository enderecoEntregaRepository;
	
	private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;
	
	private final EnderecoMapper entregaMapper = EnderecoMapper.INSTANCE;
	
	public PessoaDto createPessoa(PessoaDto pessoaDto) {
		// Preciso converter para Entidade na inserção
		Pessoa pessoa = pessoaMapper.toModel(pessoaDto);
		// salvando o objeto
		Pessoa pessoaSave = pessoaRepository.save(pessoa);
		// No return converter para dto
		return pessoaMapper.toDTO(pessoaSave);
		
	}
	
	public List<PessoaDto> findAllPessoa(){
	    
		List<PessoaDto> listDto = pessoaMapper.toDTOs(pessoaRepository.findAll());
		
		return 	listDto;
	}
	
	public EnderecoEntregaDto createEntrega(PessoaEnderecoDto pessoaEnderecoDto) {
		// converter para Entidade de entrega
		EnderecoEntrega enderecoEntrega = entregaMapper.pessoaAndEnderecoToEnderecoEntrega(pessoaEnderecoDto.getPessoa(), pessoaEnderecoDto.getEndereco());
		// salvando o objeto
		EnderecoEntrega enderecoEntregaSave = enderecoEntregaRepository.save(enderecoEntrega);
		// No return converter para dto
		return entregaMapper.toDTO(enderecoEntregaSave);
		
	}
}
