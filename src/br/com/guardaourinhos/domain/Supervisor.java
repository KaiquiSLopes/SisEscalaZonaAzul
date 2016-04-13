package br.com.guardaourinhos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_supervisor")
@NamedQueries({ 
	@NamedQuery(name = "Supervisor.listar", query = "SELECT supervisor FROM Supervisor supervisor"),
	@NamedQuery(name = "Supervisor.buscarPorCodigo", query = "SELECT supervisor FROM Supervisor supervisor WHERE supervisor.codigo = :codigo"),
	@NamedQuery(name = "Supervisor.logar", query = "SELECT supervisor FROM Supervisor supervisor WHERE supervisor.nomeUsuario = :nomeUsuario AND supervisor.senhaUsuario = :senhaUsuario")})

public class Supervisor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoSupervisor")
	private long codigo;
	
	@NotEmpty(message = "O campo nome é obrigatorio")
	@Size(min = 3, max = 45, message = "Tamanho invalido para o campo nome")
	@Column(name = "nome", length = 45, nullable = false)
	private String nome;
	
	@NotEmpty(message = "O campo Endereço é obrigatório!")
	@Size(min = 3, max = 50, message = "Tamanho invalido para o campo endereço!")
	@Column(name = "enderecoSupervisor", nullable = false )
	private  String enderecoSupervisor;

	@NotEmpty(message = "O campo Nome de Usuario é obrigatório!")
	@Size(min = 3, max = 20, message = "Tamanho invalido para o campo Nome de Usuario!")
	@Column(name = "nomeUsuario", nullable = false )
	private  String nomeUsuario;
	
	@NotEmpty(message = "O campo Senha de Usuario é obrigatório!")
	@Size(min = 3, max = 32, message = "Tamanho invalido para o campo Senha de Usuario!")
	@Column(name = "senhaUsuario", nullable = false )
	private  String senhaUsuario;
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
    public String getEnderecoSupervisor() {
		return enderecoSupervisor;
	}

	public void setEnderecoSupervisor( String enderecoSupervisor ) {
		this.enderecoSupervisor = enderecoSupervisor;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario( String nomeUsuario ) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario( String senhaUsuario ) {
		this.senhaUsuario = senhaUsuario;
	}

	@Override
    public String toString() {
	    return "Supervisor [codigo=" + codigo +
	    		", nome=" + nome +
	    		", enderecoSupervisor=" + enderecoSupervisor +
	    		", nomeUsuario=" + nomeUsuario +
	    		", senhaUsuario=" + senhaUsuario + 
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
	    Supervisor other = (Supervisor) obj;
	    if ( codigo != other.codigo )
		    return false;
	    return true;
    }
}