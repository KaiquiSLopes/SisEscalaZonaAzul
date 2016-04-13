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
@Table(name = "tbl_pontoRefencia")
@NamedQueries({ 
	@NamedQuery(name = "PontoReferencia.listar", query = "SELECT pontoRefencia FROM PontoReferencia pontoRefencia"),
	@NamedQuery(name = "PontoReferencia.buscarPorCodigo", query = "SELECT pontoRefencia FROM PontoReferencia pontoRefencia WHERE pontoRefencia.codigo = :codigo")})

	public class PontoReferencia {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "codigoPonto")
		private long codigo;
		
		@NotEmpty(message = "O campo descricao é obrigatorio")
		@Size(min = 6, max = 45, message = "Tamanho invalido para o campo")
		@Column(name = "descricao", length = 45, nullable = false)
		private String descricao;
		
		@NotNull(message = "Campo Setor precisa ser selecionado!")
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "codigoSetor", referencedColumnName = "codigoSetor", nullable = false)
		private Setor setor;

		public long getCodigo() {
			return codigo;
		}

		public void setCodigo(long codigo) {
			this.codigo = codigo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Setor getSetor() {
			return setor;
		}

		public void setSetor( Setor setor ) {
			this.setor = setor;
		}

		@Override
        public String toString() {
	        return "PontoReferencia [codigo=" + codigo +
	        		", descricao=" + descricao +
	        		", setor=" + setor + 
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
	        PontoReferencia other = (PontoReferencia) obj;
	        if ( codigo != other.codigo )
		        return false;
	        return true;
        }
}