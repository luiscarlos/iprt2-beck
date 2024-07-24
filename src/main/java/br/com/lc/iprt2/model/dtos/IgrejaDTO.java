package br.com.lc.iprt2.model.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lc.iprt2.model.Endereco;
import br.com.lc.iprt2.model.Igreja;

public class IgrejaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id;

	@NotNull
	@NotBlank
	protected String pastor;

	@NotNull
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate aniversarioPastor;

	@NotNull
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataAniversarioIgrejaDe;

	@NotNull
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataAniversarioIgrejaAte;

	@NotNull
	@NotBlank
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	protected Endereco endereco;

	
	public IgrejaDTO() {
		super();
	}


	/**
	 * @param id
	 * @param pastor
	 * @param aniversarioPastor
	 * @param dataAniversarioIgrejaDe
	 * @param dataAniversarioIgrejaAte
	 * @param endereco
	 */



	public IgrejaDTO(Igreja igrejaObj) {
		super();
		this.id = igrejaObj.getId();
		this.pastor = igrejaObj.getPastor();
		this.aniversarioPastor = igrejaObj.getAniversarioPastor();
		this.dataAniversarioIgrejaDe = igrejaObj.getDataAniversarioIgrejaDe();
		this.dataAniversarioIgrejaAte = igrejaObj.getDataAniversarioIgrejaAte();
		this.endereco = igrejaObj.getEndereco();	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPastor() {
		return pastor;
	}


	public void setPastor(String pastor) {
		this.pastor = pastor;
	}


	public LocalDate getAniversarioPastor() {
		return aniversarioPastor;
	}


	public void setAniversarioPastor(LocalDate aniversarioPastor) {
		this.aniversarioPastor = aniversarioPastor;
	}


	public LocalDate getDataAniversarioIgrejaDe() {
		return dataAniversarioIgrejaDe;
	}


	public void setDataAniversarioIgrejaDe(LocalDate dataAniversarioIgrejaDe) {
		this.dataAniversarioIgrejaDe = dataAniversarioIgrejaDe;
	}


	public LocalDate getDataAniversarioIgrejaAte() {
		return dataAniversarioIgrejaAte;
	}


	public void setDataAniversarioIgrejaAte(LocalDate dataAniversarioIgrejaAte) {
		this.dataAniversarioIgrejaAte = dataAniversarioIgrejaAte;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
}
