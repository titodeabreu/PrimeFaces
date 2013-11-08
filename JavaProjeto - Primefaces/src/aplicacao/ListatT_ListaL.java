package aplicacao;

import pojo.Acesso;
import pojo.Endereco;
import pojo.Municipio;
import pojo.Pessoa;
import dao.HibernateDAO;

public class ListatT_ListaL {
	public static void main(String[] args) throws Exception {

		// Municipio-ListaT-ListaL------------------------------------------

		HibernateDAO<Municipio, Integer> DAOM5 = new HibernateDAO<Municipio, Integer>(
				Municipio.class);
		for (Object p : DAOM5.listaTudo())
			System.out.println(p);
		HibernateDAO<Municipio, Integer> DAOM6 = new HibernateDAO<Municipio, Integer>(
				Municipio.class);
		for (Object p : DAOM6.pagina(0, 10))
			System.out.println(p);
		HibernateDAO<Municipio, Integer> DAOM7 = new HibernateDAO<Municipio, Integer>(
				Municipio.class);
		for (Object p : DAOM7.listaLike("nomeMunicipio", "P%"))
			System.out.println(p);
		
		// Endereço-ListaT-ListaL------------------------------------------

		HibernateDAO<Endereco, Integer> DAOE6 = new HibernateDAO<Endereco,
				Integer>(
				Endereco.class);
		for (Object p : DAOE6.listaTudo())
			System.out.println(p);
		HibernateDAO<Endereco, Integer> DAOE7 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		for (Object p : DAOE7.pagina(0, 10))
			System.out.println(p);
		HibernateDAO<Endereco, Integer> DAOE8 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		for (Object p : DAOE8.listaLike("logradouro", "A%"))
			System.out.println(p);

		// Pessoa-ListaT-ListaL------------------------------------------

		HibernateDAO<Pessoa, Integer> DAOP5 = new
				HibernateDAO<Pessoa, Integer>(
						Pessoa.class);
		for (Object p : DAOP5.listaTudo())
			System.out.println(p);
		HibernateDAO<Pessoa, Integer> DAOP6 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		for (Object p : DAOP6.pagina(0, 10))
			System.out.println(p);
		HibernateDAO<Pessoa, Integer> DAOP7 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		for (Object p : DAOP7.listaLike("nome", "Carlos%"))
			System.out.println(p);
		
		// Acesso-ListaT-ListaL------------------------------------------

		HibernateDAO<Acesso, Integer> DAOA5 = new HibernateDAO<Acesso,
				Integer>(
				Acesso.class);
		for (Object p : DAOA5.listaTudo())
			System.out.println(p);
		HibernateDAO<Acesso, Integer> DAOA6 = new HibernateDAO<Acesso, Integer>(
				Acesso.class);
		for (Object c : DAOA6.pagina(0, 10))
			System.out.println(c);
		HibernateDAO<Acesso, Integer> DAOA7 = new HibernateDAO<Acesso, Integer>(
				Acesso.class);
		for (Object p : DAOA7.listaLike("email", "T%"))
			System.out.println(p);
		
		
	}
}