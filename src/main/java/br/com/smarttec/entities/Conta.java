package br.com.smarttec.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Conta {

	private Integer idConta;
	private String nome;
	private Date data; 
	private Double valor;
	private Integer tipo;
	private String descricao;
	private Integer idUsuario;
	
}
