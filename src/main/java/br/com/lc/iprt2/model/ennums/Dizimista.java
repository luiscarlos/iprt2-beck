package br.com.lc.iprt2.model.ennums;

public enum Dizimista {

	SIM(0, "SIM"), PARCIAL(1, "PARCIAL"), NAO(2, "NÃO");
	
	private Integer codigo;
	private String descricao;
	
	private Dizimista(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Dizimista toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Dizimista x : Dizimista.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Opção inválida");
	}
	
	
}
