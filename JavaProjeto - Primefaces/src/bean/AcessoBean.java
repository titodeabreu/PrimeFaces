package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import dao.HibernateDAO;
import pojo.Acesso;




@ManagedBean(name = "acessoBean")
@SessionScoped

public class AcessoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String emailv;
	private String senha;
	private String senhav;
	private Acesso acesso;
	private String EMAIL = "titodeabreu@gmail.com";
	private String SENHA = "197346"; 
	
	
	
	public AcessoBean() {
		super();
		acesso = new Acesso();
		email = null;
		senha = null;
		this.EMAIL = "titodeabreu@gmail.com";
		this.SENHA = "197346"; 
	}
	
		
	public String validaLogin() {
		HibernateDAO<Acesso, String> regHBR = new HibernateDAO<Acesso, String>(Acesso.class);
		
		acesso = (Acesso) regHBR.consulta(email);
		
		
		try {
			
			if(acesso != null || this.EMAIL.equals(email)){
				
				
			
			
			if(this.EMAIL.equals(email) && this.SENHA.equals(senha)){
				
				return "adm";
			}
			emailv = acesso.getEmail();
			senhav = acesso.getSenha();
			
			if ((this.email.equals(emailv)) && (this.senha.equals(senhav)))
			 return "sucesso";
			
			
			}
			 
			
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha de consulta aos dados."));
			e.printStackTrace();
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Insira novamente", "Dados incorreto."));  
	
		return "erro";

	}
	
	 public String logout() {  
	      HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
	      sessao.invalidate();  
	      return "logout";
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
	
	
	
}
	