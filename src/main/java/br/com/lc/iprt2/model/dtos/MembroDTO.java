package br.com.lc.iprt2.model.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lc.iprt2.model.Endereco;

import br.com.lc.iprt2.model.Membro;
import br.com.lc.iprt2.model.ennums.UserRole;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class MembroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected String nome;
	protected String email;
	protected String senha;
	protected String telefone;
	protected UserRole role;
	protected Endereco endereco;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataConversao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	public MembroDTO() {
		super();
	}


	public MembroDTO(Membro obj) {
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
	
	
	


	

}
