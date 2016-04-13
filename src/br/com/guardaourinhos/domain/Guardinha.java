package br.com.guardaourinhos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_guardinha")
@NamedQueries({ 
	@NamedQuery(name = "Guardinha.listar", query = "SELECT guardinha FROM Guardinha guardinha"),
	@NamedQuery(name = "Guardinha.buscarPorCodigo", query = "SELECT guardinha FROM Guardinha guardinha WHERE guardinha.codigo = :codigo")})

public class Guardinha {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoGuardinha")
	private long codigo;
	
	@NotEmpty(message = "O campo Nome é obrigatório!")
	@Size(min = 3, max = 50, message = "Tamanho invalido para o campo Nome!")
	@Column(name = "nomeGuardinha", nullable = false )
	private  String nomeGuardinha;
	
	@NotEmpty(message = "O campo Endereço é obrigatório!")
	@Size(min = 3, max = 50, message = "Tamanho invalido para o campo endereço!")
	@Column(name = "enderecoGuardinha", nullable = false )
	private  String enderecoGuardinha;
	
	@NotNull(message = "O campo numero do cracha é obrigatorio!")
	@Min(value = 0)
	@Max(value = 100000000)
	@Column(name = "numeroCracha", nullable = false )
	private  Integer cracha;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataDemissao" )
	private Date demissao;
	
	@NotNull(message = "O campo Data de Admissão é obrigatório!")
	@Temporal(TemporalType.DATE)
	@Column(name = "dataAdmissao" )
	private  Date admissao;
	
	@NotNull(message = "O campo Data de Nascimento é obrigatório!")
	@Column(name = "dataNascimento" )
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo( long codigo ) {
		this.codigo = codigo;
	}

	public String getNomeGuardinha() {
		return nomeGuardinha;
	}

	public void setNomeGuardinha( String nomeGuardinha ) {
		this.nomeGuardinha = nomeGuardinha;
	}

	public String getEnderecoGuardinha() {
		return enderecoGuardinha;
	}

	public void setEnderecoGuardinha( String enderecoGuardinha ) {
		this.enderecoGuardinha = enderecoGuardinha;
	}

	public Integer getCracha() {
		return cracha;
	}

	public void setCracha( Integer cracha ) {
		this.cracha = cracha;
	}

	public Date getDemissao() {
		return demissao;
	}

	public void setDemissao( Date demissao ) {
		this.demissao = demissao;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao( Date admissao ) {
		this.admissao = admissao;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento( Date nascimento ) {
		this.nascimento = nascimento;
	}

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ( ( admissao == null ) ? 0 : admissao.hashCode() );
	    result = prime * result + (int) ( codigo ^ ( codigo >>> 32 ) );
	    result = prime * result + ( ( cracha == null ) ? 0 : cracha.hashCode() );
	    result = prime * result + ( ( demissao == null ) ? 0 : demissao.hashCode() );
	    result = prime * result + ( ( enderecoGuardinha == null ) ? 0 : enderecoGuardinha.hashCode() );
	    result = prime * result + ( ( nascimento == null ) ? 0 : nascimento.hashCode() );
	    result = prime * result + ( ( nomeGuardinha == null ) ? 0 : nomeGuardinha.hashCode() );
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
	    Guardinha other = (Guardinha) obj;
	    if ( admissao == null ) {
		    if ( other.admissao != null )
			    return false;
	    } else if ( !admissao.equals( other.admissao ) )
		    return false;
	    if ( codigo != other.codigo )
		    return false;
	    if ( cracha == null ) {
		    if ( other.cracha != null )
			    return false;
	    } else if ( !cracha.equals( other.cracha ) )
		    return false;
	    if ( demissao == null ) {
		    if ( other.demissao != null )
			    return false;
	    } else if ( !demissao.equals( other.demissao ) )
		    return false;
	    if ( enderecoGuardinha == null ) {
		    if ( other.enderecoGuardinha != null )
			    return false;
	    } else if ( !enderecoGuardinha.equals( other.enderecoGuardinha ) )
		    return false;
	    if ( nascimento == null ) {
		    if ( other.nascimento != null )
			    return false;
	    } else if ( !nascimento.equals( other.nascimento ) )
		    return false;
	    if ( nomeGuardinha == null ) {
		    if ( other.nomeGuardinha != null )
			    return false;
	    } else if ( !nomeGuardinha.equals( other.nomeGuardinha ) )
		    return false;
	    return true;
    }

	@Override
    public String toString() {
	    return "Guardinha [codigo=" + codigo +
	    		", nomeGuardinha=" + nomeGuardinha +
	    		", enderecoGuardinha=" + enderecoGuardinha +
	    		", cracha=" + cracha +
	    		", demissao=" + demissao +
	    		", admissao=" + admissao +
	    		", nascimento=" + nascimento +
	    		"]";
    }
	

	
	
	
}
