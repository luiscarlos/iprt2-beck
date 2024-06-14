package br.com.lc.iprt2.model;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lc.iprt2.model.ennums.Presenca;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataServico;

	private String observacoes;
	
	
	
	@ManyToOne
	@JoinColumn(name = "membro_id")
	private Membro membro;
	private Presenca presenca;

	public Servico() {
		super();
	}

	public Servico(Integer id, LocalDate dataServico, String observacoes, Membro membro, Presenca presenca) {
		super();
		this.id = id;
		this.dataServico = dataServico;
		this.observacoes = observacoes;
		this.membro = membro;
		this.presenca = presenca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataServico() {
		return dataServico;
	}

	public void setDataServico(LocalDate dataServico) {
		this.dataServico = dataServico;
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

	public Presenca getPresenca() {
		return presenca;
	}

	public void setPresenca(Presenca presenca) {
		this.presenca = presenca;
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
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}

}
