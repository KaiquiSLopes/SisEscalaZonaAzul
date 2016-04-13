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
@Table(name = "tbl_escala")
@NamedQueries({ 
	@NamedQuery(name = "Escala.listar", query = "SELECT escala FROM Escala escala"),
	@NamedQuery(name = "Escala.buscarPorCodigo", query = "SELECT escala FROM Escala escala WHERE codigo = :codigo")})

public class Escala {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoEscala")
	public long codigo;
	
	@NotNull(message = "Campo Guardinha precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoGuardinha", referencedColumnName = "codigoGuardinha", nullable = false)
	public Guardinha guardinha;

	@NotNull(message = "Campo Setor precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoSetor", referencedColumnName = "codigoSetor", nullable = false)
	private Setor setor;
	
	@NotNull(message = "Campo Supervisor precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoSupervisor", referencedColumnName = "codigoSupervisor", nullable = false)
	private Supervisor supervisor;
	
	@NotNull(message = "Campo Horario precisa ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoHorario", referencedColumnName = "codigoHorario", nullable = false)
	private Horario horario;

	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo( long codigo ) {
		this.codigo = codigo;
	}

	public Guardinha getGuardinha() {
		return guardinha;
	}

	public void setGuardinha( Guardinha guardinha ) {
		this.guardinha = guardinha;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor( Setor setor ) {
		this.setor = setor;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor( Supervisor supervisor ) {
		this.supervisor = supervisor;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario( Horario horario ) {
		this.horario = horario;
	}

	@Override
    public String toString() {
	    return "Escala [codigo=" + codigo +
	    		", guardinha=" + guardinha +
	    		", setor=" + setor +
	    		", supervisor=" + supervisor +
	    		", horario=" + horario + 
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
	    Escala other = (Escala) obj;
	    if ( codigo != other.codigo )
		    return false;
	    return true;
    }
}

	