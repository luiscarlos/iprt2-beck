package br.com.lc.iprt2.model.ennums;

public enum Presenca {
	
	PRESENTE(0, "PRESENTE"), FALTOU(1, "FALTOU"), JUSTIFICADA(1, "JUSTIFICADA");

	
	private Integer cod;
	private String descricao;
	
	
	private Presenca(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Presenca toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Presenca x : Presenca.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Opção inválida");
	}
	
}
