package aplicacao;

import pojo.Endereco;
import pojo.Municipio;
import pojo.Pessoa;
import dao.HibernateDAO;

public class Consulta {
	public static void main(String[] args) throws Exception {

		// Municipio-Consulta-------------------------------------------

		Municipio municipio = new Municipio();
		municipio.setIdMunicipio(1);
		HibernateDAO<Municipio, Integer> DAOM3 = new HibernateDAO<Municipio, Integer>(
				Municipio.class);
		municipio = (Municipio) DAOM3.consulta(municipio.getIdMunicipio());
		if (municipio.getIdMunicipio() > 0)

			System.out.println("Consulta: " + municipio);

		// Endereço-Consulta-------------------------------------------
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(1);

		HibernateDAO<Endereco, Integer> DAOE4 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		endereco = (Endereco) DAOE4.consulta(endereco.getIdEndereco());
		if (endereco.getIdEndereco() > 0)
			System.out.println("Consulta: " + endereco);

		// Pessoa-Consulta-------------------------------------------

		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(1);

		HibernateDAO<Pessoa, Integer> DAOP4 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		pessoa = (Pessoa) DAOP4.consulta(pessoa.getIdPessoa());
		if (pessoa.getIdPessoa() > 0)
			System.out.println("Consulta: " + pessoa);

	}
}