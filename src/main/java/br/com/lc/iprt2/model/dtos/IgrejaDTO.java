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
}
