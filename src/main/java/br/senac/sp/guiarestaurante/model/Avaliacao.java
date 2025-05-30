package br.senac.sp.guiarestaurante.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double nota;
	private String comentario;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Calendar dataVisita;
	//Muitas avaliações são de um restaurante.
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Restaurante restaurante;
	//Muitas avaliações são feitas por um usuário.
	@ManyToOne
	private Usuario usuario;


	public Long getId() {
		return id;
	}

	public Avaliacao setId(Long id) {
		this.id = id;
		return this;
	}

	public double getNota() {
		return nota;
	}

	public Avaliacao setNota(double nota) {
		this.nota = nota;
		return this;
	}

	public String getComentario() {
		return comentario;
	}

	public Avaliacao setComentario(String comentario) {
		this.comentario = comentario;
		return this;
	}

	public Calendar getDataVisita() {
		return dataVisita;
	}

	public Avaliacao setDataVisita(Calendar dataVisita) {
		this.dataVisita = dataVisita;
		return this;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public Avaliacao setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
		return this;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Avaliacao setUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
}
