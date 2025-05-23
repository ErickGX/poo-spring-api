package br.senac.sp.guiarestaurante.model;

import java.util.Calendar;

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
	private Calendar dataVisita;
	@ManyToOne
	private Restaurante restaurante;
	@ManyToOne
	private Usuario usuario;
}
