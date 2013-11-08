package bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import dao.HibernateDAO;
import pojo.Acesso;
import pojo.Endereco;
import pojo.Municipio;
import pojo.Pessoa;


@ManagedBean(name = "cadastrarBean")
@RequestScoped

public class CadastrarBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Endereco endereco;
	private Pessoa pessoa;
	private Acesso acesso;
	private Integer idMun;
	private Integer idEnd;
	private String dateConvert;
	
	
	
	public CadastrarBean() {
		pessoa = new Pessoa();
		acesso = new Acesso();
		endereco = new Endereco();
		idMun = 0;
		dateConvert = null;
		
	}
	
	public void include(ActionEvent event) throws ParseException {
		
		HibernateDAO<Endereco, Integer> include_End = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		Municipio mun = new Municipio();
		mun.setIdMunicipio(idMun);
		endereco.setMunicipio(mun);
		if (include_End.inclui(endereco) == true) {
			HibernateDAO<Acesso, Integer> include_Acs = new HibernateDAO<Acesso, Integer>(
					Acesso.class);
			if (include_Acs.inclui(acesso) == true){
		
			HibernateDAO<Pessoa, Integer> include_Pes = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			Date datanasc = formatador.parse(dateConvert);
			pessoa.setDataNascimento(datanasc);
			acesso.getEmail();
			pessoa.setAcesso(acesso);
			endereco.getIdEndereco();
			pessoa.setEndereco(endereco);
			if (include_Pes.inclui(pessoa)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Operação Concluida", "Cadastro " + pessoa.getNome() +" incluido com sucesso."));  
			}
			}
			
		}
		
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getIdMun() {
		return idMun;
	}

	public void setIdMun(Integer idMun) {
		this.idMun = idMun;
	}

	public Integer getIdEnd() {
		return idEnd;
	}

	public void setIdEnd(Integer idEnd) {
		this.idEnd = idEnd;
	}

	public String getDateConvert() {
		return dateConvert;
	}

	public void setDateConvert(String dateConvert) {
		this.dateConvert = dateConvert;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}
	
	
	
}