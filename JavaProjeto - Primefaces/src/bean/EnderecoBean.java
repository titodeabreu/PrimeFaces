package bean;

import java.io.Serializable;
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
import pojo.Municipio;


@ManagedBean(name = "enderecoBean")
@RequestScoped

public class EnderecoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Endereco endereco;
	private List<Endereco> listagem;
	private List<Municipio> listMun;
	private String filtro;
	private int inicio;
	private int fim;
	private Integer idMun;
	
	
	
	public EnderecoBean() {
		endereco = new Endereco();
		listagem = null;
		listMun = null;
		filtro = new String();
		inicio = 0;
		fim = 0;
		idMun = 0;
		
	}

	

	
	public void include(ActionEvent event) {
		try {
			
			//EnderecoHibernate include_Mun = new EnderecoHibernate(); - Show the class who will be instantiated - - - - - - - -
			HibernateDAO<Endereco, Integer> include_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
			Municipio mun = new Municipio();
			mun.setIdMunicipio(idMun);
			endereco.setMunicipio(mun);
			if (include_End.inclui(endereco)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "INFO!Incluído.",
						"endereco incluido com sucesso."));
			}
		} catch (ConstraintViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,	 "ERRO!Chave estrangeira.",
					"Chave primária já existe. endereco duplicado."));
			e.printStackTrace();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!Acesso ao Banco de Dados",
					"Falha na inclusão dos dados."));
			e.printStackTrace();
		}
		// Caso queira retornar para uma outra pagina utilizar:
		// return "incluirEndereco.jsp"
	}
	
	public void delete(ActionEvent event) {
		try {
			// EnderecoHibernate consulta_Mun = new EnderecoHibernate();

			HibernateDAO<Endereco, Integer> consult_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
			endereco = (Endereco) consult_End.consulta(endereco.getIdEndereco());

			HibernateDAO<Endereco, Integer> delete_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
			if (delete_End.exclui(endereco)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "INFO! endereco excluído.",
						"endereco excluído com sucesso."));
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
		// return "excluirEndereco.jsp"
	}

	public void alter(ActionEvent event) {
		try {
			// EnderecoHibernate regHBR = new EnderecoHibernate();
			HibernateDAO<Endereco, Integer> alter_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
			if (alter_End.altera(endereco)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "INFO!",
						"endereco alterado com sucesso."));
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
		// return "alterarEndereco.jsp"
	}

	public void consult(ActionEvent event) {
		try {
			// EnderecoHibernate regHBR = new EnderecoHibernate();
			HibernateDAO<Endereco, Integer> consult_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
			endereco = (Endereco) consult_End.consulta(endereco.getIdEndereco());
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
		// return "consultarEndereco.jsp"
	}

	public List<Endereco> listAll() {
		try {
			// EnderecoHibernate regHBR = new EnderecoHibernate();
			HibernateDAO<Endereco, Integer> listAll_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
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
			HibernateDAO<Endereco, Integer> listAll_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
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
			// EnderecoHibernate listPage_Mun = new EnderecoHibernate();
			HibernateDAO<Endereco, Integer> listPage_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
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
			// EnderecoHibernate listLike_Mun = new EnderecoHibernate();
			HibernateDAO<Endereco, Integer> listLike_End = new HibernateDAO<Endereco, Integer>(
					Endereco.class);
			listagem = listLike_End.listaLike("nomeEndereco", filtro);
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha na consulta aos dados."));
			e.printStackTrace();
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getListagem() {
		return listagem;
	}

	public void setListagem(List<Endereco> listagem) {
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


	public List<Municipio> getListMun() {
		return listMun;
	}




	public void setListMun(List<Municipio> listMun) {
		this.listMun = listMun;
	}





	public Integer getIdMun() {
		return idMun;
	}




	public void setIdMun(Integer idMun) {
		this.idMun = idMun;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	
	
}