package com.br.struct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntrega {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(nullable = false, unique = true)
	 private String descEnderecoEntregaEntity;
	 
	 @Column(nullable = false, unique = true)
	 private Long numEndEntregaEntity;
	 
	 @Column(nullable = false, unique = true)
	 private String nomePessoaEntrega;
}
