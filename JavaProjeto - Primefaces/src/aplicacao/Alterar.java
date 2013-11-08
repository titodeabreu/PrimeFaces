package aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;

import pojo.Acesso;

import pojo.Endereco;
import pojo.Municipio;
import pojo.Pessoa;
import dao.HibernateDAO;

public class Alterar {

	public static void main(String[] args) throws Exception {

		// Municipio-Alterar----------------------------------------

		Municipio municipio = new Municipio();
		municipio.setIdMunicipio(1);
		municipio.setNomeMunicipio("Praia da barra");
		municipio.setUfMunicipio("RJ");
		HibernateDAO<Municipio, Integer> DAOM2 = new HibernateDAO<Municipio, Integer>(
				Municipio.class);
		if (DAOM2.altera(municipio))
			System.out.println("Alterado: " + municipio);

		// Endereço-Alterar--------------------------------------------

		Endereco endereco = new Endereco();
		endereco.setIdEndereco(1);
		endereco.setLogradouro("Arapoanga");
		endereco.setComplemento("205");
		endereco.setBairro("Lago Sul");
		endereco.setCep("71111111");
		Municipio mun = new Municipio();
		mun.setIdMunicipio(1);
		endereco.setMunicipio(mun);
		HibernateDAO<Endereco, Integer> DAOE3 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		if (DAOE3.altera(endereco))
			System.out.println("Alterado: " + endereco);

		// Pessoa-Alterar--------------------------------------------

		Pessoa p1 = new Pessoa();
		p1.setIdPessoa(0);
		p1.setNome("Carlos da Silva");
		p1.setTelefone("1113425500");

		// Converter Data Pessoa
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String data = "10/12/2022";
		Date datanasc = formatador.parse(data);

		p1.setDataNascimento(datanasc);
		p1.setRg("555555");
		p1.setOrgaoExpedicao("SSPRJ");
		p1.setCpf("02755541054");

		// Objeto Endereço consulta Pessoa 
		Endereco ender = new Endereco();
		HibernateDAO<Endereco, Integer> DAOE9 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		ender = (Endereco) DAOE9.consulta(1);

		p1.setEndereco(ender);
		
		HibernateDAO<Pessoa, Integer> DAOP3 = new
		HibernateDAO<Pessoa, Integer>(
		Pessoa.class);
		if (DAOP3.altera(p1))
			System.out.println("Alterado: " + p1);
		
		// Acesso-Alterar--------------------------------------------
		
		Acesso acesso = new Acesso();
		acesso.setEmail("titodeabreu@gmail.com");
		acesso.setSenha("197346");
		
		HibernateDAO<Acesso, Integer> DAOA2 = new HibernateDAO<Acesso,
		Integer>(
		Acesso.class);
		if (DAOA2.altera(acesso))
		System.out.println("Alterado: " + acesso);
				

	}
}