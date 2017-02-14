package main.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.dao.CorrentistaDAO;
import main.model.Correntista;

/**
 * @author - Alexandre Jardim
 * @since - 13/02/2017
 */

@ManagedBean(name = "mbConta")
@SessionScoped
public class ContaBean {
	private static final long serialVersionUID = 1L;

	private CorrentistaDAO correntistaDAO;
	private List<Correntista> lstCorrentistas;
	private Correntista correntistaAtivo;
	private Correntista correntistaCadastro;
	
	private String agencia;
	private String conta;
	private String senha;
	
	private String agenciaDestino;
	private String contaDestino;
	private double valor;
	
	public ContaBean(){
		correntistaDAO = new CorrentistaDAO();
		lstCorrentistas = correntistaDAO.listAll(); 
	}

	public CorrentistaDAO getCorrentistaDAO() {
		return correntistaDAO;
	}

	public void setCorrentistaDAO(CorrentistaDAO correntistaDAO) {
		this.correntistaDAO = correntistaDAO;
	}
	
	public String acessar(){
		correntistaAtivo = correntistaDAO.buscaCorrentista(agencia, conta);
		if (correntistaAtivo == null){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Correntista não Localizado!", "Correntista não Localizado"));
			return "";
		}else if (correntistaAtivo.getCli_senha().equals(senha)){
			return "conta";
		}else{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Senha não Confere!", "Senha não Confere"));
			return "";			
		}
	}
	
	public void transferir(){
		if (valor <= 0){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Informe um valor Válido!", "Informe um valor Válido"));
			return;
		}
		
		correntistaAtivo = correntistaDAO.buscaCorrentista(agencia, conta);
		if (correntistaAtivo == null){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Correntista não Localizado!", "Correntista não Localizado"));
			return;
		}
		
		if (correntistaAtivo.getCli_saldo() < valor){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Saldo insuficiente!", "Saldo insuficiente"));
			return;
		}
	}



	public List<Correntista> getLstCorrentistas() {
		return lstCorrentistas;
	}

	public void setLstCorrentistas(List<Correntista> lstCorrentistas) {
		this.lstCorrentistas = lstCorrentistas;
	}

	
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Correntista getCorrentistaAtivo() {
		return correntistaAtivo;
	}

	public void setCorrentistaAtivo(Correntista correntistaAtivo) {
		this.correntistaAtivo = correntistaAtivo;
	}

	public Correntista getCorrentistaCadastro() {
		return correntistaCadastro;
	}

	public void setCorrentistaCadastro(Correntista correntistaCadastro) {
		this.correntistaCadastro = correntistaCadastro;
	}

	public String getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(String agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}