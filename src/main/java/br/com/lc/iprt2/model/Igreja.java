package br.com.lc.iprt2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;


import br.com.lc.iprt2.model.dtos.IgrejaDTO;



@Entity
public class Igreja implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message ="O campo NOME é requerido!")
	private String pastor;
	
	@NotNull(message ="O campo NOME DA IGREJA é requerido!")
	private String nomeIgreja;
	
	@NotNull(message ="O campo Aniversário do pastor  é requerido!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate aniversarioPastor;
	
	@NotNull(message ="O campo DATA DE ANIVER´SARIO INICIO é requerido!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAniversarioIgrejaDe;
	
	@NotNull(message ="O campo DATA DE ANIVER´SARIO FIM é requerido!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAniversarioIgrejaAte;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	

	
	//@JsonIgnore
	@OneToMany(mappedBy = "igreja")
	List<Evento> eventos = new ArrayList<>();
	
	
	
	
	
	/**
	 * 
	 */
	public Igreja() {
		super();
	}



	public Igreja(IgrejaDTO  igrejaDTO) {
		super();
		this.id = igrejaDTO.getId();
		this.pastor = igrejaDTO.getPastor();
		this.nomeIgreja = igrejaDTO.getNomeIgreja();
		this.aniversarioPastor = igrejaDTO.getAniversarioPastor();
		this.dataAniversarioIgrejaDe = igrejaDTO.getDataAniversarioIgrejaDe();
		this.dataAniversarioIgrejaAte = igrejaDTO.getDataAniversarioIgrejaAte();
		this.endereco = igrejaDTO.getEndereco();
	}



	public Igreja(Integer id, String pastor, String nomeIgreja, LocalDate aniversarioPastor, LocalDate dataAniversarioIgrejaDe,
			LocalDate dataAniversarioIgrejaAte, Endereco endereco) {
		super();
		this.id = id;
		this.pastor = pastor;
		this.nomeIgreja = nomeIgreja;
		this.aniversarioPastor = aniversarioPastor;
		this.dataAniversarioIgrejaDe = dataAniversarioIgrejaDe;
		this.dataAniversarioIgrejaAte = dataAniversarioIgrejaAte;
		this.endereco = endereco;
	}



	/*public List<Evento> getEventos() {
		return eventos;
	}



	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}*/



	public Integer getId() {
		return id;
	}



	public String getNomeIgreja() {
		return nomeIgreja;
	}



	public void setNomeIgreja(String nomeIgreja) {
		this.nomeIgreja = nomeIgreja;
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
		Igreja other = (Igreja) obj;
		return Objects.equals(id, other.id);
	}




}