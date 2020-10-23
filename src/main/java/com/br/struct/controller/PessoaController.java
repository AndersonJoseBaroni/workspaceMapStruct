package com.br.struct.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.br.struct.dto.EnderecoDto;
import com.br.struct.dto.EnderecoEntregaDto;
import com.br.struct.dto.PessoaDto;
import com.br.struct.dto.PessoaEnderecoDto;
import com.br.struct.mapper.PessoaMapper;
import com.br.struct.service.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

	private final PessoaService pessoaService;
	
	private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public PessoaDto createPessoa(@RequestBody @Valid PessoaDto pessoaDTO) {
        return pessoaService.createPessoa(pessoaDTO);
    }

	@GetMapping
    public List<PessoaDto> findAllPessoa() {
        return pessoaService.findAllPessoa();
    }
	
	@GetMapping("/dateParaStrin")
    public List<String> converterDateParaStrin(){
		List<Date> listDate = new ArrayList <Date> ();
		listDate.add(new Date());
		return pessoaMapper.stringListToDateList(listDate);
    }
	
	@PostMapping("/enderecoEntrega")
	@ResponseStatus(HttpStatus.CREATED)
    public EnderecoEntregaDto createEntrega(@RequestBody @Valid PessoaEnderecoDto pessoaEnderecoDto) {
        return pessoaService.createEntrega(pessoaEnderecoDto);
    }
}
