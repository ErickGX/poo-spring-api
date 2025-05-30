package br.senac.sp.guiarestaurante.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class TipoRestaurante {
	@Id
	@GeneratedValue
	(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nome;
	private String descricao;
	private String palavrasChave;


	public Long getId() {
		return id;
	}

	public TipoRestaurante setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public TipoRestaurante setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoRestaurante setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public String getPalavrasChave() {
		return palavrasChave;
	}

	public TipoRestaurante setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
		return this;
	}
}





