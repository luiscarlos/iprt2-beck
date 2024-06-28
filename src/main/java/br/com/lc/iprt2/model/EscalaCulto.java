package br.com.lc.iprt2.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lc.iprt2.model.ennums.Departamento;
import br.com.lc.iprt2.model.ennums.Seguimento;

@Entity
public class EscalaCulto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPregacao;

	
	@ManyToOne
	@JoinColumn(name = "membro_id")
	private Membro membro;
	
	private Seguimento seguimento;
	private Departamento departamento;
	private String pregadorDeFora;

	public EscalaCulto() {
		super();
	}

	public EscalaCulto(Integer id, LocalDate dataPregacao, Membro membro, Seguimento seguimento,
			Departamento departamento, String pregadorDeFora) {
		super();
		this.id = id;
		this.dataPregacao = dataPregacao;
		this.membro = membro;
		this.seguimento = seguimento;
		this.departamento = departamento;
		this.pregadorDeFora = pregadorDeFora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataPregacao() {
		return dataPregacao;
	}

	public void setDataPregacao(LocalDate dataPregacao) {
		this.dataPregacao = dataPregacao;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Seguimento getSeguimento() {
		return seguimento;
	}

	public void setSeguimento(Seguimento seguimento) {
		this.seguimento = seguimento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getPregadorDeFora() {
		return pregadorDeFora;
	}

	public void setPregadorDeFora(String pregadorDeFora) {
		this.pregadorDeFora = pregadorDeFora;
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
		EscalaCulto other = (EscalaCulto) obj;
		return Objects.equals(id, other.id);
	}

}
