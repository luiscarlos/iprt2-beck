package br.com.lc.iprt2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.lc.iprt2.model.dtos.MembroDTO;
import br.com.lc.iprt2.model.ennums.UserRole;


@Entity
public class Membro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message ="O campo NOME é requerido!")
	private String nome;
	
	@NotNull(message ="O campo E-MAIL é requerido!")
	@Column(unique = true)
	private String email;
	
	@NotNull(message ="O campo SENHA é requerido!")
	private String senha;
	
	@NotNull(message ="O campo TELEFONE é requerido!")
	private String telefone;
	private UserRole role;

	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;

	@NotNull(message ="O campo DATA DE CONVERSÃO é requerido!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataConversao;

	@NotNull(message ="O campo DATA DE NASCIMENTO é requerido!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@JsonIgnore
	@OneToMany(mappedBy = "membro")
	List<Evento> eventos = new ArrayList<>();
	
	/*
	@OneToMany(mappedBy = "membro")
	List<EscalaCulto> EscalaCulto = new ArrayList<>();
	

	@OneToMany(mappedBy = "membro")
	List<Servico> Servico = new ArrayList<>();
	*/

	public Membro() {
		super();
	}

	
	public Membro(Integer id, String nome, String email, String senha, String telefone, UserRole role,
			Endereco endereco, LocalDate dataConversao, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.role = role;
		this.endereco = endereco;
		this.dataConversao = dataConversao;
		this.dataNascimento = dataNascimento;
		
	}
	
	public Membro(MembroDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.telefone = obj.getTelefone();
		this.role = obj.getRole();
		this.endereco = obj.getEndereco();
		this.dataConversao = obj.getDataConversao();
		this.dataNascimento = obj.getDataNascimento();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public UserRole getRole() {
		return role;
	}


	public void setRole(UserRole role) {
		this.role = role;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public LocalDate getDataConversao() {
		return dataConversao;
	}


	public void setDataConversao(LocalDate dataConversao) {
		this.dataConversao = dataConversao;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public List<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}





	


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membro other = (Membro) obj;
		return Objects.equals(id, other.id);
	}

	
	


	
	
}
