package br.senac.sp.guiarestaurante.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cep;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String atracoes;
	private String formasPagamento;
	private String horario;
	private String site;
	private String telefone;
	private boolean delivery;
	private boolean acessibilidade;
	private boolean driveThru;
	private boolean estacionamento;
	private boolean espacoPet;
	private boolean espacoKids;

	//Um Restaurante tem muitas Avaliações.
	@ManyToOne
	private TipoRestaurante tipo;

	//Muitos Restaurantes pertencem a um único TipoRestaurante.
	@OneToMany(mappedBy = "restaurante" )
	private List<Avaliacao> avaliacoes;


	public Long getId() {
		return id;
	}

	public Restaurante setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Restaurante setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public Restaurante setCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getEndereco() {
		return endereco;
	}

	public Restaurante setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public String getNumero() {
		return numero;
	}

	public Restaurante setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public String getComplemento() {
		return complemento;
	}

	public Restaurante setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public Restaurante setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public Restaurante setCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getEstado() {
		return estado;
	}

	public Restaurante setEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public String getAtracoes() {
		return atracoes;
	}

	public Restaurante setAtracoes(String atracoes) {
		this.atracoes = atracoes;
		return this;
	}

	public String getFormasPagamento() {
		return formasPagamento;
	}

	public Restaurante setFormasPagamento(String formasPagamento) {
		this.formasPagamento = formasPagamento;
		return this;
	}

	public String getHorario() {
		return horario;
	}

	public Restaurante setHorario(String horario) {
		this.horario = horario;
		return this;
	}

	public String getSite() {
		return site;
	}

	public Restaurante setSite(String site) {
		this.site = site;
		return this;
	}

	public String getTelefone() {
		return telefone;
	}

	public Restaurante setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public boolean isDelivery() {
		return delivery;
	}

	public Restaurante setDelivery(boolean delivery) {
		this.delivery = delivery;
		return this;
	}

	public boolean isAcessibilidade() {
		return acessibilidade;
	}

	public Restaurante setAcessibilidade(boolean acessibilidade) {
		this.acessibilidade = acessibilidade;
		return this;
	}

	public boolean isDriveThru() {
		return driveThru;
	}

	public Restaurante setDriveThru(boolean driveThru) {
		this.driveThru = driveThru;
		return this;
	}

	public boolean isEstacionamento() {
		return estacionamento;
	}

	public Restaurante setEstacionamento(boolean estacionamento) {
		this.estacionamento = estacionamento;
		return this;
	}

	public boolean isEspacoPet() {
		return espacoPet;
	}

	public Restaurante setEspacoPet(boolean espacoPet) {
		this.espacoPet = espacoPet;
		return this;
	}

	public boolean isEspacoKids() {
		return espacoKids;
	}

	public Restaurante setEspacoKids(boolean espacoKids) {
		this.espacoKids = espacoKids;
		return this;
	}

	public TipoRestaurante getTipo() {
		return tipo;
	}

	public Restaurante setTipo(TipoRestaurante tipo) {
		this.tipo = tipo;
		return this;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public Restaurante setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
		return this;
	}
}
