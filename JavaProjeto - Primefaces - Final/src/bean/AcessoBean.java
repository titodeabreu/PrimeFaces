package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import pojo.Acesso;
import pojo.Endereco;
import pojo.Pessoa;
import dao.HibernateDAO;




@ManagedBean(name = "acessoBean")
@SessionScoped

public class AcessoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String emailv;
	private String senha;
	private String senhav;
	private Acesso acesso;
	private Endereco endereco;
	private Pessoa  pessoa;
	private Integer  pesemail;
	private String EMAIL = "titodeabreu@gmail.com";
	private String SENHA = "197346"; 
	
	
	
	public AcessoBean() {
		super();
		acesso = new Acesso();
		pessoa = new Pessoa();
		endereco = new Endereco();
		email = null;
		senha = null;
		emailv = null;
		senhav = null;
		pesemail =  0;
		this.EMAIL = "titodeabreu@gmail.com";
		this.SENHA = "197346"; 
	}
	
		
	public String validaLogin() {
		HibernateDAO<Acesso, String> ConsultaAcesso = new HibernateDAO<Acesso, String>(Acesso.class);
		
		
		
		acesso = (Acesso) ConsultaAcesso.consulta(email);
		
		
		
		
		
		try {
			FacesContext context = FacesContext.getCurrentInstance();

			if(acesso != null || this.EMAIL.equals(email)){
				
				
			
			
			if(this.EMAIL.equals(email) && this.SENHA.equals(senha)){
				email = null;
				senha = null;
				return "adm";
			}
			
			if ((!acesso.getEmail().equals(null)) && (!acesso.getSenha().equals(null))){
			
			emailv = acesso.getEmail();
			senhav = acesso.getSenha();
			
			}
			
			if(this.email.equals(emailv) && this.senha.equals(senhav))
			{
				HibernateDAO<Pessoa, Integer> consultarPes = new HibernateDAO<Pessoa, Integer>(
						Pessoa.class);
				
//				try {
//					pessoa = (Pessoa) consultarPes.consulta(acesso.getPessoa1());
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//
//				
//				HibernateDAO<Endereco, Integer> consultarEnd = new HibernateDAO<Endereco, Integer>(
//						Endereco.class);
//				
//				endereco = (Endereco) consultarEnd.consulta(pessoa.getIdPessoa());
	
				
				return "sucesso";
			}
			else
			{
				context.getExternalContext().getFlash().setKeepMessages(true);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Insira novamente", "Senha incorreta."));
				return "erro";	
			}
			
			}
			
			else{
				context.getExternalContext().getFlash().setKeepMessages(true);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Insira novamente", "Dados incorretos."));

				email = null;
				senha = null;
				return "erro";
				
			}
			
			
			
			 
			
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha de consulta aos dados."));
			e.printStackTrace();
		}
		return "erro";
		
		

	}
	
	 public void logout() {  
		 FacesContext fc = FacesContext.getCurrentInstance(); 
		 HttpSession session = (HttpSession) fc.getExternalContext().getSession(false); 
		 session.invalidate();
	    }  

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public String getSENHA() {
		return SENHA;
	}


	public String getEmailv() {
		return emailv;
	}


	public void setEmailv(String emailv) {
		this.emailv = emailv;
	}


	public String getSenhav() {
		return senhav;
	}


	public void setSenhav(String senhav) {
		this.senhav = senhav;
	}


	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}


	public void setSENHA(String sENHA) {
		SENHA = sENHA;
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


	public Integer getPesemail() {
		return pesemail;
	}


	public void setPesemail(Integer pesemail) {
		this.pesemail = pesemail;
	}



	
	
	
}
	