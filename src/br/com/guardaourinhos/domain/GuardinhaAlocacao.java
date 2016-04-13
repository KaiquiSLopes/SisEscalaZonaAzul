package br.com.guardaourinhos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_guardinhaAlocacao")
@NamedQueries({ 
	@NamedQuery(name = "GuardinhaAlocacao.listar", query = "SELECT guardinhaAlocacao FROM GuardinhaAlocacao guardinhaAlocacao"),
	@NamedQuery(name = "GuardinhaAlocacao.buscarPorCodigo", query = "SELECT guardinhaAlocacao FROM GuardinhaAlocacao guardinhaAlocacao WHERE codigo = :codigo")})
public class GuardinhaAlocacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoGuardinhaAlocacao")
	public long codigo;

	@NotNull(message = "Campo Alocacao precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoAlocacao", referencedColumnName = "codigoAlocacao", nullable = false)
	private Alocacao alocacao;

	@NotNull(message = "Campo Guardinha precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoGuardinha", referencedColumnName = "codigoGuardinha", nullable = false)
	private Guardinha guardinha;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Alocacao getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(Alocacao alocacao) {
		this.alocacao = alocacao;
	}

	public Guardinha getGuardinha() {
		return guardinha;
	}

	public void setGuardinha(Guardinha guardinha) {
		this.guardinha = guardinha;
	}


    @Override
    public String toString() {
	    return "GuardinhaAlocacao [codigo=" + codigo +
	    		", alocacao=" + alocacao +
	    		", guardinha=" + guardinha + 
	    		"]";
    }

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + (int) ( codigo ^ ( codigo >>> 32 ) );
	    return result;
    }

	@Override
    public boolean equals( Object obj ) {
	    if ( this == obj )
		    return true;
	    if ( obj == null )
		    return false;
	    if ( getClass() != obj.getClass() )
		    return false;
	    GuardinhaAlocacao other = (GuardinhaAlocacao) obj;
	    if ( codigo != other.codigo )
		    return false;
	    return true;
    }
}