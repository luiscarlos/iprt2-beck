package br.com.lc.iprt2.model;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lc.iprt2.model.ennums.Departamento;
import br.com.lc.iprt2.model.ennums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDoEventoDe;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDoEventoAte;
	
	private Status status;
	private Departamento departamento;
	private String observacoes;
	
	
	@ManyToOne
	@JoinColumn(name = "membro_id")
	private Membro membro;
	

	@ManyToOne
	@JoinColumn(name = "igreja_id")
	private Igreja igreja;
	
	
	public Evento() {
		super();
	}


	public Evento(Integer id, String titulo, LocalDate dataDoEventoDe, LocalDate dataDoEventoAte, Status status,
			Departamento departamento, String observacoes, Membro membro, Igreja igreja) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataDoEventoDe = dataDoEventoDe;
		this.dataDoEventoAte = dataDoEventoAte;
		this.status = status;
		this.departamento = departamento;
		this.observacoes = observacoes;
		this.membro = membro;
		this.igreja = igreja;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public LocalDate getDataDoEventoDe() {
		return dataDoEventoDe;
	}


	public void setDataDoEventoDe(LocalDate dataDoEventoDe) {
		this.dataDoEventoDe = dataDoEventoDe;
	}


	public LocalDate getDataDoEventoAte() {
		return dataDoEventoAte;
	}


	public void setDataDoEventoAte(LocalDate dataDoEventoAte) {
		this.dataDoEventoAte = dataDoEventoAte;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Departamento getPublico() {
		return departamento;
	}


	public void setPublico(Departamento departamento) {
		this.departamento = departamento;
	}


	public String getObservacoes() {
		return observacoes;
	}


	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


	public Membro getMembro() {
		return membro;
	}


	public void setMembro(Membro membro) {
		this.membro = membro;
	}


	public Igreja getIgreja() {
		return igreja;
	}


	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
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
		Evento other = (Evento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
