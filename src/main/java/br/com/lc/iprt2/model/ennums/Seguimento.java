package br.com.lc.iprt2.model.ennums;

public enum Seguimento {

	
CEIA(0, "SANTA CEIA"),  FAMILIA(1, "CULTO DA FAMILIA"), MISSOES(1, "CULTO DE MISSÕES");
	
	private Integer cod;
	private String descricao;
	
	
	private Seguimento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Status x : Status.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Seguimento invãlido");
	}
	
}
