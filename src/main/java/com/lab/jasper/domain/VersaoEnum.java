package com.lab.jasper.domain;

public enum VersaoEnum {
	V1("tabelaV1.jasper", "subrelatorio_tabela.jasper", "listaTabelasV1.pdf"),
	V2("tabelaV2.jasper", null, "listaTabelasV2.pdf");

	private VersaoEnum(String template, String subTemplate, String saida) {
		this.template = template;
		this.subTemplate = subTemplate;
		this.saida = saida;
	}

	private String template;
	private String subTemplate;
	private String saida;

	public String getTemplate() {
		return template;
	}

	public String getSubTemplate() {
		return subTemplate;
	}

	public String getSaida() {
		return saida;
	}
}
