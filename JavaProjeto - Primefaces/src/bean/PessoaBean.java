package bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;

import dao.HibernateDAO;
import pojo.Endereco;
import pojo.Pessoa;


@ManagedBean(name = "pessoaBean")
@RequestScoped

public class PessoaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private List<Pessoa> listagem;
	private List<Endereco> listEnd;
	private String filtro;
	private int inicio;
	private int fim;
	private Integer idEnd;
	private String dateConvert;
	
	
	
	public PessoaBean() {
		pessoa = new Pessoa();
		listagem = null;
		filtro = new String();
		inicio = 0;
		fim = 0;
		dateConvert = null;
		idEnd = 0;
	}

	

	
	public void include(ActionEvent event) throws ParseException {
		try {
			
			//PessoaHibernate include_Mun = new PessoaHibernate(); - Show the class who will be instantiated - - - - - - - -
			HibernateDAO<Pessoa, Integer> include_Pes = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			Date datanasc = formatador.parse(dateConvert);
			pessoa.setDataNascimento(datanasc);
			Endereco end = new Endereco();
			end.setIdEndereco(idEnd);
			pessoa.setEndereco(end);
			if (include_Pes.inclui(pessoa)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "INFO!Incluído.",
						"Pessoa incluido com sucesso."));
			}
		} catch (ConstraintViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,	 "ERRO!Chave estrangeira.",
					"Chave primária já existe. Pessoa duplicado."));
			e.printStackTrace();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!Acesso ao Banco de Dados",
					"Falha na inclusão dos dados."));
			e.printStackTrace();
		}
		// Caso queira retornar para uma outra pagina utilizar:
		// return "incluirPessoa.jsp"
	}
	
	public void delete(ActionEvent event) {
		try {
			// PessoaHibernate consulta_Mun = new PessoaHibernate();

			HibernateDAO<Pessoa, Integer> consult_End = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			pessoa = (Pessoa) consult_End.consulta(pessoa.getIdPessoa());

			HibernateDAO<Pessoa, Integer> delete_End = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			if (delete_End.exclui(pessoa)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "INFO! Pessoa excluído.",
						"Pessoa excluído com sucesso."));
			}
		} catch (ObjectNotFoundException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO! Objeto não localizado.",
					"Objeto não localizado."));
			e.printStackTrace();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO! Acesso ao Banco de Dados.",
					"Falha na exclusão dos dados."));
			e.printStackTrace();
		}
		// return "excluirPessoa.jsp"
	}

	public void alter(ActionEvent event) {
		try {
			// PessoaHibernate regHBR = new PessoaHibernate();
			HibernateDAO<Pessoa, Integer> alter_End = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			if (alter_End.altera(pessoa)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "INFO!",
						"Pessoa alterado com sucesso."));
			}
		} catch (ObjectNotFoundException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Objeto não localizado."));
			e.printStackTrace();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha na exclusão dos dados."));
			e.printStackTrace();
		}
		// return "alterarPessoa.jsp"
	}

	public void consult(ActionEvent event) {
		try {
			// PessoaHibernate regHBR = new PessoaHibernate();
			HibernateDAO<Pessoa, Integer> consult_End = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			pessoa = (Pessoa) consult_End.consulta(pessoa.getIdPessoa());
		} catch (ObjectNotFoundException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Objeto não localizado."));
			e.printStackTrace();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha de consulta aos dados."));
			e.printStackTrace();
		}
		// return "consultarPessoa.jsp"
	}

	public List<Pessoa> listAll() {
		try {
			// PessoaHibernate regHBR = new PessoaHibernate();
			HibernateDAO<Pessoa, Integer> listAll_End = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			return listAll_End.listaTudo();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha na consulta aos dados."));
			e.printStackTrace();
			return null;
		}
	}
		
	public void listAlls(ActionEvent event) {
		try {
			// MunicipioHibernate regHBR = new MunicipioHibernate();
			HibernateDAO<Pessoa, Integer> listAll_End = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			listagem = listAll_End.listaTudo();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha na consulta aos dados."));
			e.printStackTrace();
		}
		
	}

	public void listPage(ActionEvent event) {
		try {
			// PessoaHibernate listPage_Mun = new PessoaHibernate();
			HibernateDAO<Pessoa, Integer> listPage_End = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			listagem = listPage_End.pagina(inicio, fim);
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha na consulta aos dados."));
			e.printStackTrace();
		}
	}

	public void listLike(ActionEvent event) {
		try {
			// PessoaHibernate listLike_Mun = new PessoaHibernate();
			HibernateDAO<Pessoa, Integer> listLike_End = new HibernateDAO<Pessoa, Integer>(
					Pessoa.class);
			listagem = listLike_End.listaLike("nomePessoa", filtro);
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha na consulta aos dados."));
			e.printStackTrace();
		}
	}
	



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}




	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}




	public List<Pessoa> getListagem() {
		return listagem;
	}




	public void setListagem(List<Pessoa> listagem) {
		this.listagem = listagem;
	}




	public String getFiltro() {
		return filtro;
	}




	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}




	public int getInicio() {
		return inicio;
	}




	public void setInicio(int inicio) {
		this.inicio = inicio;
	}




	public int getFim() {
		return fim;
	}




	public void setFim(int fim) {
		this.fim = fim;
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




	public List<Endereco> getListEnd() {
		return listEnd;
	}




	public void setListEnd(List<Endereco> listEnd) {
		this.listEnd = listEnd;
	}








	
	
}