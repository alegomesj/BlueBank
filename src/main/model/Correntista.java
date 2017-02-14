package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author - Alexandre Jardim
 * @since - 13/02/2017
 */

@Entity
@Table(name = "CORRENTISTA")
public class Correntista {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLI_CODIGO", nullable = false)
	private long cli_codigo;
	@Column(name = "CLI_NOME", length = 60, nullable = false)  
	private String cli_nome;
	@Column(name = "CLI_CPF", length = 11, nullable = false)  
	private String cli_cpf;
	@Column(name = "CLI_AGENCIA", length = 4, nullable = false)  
	private String cli_agencia;
	@Column(name = "CLI_CONTACORRENTE", length = 8, nullable = false)  
	private String cli_contacorrente;
	@Column(name = "CLI_SENHA, length = 6, nullable = false")  
	private String cli_senha;
	@Column(name = "CLI_SALDO", precision = 10, scale = 2)
	private double cli_saldo;
	public long getCli_codigo() {
		return cli_codigo;
	}
	public void setCli_codigo(long cli_codigo) {
		this.cli_codigo = cli_codigo;
	}
	public String getCli_nome() {
		return cli_nome;
	}
	public void setCli_nome(String cli_nome) {
		this.cli_nome = cli_nome;
	}
	public String getCli_cpf() {
		return cli_cpf;
	}
	public void setCli_cpf(String cli_cpf) {
		this.cli_cpf = cli_cpf;
	}
	public String getCli_agencia() {
		return cli_agencia;
	}
	public void setCli_agencia(String cli_agencia) {
		this.cli_agencia = cli_agencia;
	}
	public String getCli_contacorrente() {
		return cli_contacorrente;
	}
	public void setCli_contacorrente(String cli_contacorrente) {
		this.cli_contacorrente = cli_contacorrente;
	}
	
	public String getCli_senha() {
		return cli_senha;
	}
	public void setCli_senha(String cli_senha) {
		this.cli_senha = cli_senha;
	}
	public double getCli_saldo() {
		return cli_saldo;
	}
	public void setCli_saldo(double cli_saldo) {
		this.cli_saldo = cli_saldo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cli_agencia == null) ? 0 : cli_agencia.hashCode());
		result = prime * result + (int) (cli_codigo ^ (cli_codigo >>> 32));
		result = prime * result + ((cli_contacorrente == null) ? 0 : cli_contacorrente.hashCode());
		result = prime * result + ((cli_cpf == null) ? 0 : cli_cpf.hashCode());
		result = prime * result + ((cli_nome == null) ? 0 : cli_nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cli_saldo);
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
		Correntista other = (Correntista) obj;
		if (cli_agencia == null) {
			if (other.cli_agencia != null)
				return false;
		} else if (!cli_agencia.equals(other.cli_agencia))
			return false;
		if (cli_codigo != other.cli_codigo)
			return false;
		if (cli_contacorrente == null) {
			if (other.cli_contacorrente != null)
				return false;
		} else if (!cli_contacorrente.equals(other.cli_contacorrente))
			return false;
		if (cli_cpf == null) {
			if (other.cli_cpf != null)
				return false;
		} else if (!cli_cpf.equals(other.cli_cpf))
			return false;
		if (cli_nome == null) {
			if (other.cli_nome != null)
				return false;
		} else if (!cli_nome.equals(other.cli_nome))
			return false;
		if (Double.doubleToLongBits(cli_saldo) != Double.doubleToLongBits(other.cli_saldo))
			return false;
		return true;
	}

	
}
