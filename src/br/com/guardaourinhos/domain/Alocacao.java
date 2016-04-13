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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_alocacao")
@NamedQueries({ 
	@NamedQuery(name = "Alocacao.listar", query = "SELECT alocacao FROM Alocacao alocacao"),
	@NamedQuery(name = "Alocacao.buscarPorCodigo", query = "SELECT alocacao FROM Alocacao alocacao WHERE codigo = :codigo")})

public class Alocacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoAlocacao")
	public long codigo;

	@NotEmpty(message = "O campo endereco é obrigatorio")
	@Size(min = 3, max = 45, message = "Tamanho invalido para o campo")
	@Column(name = "endereco", length = 45, nullable = false)
	public String endereco;

	@NotNull(message = "Campo Supervisor precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoSupervisor", referencedColumnName = "codigoSupervisor", nullable = false)
	private Supervisor supervisor;

	@NotNull(message = "Campo Ponto de Referencia precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoPonto", referencedColumnName = "codigoPonto", nullable = false)
	private PontoReferencia pontoReferencia;
	
	@NotNull(message = "Campo Guardinha precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoGuardinha", referencedColumnName = "codigoGuardinha", nullable = false)
	private Guardinha guardinha;

	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo( long codigo ) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco( String endereco ) {
		this.endereco = endereco;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor( Supervisor supervisor ) {
		this.supervisor = supervisor;
	}

	public PontoReferencia getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia( PontoReferencia pontoReferencia ) {
		this.pontoReferencia = pontoReferencia;
	}

	public Guardinha getGuardinha() {
		return guardinha;
	}

	public void setGuardinha( Guardinha guardinha ) {
		this.guardinha = guardinha;
	}

	@Override
    public String toString() {
	    return "Alocacao [codigo=" + codigo +
	    		", endereco=" + endereco +
	    		", supervisor=" + supervisor +
	    		", pontoReferencia=" + pontoReferencia +
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
	    Alocacao other = (Alocacao) obj;
	    if ( codigo != other.codigo )
		    return false;
	    return true;
    }
}
