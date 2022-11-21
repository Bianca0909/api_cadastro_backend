package br.com.dvtisul.persistencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Código identificador do cliente")
	private Integer id;
	
	@Column
	@ApiModelProperty(value = "Nome do cliente")
	private String nome;
	
	@Column
	@ApiModelProperty(value = "Sexo do cliente")
	private String sexo;

	@Column
	@ApiModelProperty(value = "Idade do cliente")
	private Integer idade;
	
	@ManyToOne
	@ApiModelProperty(value = "Cidade do cliente")
	private Cidade cidade;
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nome, String sexo, Integer idade, Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
