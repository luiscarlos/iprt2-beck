package br.com.lc.iprt2.model.ennums;

public enum Cargo {
	DIACONO(0, "DIACONO"), PRESBITERO(1, "PRESBITERO"), COOPERADOR(2, "COOPERADOR"),EVANGELISTA(3, "EVANGELISTA"),MISSIONARIA(4, "MISSIONARIA"),DIACONONISA(5, "DIACONONISA");
	
	
	private Integer cod;
	private String descricao;
	
	
	private Cargo(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	
	public static Cargo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Cargo x : Cargo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("cargo eclesiástico inválida");
		
	}
	
	
}
