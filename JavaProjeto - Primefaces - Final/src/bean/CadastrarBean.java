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

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

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
	private Endereco endereco1;
	private Pessoa pessoa1;
	private Acesso acesso1;
	private Integer idMun;
	private Integer idEnd;
	private Integer idPes;
	private String  idAce;
	private String dateConvert;
	
	
	
	public CadastrarBean() {
		pessoa = new Pessoa();
		acesso = new Acesso();
		endereco = new Endereco();
		pessoa1 = new Pessoa();
		acesso1 = new Acesso();
		endereco1 = new Endereco();
		idMun = 0;
		idEnd = 0;
		idPes = 0;
		idAce = null;
		dateConvert = null;
		
	}
	
	public void include(ActionEvent event) throws ParseException {
		try{
		HibernateDAO<Endereco, Integer> consultarEnd = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		Municipio mun = new Municipio();
		mun.setIdMunicipio(idMun);
		endereco.setMunicipio(mun);
		
		HibernateDAO<Acesso, String> consultarAce = new HibernateDAO<Acesso, String>(
				Acesso.class);
		
		
		HibernateDAO<Pessoa, Integer> consultarPes = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date datanasc = formatador.parse(dateConvert);
		pessoa.setDataNascimento(datanasc);
		acesso.getEmail();
		pessoa.getIdPessoa();
		endereco.getIdEndereco();
		pessoa.setEndereco(endereco);
		pessoa.getIdPessoa();
		idPes  = pessoa.getIdPessoa();
		idAce = acesso.getEmail();
		
		
		
		//Consulta Ids...
				
		acesso1 = (Acesso) consultarAce.consulta(acesso.getEmail());
		
		
		endereco1 = (Endereco) consultarEnd.consulta(endereco.getIdEndereco());
		
		
		pessoa1 = (Pessoa) consultarPes.consulta(pessoa.getIdPessoa());

		//
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (endereco1 == null && acesso1 == null && pessoa1 == null)
		{
			
			HibernateDAO<Endereco, Integer> incluir_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
			
			incluir_End.inclui(endereco);
			
			
				
				HibernateDAO<Acesso, String> include_Acs = new HibernateDAO<Acesso, String>(
						Acesso.class);
				
				
				include_Acs.inclui(acesso);
				
				
					HibernateDAO<Pessoa, Integer> include_Pes = new HibernateDAO<Pessoa, Integer>(
							Pessoa.class);
					
					include_Pes.inclui(pessoa);
						context.getExternalContext().getFlash().setKeepMessages(true);
						context.addMessage(null,
								new FacesMessage("Operação Concluida", "Cadastro "
										+ pessoa.getNome()
										+ " incluido com sucesso."));

					}
				
			
			
		
		else
		{
			context.addMessage(null, new FacesMessage("Falha na  Operação", "Alguns dos Ids  já existem na base de dados"));
		}

	
	}catch (ConstraintViolationException e) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Falha na  Operação", "Alguns dos Ids  já existe na base de dados"));
		e.printStackTrace();
	} catch (HibernateException e) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, "ERRO!Acesso ao Banco de Dados",
				"Falha na inclusão dos dados."));
		e.printStackTrace();
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

	public Integer getIdPes() {
		return idPes;
	}

	public void setIdPes(Integer idPes) {
		this.idPes = idPes;
	}

	public String getIdAce() {
		return idAce;
	}

	public void setIdAce(String idAce) {
		this.idAce = idAce;
	}

	public Endereco getEndereco1() {
		return endereco1;
	}

	public void setEndereco1(Endereco endereco1) {
		this.endereco1 = endereco1;
	}

	public Pessoa getPessoa1() {
		return pessoa1;
	}

	public void setPessoa1(Pessoa pessoa1) {
		this.pessoa1 = pessoa1;
	}

	public Acesso getAcesso1() {
		return acesso1;
	}

	public void setAcesso1(Acesso acesso1) {
		this.acesso1 = acesso1;
	}
	
	
	
	
	
	
}