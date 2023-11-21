package com.lab.jasper;

public enum VersaoEnum {
	V1("tabelaV1.jasper", "/home/thiagocs/Documents/listaPessoasV1.pdf"),
	V2("tabelaV2.jasper", "/home/thiagocs/Documents/listaPessoasV2.pdf");
	
	private VersaoEnum(String template, String saida) {
		this.template = template;
		this.saida = saida;
	}
	
	private String template;
	private String saida;
	
	public String getTemplate() {
		return template;
	}
	
	public String getSaida() {
		return saida;
	}
}
