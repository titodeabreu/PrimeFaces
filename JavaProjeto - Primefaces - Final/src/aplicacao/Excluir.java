package aplicacao;

import java.sql.Timestamp;

import pojo.Acesso;
import pojo.Conversa;
import pojo.ConversaPK;
import pojo.Convite;
import pojo.ConvitePK;
import pojo.Endereco;
import pojo.Mensagem;
import pojo.MensagemPK;
import pojo.Municipio;
import pojo.Pessoa;
import dao.HibernateDAO;

public class Excluir {

	public static void main(String[] args) throws Exception {

		// Mensagem-Delete----------------------------------------
		Mensagem mensagem = new Mensagem();
		MensagemPK mensagemPk = new MensagemPK();
		String teste = "2013-09-13 14:21:49";
		Timestamp data = Timestamp.valueOf(teste);
		mensagemPk.setTimestampMensagem(data);
		mensagem.setTimestampMensagem(mensagemPk);

		HibernateDAO<Mensagem, Integer> MEN = new HibernateDAO<Mensagem, Integer>(
				Mensagem.class);
		if (MEN.exclui(mensagem))
			System.out.println("Excluído: " + mensagem);
		
		// Conversa-Delete----------------------------------------
		Conversa conversa = new Conversa();
		ConversaPK conversaPK = new ConversaPK();
		conversaPK.setTimestampConversa(1);
		conversa.setTimestampConversa(conversaPK);
		HibernateDAO<Conversa, Integer> CONVERS = new HibernateDAO<Conversa, Integer>(
				Conversa.class);
		if (CONVERS.exclui(conversa))
			System.out.println("Excluído: " + conversa);

		// Convite-Delete----------------------------------------

		 Convite convite = new Convite();
		ConvitePK convitePk = new ConvitePK();
		String testeConvite = "2013-09-13 14:21:49";
		Timestamp dataConvite = Timestamp.valueOf(testeConvite);
		convitePk.setTimestampConvite(dataConvite);
		convite.setTimestampConvite(convitePk);

		HibernateDAO<Convite, Integer> CONV = new HibernateDAO<Convite, Integer>(
				Convite.class);
		if (CONV.exclui(convite))
			System.out.println("Excluído: " + convite);
		
		// Acesso-Delete----------------------------------------
		Acesso acesso = new Acesso();
		acesso.setEmail("titodeabreu@gmail.com");
		HibernateDAO<Acesso, Integer> DAOA4 = new HibernateDAO<Acesso, Integer>(
				Acesso.class);
		if (DAOA4.exclui(acesso))
			System.out.println("Excluído: " + acesso);

		// Pessoa-Delete-1---------------------------------------
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setIdPessoa(0);

		HibernateDAO<Pessoa, Integer> PE1 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		if (PE1.exclui(pessoa1))
			System.out.println("Excluído: " + pessoa1);
		

		 //Pessoa-Delete-2---------------------------------------
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setIdPessoa(1);

		HibernateDAO<Pessoa, Integer> PE2 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		if (PE2.exclui(pessoa2))
			System.out.println("Excluído: " + pessoa2);

		

		// Endereço-Delete--------------------------------------------
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(1);
		HibernateDAO<Endereco, Integer> DAOE5 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		if (DAOE5.exclui(endereco))
			System.out.println("Excluído: " + endereco);

	 // Municipio-Delete-------------------------------------------
		Municipio municipio = new Municipio();
		municipio.setIdMunicipio(1);
		HibernateDAO<Municipio, Integer> DAOM4 = new HibernateDAO<Municipio, Integer>(
				Municipio.class);
		if (DAOM4.exclui(municipio))
			System.out.println("Excluído: " + municipio);

	}
}