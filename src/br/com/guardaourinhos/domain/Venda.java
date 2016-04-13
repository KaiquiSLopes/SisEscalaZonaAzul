package br.com.guardaourinhos.domain;

import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Kaiqui Lopes <kaiquilopes@gmail.com.br>
 * @since 03/10/2014 20:46:53
 * @version 1.0
 */
@Entity
@Table(name = "tbl_vendas")
@NamedQueries({ 
	@NamedQuery(name = "Venda.listar", query = "SELECT venda FROM Venda venda"),
	@NamedQuery(name = "Venda.buscarPorCodigo", query = "SELECT venda FROM Venda venda WHERE codigo = :codigo")})

public class Venda{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoVendas")
	private long codigo;
	
	@NotNull(message = "O campo quantidade de talão é obrigatorio!")
	@Min(value = 0, message = "Informe um valor maior que zero!")
	@Max(value = 100, message = "Informe um valor menor que cem!")
	@Column(name = "quantidadeTalao", nullable = false )
	private  Integer quantidadeTalao;

	@NotNull(message = "O campo quantidade de folha unitaria é obrigatorio!")
	@Min(value = 0, message = "Informe um valor maior que zero!")
	@Max(value = 1000, message = "Informe um valor menor que mil!")
	@Column(name = "quantidadeUnitaria", nullable = false )
	private  Integer quantidadeUnitaria;
	
	@NotNull(message = "Campo Guardinha precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoGuardinha", referencedColumnName = "codigoGuardinha", nullable = false)
	private Guardinha guardinha;

	@NotNull(message = "O campo horario é obrigatório!")
	@Temporal(TemporalType.TIME)
	@Column(name = "horario", nullable = false)
	private Date horario;

	@NotNull(message = "O campo preço de folha unitario é obrigatorio")
	@DecimalMin(value = "0.00", message = "Informe um valor positivo")
	@DecimalMax(value = "999.99", message = "Informe um valor menor que 1 mil")
	@Column(name = "precoUnitarioFolha", nullable = false)
	private BigDecimal precoFolha;
	
	@NotNull(message = "O campo preço de folha por talão é obrigatorio")
	@DecimalMin(value = "0.00", message = "Informe um valor positivo")
	@DecimalMax(value = "999.99", message = "Informe um valor menor que 1 mil")
	@Column(name = "precoUnitarioTalao", nullable = false)
	private BigDecimal precoTalao;
	

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo( long codigo ) {
		this.codigo = codigo;
	}

	public Integer getQuantidadeTalao() {
		return quantidadeTalao;
	}

	public void setQuantidadeTalao( Integer quantidadeTalao ) {
		this.quantidadeTalao = quantidadeTalao;
	}

	public Guardinha getGuardinha() {
		return guardinha;
	}

	public void setGuardinha( Guardinha guardinha ) {
		this.guardinha = guardinha;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario( Date horario ) {
		this.horario = horario;
	}
	
	public BigDecimal getPrecoFolha() {
		return precoFolha;
	}

	public void setPrecoFolha( BigDecimal precoFolha ) {
		this.precoFolha = precoFolha;
	}

	public BigDecimal getPrecoTalao() {
		return precoTalao;
	}

	public void setPrecoTalao( BigDecimal precoTalao ) {
		this.precoTalao = precoTalao;
	}
	
	public Integer getQuantidadeUnitaria() {
		return quantidadeUnitaria;
	}

	public void setQuantidadeUnitaria( Integer quantidadeUnitaria ) {
		this.quantidadeUnitaria = quantidadeUnitaria;
	}

	@Override
    public String toString() {
	    return "Venda [codigo=" + codigo +
	    		", quantidadeTalao=" + quantidadeTalao +
	    		", quantidadeUnitaria=" + quantidadeUnitaria +
	    		", guardinha=" + guardinha +
	    		", horario=" + horario +
	    		", precoFolha=" + precoFolha +
	    		", precoTalao=" + precoTalao + 
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
	    Venda other = (Venda) obj;
	    if ( codigo != other.codigo )
		    return false;
	    return true;
    }
}
