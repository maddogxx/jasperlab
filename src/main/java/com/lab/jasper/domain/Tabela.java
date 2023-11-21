package com.lab.jasper.domain;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "LABO", name = "TABELA")
public class Tabela implements Serializable {

	private static final long serialVersionUID = -5970220187274236859L;
	
	@Id
	private Integer codigo;
	
	private String nome;
	
	private String esquema;
	
	@OneToMany(mappedBy = "id.coluna", fetch = FetchType.EAGER)
	private List<Coluna> colunas;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codigo).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Tabela other = (Tabela) obj;
		return new EqualsBuilder().append(codigo, other.codigo).isEquals();
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }


}
