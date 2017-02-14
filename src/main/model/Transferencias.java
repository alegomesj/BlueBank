package main.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author - Alexandre Jardim
 * @since - 13/02/2017
 */

@Entity
@Table(name = "TRANSFERENCIAS")
public class Transferencias {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRF_CODIGO")
	private long trf_codigo;
	
	@Column(name = "TRF_DATA", nullable = false)
	private Timestamp trf_data;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "TRF_CLIORIGEM", nullable = false)
	private Correntista trf_cliorigem;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "TRF_CLIDESTINO", nullable = false)
	private Correntista trf_clidestino;
	
	@Column(name = "TRF_VALOR", nullable = false, precision = 10, scale = 2)
	private double trf_valor;

	public long getTrf_codigo() {
		return trf_codigo;
	}

	public void setTrf_codigo(long trf_codigo) {
		this.trf_codigo = trf_codigo;
	}

	public Timestamp getTrf_data() {
		return trf_data;
	}

	public void setTrf_data(Timestamp trf_data) {
		this.trf_data = trf_data;
	}

	public Correntista getTrf_cliorigem() {
		return trf_cliorigem;
	}

	public void setTrf_cliorigem(Correntista trf_cliorigem) {
		this.trf_cliorigem = trf_cliorigem;
	}

	public Correntista getTrf_clidestino() {
		return trf_clidestino;
	}

	public void setTrf_clidestino(Correntista trf_clidestino) {
		this.trf_clidestino = trf_clidestino;
	}

	public double getTrf_valor() {
		return trf_valor;
	}

	public void setTrf_valor(double trf_valor) {
		this.trf_valor = trf_valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trf_clidestino == null) ? 0 : trf_clidestino.hashCode());
		result = prime * result + ((trf_cliorigem == null) ? 0 : trf_cliorigem.hashCode());
		result = prime * result + (int) (trf_codigo ^ (trf_codigo >>> 32));
		result = prime * result + ((trf_data == null) ? 0 : trf_data.hashCode());
		long temp;
		temp = Double.doubleToLongBits(trf_valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencias other = (Transferencias) obj;
		if (trf_clidestino == null) {
			if (other.trf_clidestino != null)
				return false;
		} else if (!trf_clidestino.equals(other.trf_clidestino))
			return false;
		if (trf_cliorigem == null) {
			if (other.trf_cliorigem != null)
				return false;
		} else if (!trf_cliorigem.equals(other.trf_cliorigem))
			return false;
		if (trf_codigo != other.trf_codigo)
			return false;
		if (trf_data == null) {
			if (other.trf_data != null)
				return false;
		} else if (!trf_data.equals(other.trf_data))
			return false;
		if (Double.doubleToLongBits(trf_valor) != Double.doubleToLongBits(other.trf_valor))
			return false;
		return true;
	}
	
	

}
