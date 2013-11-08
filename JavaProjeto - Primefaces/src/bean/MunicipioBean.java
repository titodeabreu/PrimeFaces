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
import org.primefaces.context.RequestContext;

import dao.HibernateDAO;
import pojo.Municipio;

@ManagedBean(name = "municipioBean")
@RequestScoped

public class MunicipioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Municipio municipio;
	private List<Municipio> listagem;
	private String filtro;
	private int inicio;
	private int fim;
	

	public MunicipioBean() {
		municipio = new Municipio();
		listagem = null;
		filtro = new String();
		inicio = 0;
		fim = 0;
	}
	
	public void reset() {  
        RequestContext.getCurrentInstance().reset("form:panel");  
    }  

	public void include(ActionEvent event) {
		try {
			//MunicipioHibernate include_Mun = new MunicipioHibernate(); - Show the class who will be instantiated - - - - - - - -
			HibernateDAO<Municipio, Integer> include_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			
			if (include_Mun.inclui(municipio)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Operação Concluida", "Municipio " + municipio.getNomeMunicipio() +" incluido com sucesso."));  
			}
		} catch (ConstraintViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!Chave estrangeira.",
					"Chave primária já existe. Municipio duplicado."));
			e.printStackTrace();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!Acesso ao Banco de Dados",
					"Falha na inclusão dos dados."));
			e.printStackTrace();
		}
		// Caso queira retornar para uma outra pagina utilizar:
		// return "incluirMunicipio.jsp"
	}

	public void delete(ActionEvent event) {
		try {
			// MunicipioHibernate consulta_Mun = new MunicipioHibernate();

			HibernateDAO<Municipio, Integer> consult_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			municipio = (Municipio) consult_Mun.consulta(municipio.getIdMunicipio());

			HibernateDAO<Municipio, Integer> delete_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			if (delete_Mun.exclui(municipio)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Operação Concluida", "Municipio " + municipio.getNomeMunicipio() +" excluido com sucesso."));  

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
		// return "excluirMunicipio.jsp"
	}

	public void alter(ActionEvent event) {
		try {
			// MunicipioHibernate regHBR = new MunicipioHibernate();
			HibernateDAO<Municipio, Integer> alter_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			if (alter_Mun.altera(municipio)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "INFO!",
						"municipio alterado com sucesso."));
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
		// return "alterarMunicipio.jsp"
	}

	public void consult(ActionEvent event) {
		try {
			// MunicipioHibernate regHBR = new MunicipioHibernate();
			HibernateDAO<Municipio, Integer> consult_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			municipio = (Municipio) consult_Mun.consulta(municipio.getIdMunicipio());
		} catch (ObjectNotFoundException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Não Encontrado", "Municipio não foi encontrado."));  
			e.printStackTrace();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Não Encontrado", "Falha na Consulta.")); 
			e.printStackTrace();
		}
		// return "consultarMunicipio.jsp"
	}

	public List<Municipio> listAll() {
		try {
			// MunicipioHibernate regHBR = new MunicipioHibernate();
			HibernateDAO<Municipio, Integer> listAll_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			return listAll_Mun.listaTudo();
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
			HibernateDAO<Municipio, Integer> listAll_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			listagem = listAll_Mun.listaTudo();
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
			// MunicipioHibernate listPage_Mun = new MunicipioHibernate();
			HibernateDAO<Municipio, Integer> listPage_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			listagem = listPage_Mun.pagina(inicio, fim);
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
			// MunicipioHibernate listLike_Mun = new MunicipioHibernate();
			HibernateDAO<Municipio, Integer> listLike_Mun = new HibernateDAO<Municipio, Integer>(
					Municipio.class);
			listagem = listLike_Mun.listaLike("nomeMunicipio", filtro);
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!",
					"Falha na consulta aos dados."));
			e.printStackTrace();
		}
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Municipio> getListagem() {
		return listagem;
	}

	public void setListagem(List<Municipio> listagem) {
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

}