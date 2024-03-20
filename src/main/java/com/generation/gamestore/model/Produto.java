package com.generation.gamestore.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo nome é Obrigatório!")
	@Size(min = 5, max = 50, message = "O atributo titulo deve conter no minimo 05 e no maximo 50 caracteres")
	private String nome;

	@NotBlank(message = "0 atributo gênero é Obrigatório!")
	@Size(min = 4, max = 30, message = "O atributo texto deve conter no mínimo 4 e no máximo 30 caracteres")
	private String genero;

	@NotBlank(message = "0 atributo descricao é Obrigatório!")
	@Size(min = 10, max = 150, message = "O atributo texto deve conter no mínimo 10 e no máximo 150 caracteres")
	private String descricao;

	@DecimalMin(value = "1.00", message = "O preço mínimo deve ser 1.00")
	@Digits(integer = 4, fraction = 2, message = "O preço deve ter no máximo 6 dígitos inteiros e 2 decimais")
	private BigDecimal preco;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
