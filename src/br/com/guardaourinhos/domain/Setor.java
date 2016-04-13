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
@Table(name = "tbl_setor")
@NamedQueries({ 
	@NamedQuery(name = "Setor.listar", query = "SELECT setor FROM Setor setor"),
	@NamedQuery(name = "Setor.buscarPorCodigo", query = "SELECT setor FROM Setor setor WHERE setor.codigo = :codigo")})

	public class Setor {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "codigoSetor")
		private long codigo;
		
		@NotEmpty(message = "O campo nome é obrigatorio")
		@Size(min = 3, max = 45, message = "Tamanho invalido para o campo nome")
		@Column(name = "nomeSetor", length = 45, nullable = false)
		private String nome;
		

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

		
		/**
		 * Polimorfico
		 * @see java.lang.Object#toString()
		 */
        @Override
        public String toString() {
	        return "Setor [codigo=" + codigo +
	        		", nome=" + nome + 
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
	        Setor other = (Setor) obj;
	        if ( codigo != other.codigo )
		        return false;
	        return true;
        }
}