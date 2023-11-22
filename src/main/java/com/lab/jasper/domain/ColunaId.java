package com.lab.jasper.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ColunaId implements Serializable {

	private static final long serialVersionUID = -250523177773090640L;

	@ManyToOne
	@JoinColumn(name="CODIGO_TABELA", nullable=false)
	private Tabela tabela;
	
	private Integer codigo;

	public Tabela getTabela() {
		return tabela;
	}

	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(tabela).append(codigo).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ColunaId other = (ColunaId) obj;
		return new EqualsBuilder().append(tabela, other.tabela).append(codigo, other.codigo).isEquals();
	}

    @Override
    public String toString() {
    	Integer codigoTabela = null;

        if (tabela != null) {
            codigoTabela = tabela.getCodigo();
        }
        
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
        builder.append("codigoTabela", codigoTabela);
        builder.append("codigo", codigo);

        return builder.toString();
    }	

}
