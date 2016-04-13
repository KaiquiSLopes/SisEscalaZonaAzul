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
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_horario")
@NamedQueries({ 
	@NamedQuery(name = "Horario.listar", query = "SELECT horario FROM Horario horario"),
	@NamedQuery(name = "Horario.buscarPorCodigo", query = "SELECT horario FROM Horario horario WHERE horario.codigo = :codigo")})

	public class Horario {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "codigoHorario")
		private long codigo;
		
		@NotNull(message = "O campo dia da semana é obrigatorio")
		@Temporal(TemporalType.DATE)
		@Column(name = "diaSemana", length = 45, nullable = false)
		private Date diaSemana;
		
		@NotNull(message = "O campo hora de inicio é obrigatorio")
		@Temporal(TemporalType.TIME)
		@Column(name = "horarioInicio", nullable = false)
		private Date horarioInicio;
		
		@NotNull(message = "O campo hora de saida é obrigatorio")
		@Temporal(TemporalType.TIME)
		@Column(name = "horarioSaida", nullable = false)
		private Date horarioSaida;

		public long getCodigo() {
			return codigo;
		}

		public void setCodigo( long codigo ) {
			this.codigo = codigo;
		}

		public Date getDiaSemana() {
			return diaSemana;
		}

		public void setDiaSemana( Date diaSemana ) {
			this.diaSemana = diaSemana;
		}

		public Date getHorarioInicio() {
			return horarioInicio;
		}

		public void setHorarioInicio( Date horarioInicio ) {
			this.horarioInicio = horarioInicio;
		}

		public Date getHorarioSaida() {
			return horarioSaida;
		}

		public void setHorarioSaida( Date horarioSaida ) {
			this.horarioSaida = horarioSaida;
		}

		@Override
        public String toString() {
	        return "Horario [codigo=" + codigo +
	        		", diaSemana=" + diaSemana +
	        		", horarioInicio=" + horarioInicio +
	        		", horarioSaida=" + horarioSaida +
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
	        Horario other = (Horario) obj;
	        if ( codigo != other.codigo )
		        return false;
	        return true;
        }
}