package br.com.lc.iprt2.model.ennums;

public enum Departamento {
	
HOMENS(0, "HOMENS"), MULHERES(1, "MULHERES"),JOVENS(2, "JOVENS"), LIDERANCA(3, "LIDERANCA"), TODOS(4,"TODOS");
	
	private Integer cod;
	private String descricao;
	
	
	


	private Departamento(Integer cod, String descricao) {
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
		throw new IllegalArgumentException("Opção invãlida");
	}
}
