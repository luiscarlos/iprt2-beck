package br.com.lc.iprt2.model.ennums;

public enum UserRole {

	ADMIN(0, "ROLE_ADMIN"), TESOUREIRO(1, "ROLE_TESOUREIRO"), DIACONAL(2, "ROLE_DIACONO"), MEMBRO(3, "ROLE_MEMBRO");
	
	private Integer cod;
	private String descricao;
	
	
	private UserRole(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static UserRole toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (UserRole x : UserRole.values() ) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("UserRole invalido");
	}
	
	
}
