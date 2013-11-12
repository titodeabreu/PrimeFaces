package aplicacao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class Incluir {

	public static void main(String[] args) throws Exception {

		// Municipio-ADD-------------------------------------------
		Municipio municipio = new Municipio();
		municipio.setIdMunicipio(3);
		municipio.setNomeMunicipio("Taguatinga");
		municipio.setUfMunicipio("DF");
		HibernateDAO<Municipio, Integer> DAOM1 = new HibernateDAO<Municipio, Integer>(
				Municipio.class);
		if (DAOM1.inclui(municipio))
			System.out.println("Inserido: " + municipio);

		// -----------------------------------------------------
		
		// Endereço-ADD--------------------------------------------
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(1);
		endereco.setLogradouro("Setor Leste");
		endereco.setComplemento("103");
		endereco.setBairro("Gama");
		endereco.setCep("70000002");
		Municipio mun = new Municipio();
		mun.setIdMunicipio(1);
		endereco.setMunicipio(mun);
		HibernateDAO<Endereco, Integer> DAOE2 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		if (DAOE2.inclui(endereco))
			System.out.println("Inserido: " + endereco);

		// -----------------------------------------------------

		// PESSOA ADD - 1----------------------------------------
		Pessoa p1 = new Pessoa();
		p1.setIdPessoa(0);
		p1.setNome("João da Silva");
		p1.setTelefone("006192450991");

		// Converter Data Pessoa 1
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String data = "09/09/2014";
		Date datanasc = formatador.parse(data);

		p1.setDataNascimento(datanasc);
		p1.setRg("2234498");
		p1.setOrgaoExpedicao("SSPDF");
		p1.setCpf("300000");

		// Objeto Endereço consulta Pessoa 1
		Endereco ender = new Endereco();
		HibernateDAO<Endereco, Integer> DAOE9 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		ender = (Endereco) DAOE9.consulta(1);

		p1.setEndereco(ender);

		// Incluir Pessoa 1
		HibernateDAO<Pessoa, Integer> DAOP2 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		if (DAOP2.inclui(p1))
			System.out.println("Inserido: " + p1);
		System.out.println(datanasc);

		// -----------------------------------------------------

		// PESSOA ADD - 2-----------------------------------------------
		Pessoa p2 = new Pessoa();
		p2.setIdPessoa(1);
		p2.setNome("João da Silva");
		p2.setTelefone("006192450991");

		// Converter Data Pessoa 2
		SimpleDateFormat formatador1 = new SimpleDateFormat("dd/MM/yyyy");
		String data1 = "12/11/2013";
		Date datanasc1 = formatador1.parse(data1);

		p2.setDataNascimento(datanasc1);
		p2.setRg("2234498");
		p2.setOrgaoExpedicao("SSPDF");
		p2.setCpf("300000");

		// Objeto Endereço consulta Pessoa 2
		Endereco ender1 = new Endereco();
		HibernateDAO<Endereco, Integer> DAOE10 = new HibernateDAO<Endereco, Integer>(
				Endereco.class);
		ender1 = (Endereco) DAOE10.consulta(1);

		p2.setEndereco(ender1);

		// Incluir Pessoa 1
		HibernateDAO<Pessoa, Integer> DAOP = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);

		if (DAOP.inclui(p2))
			System.out.println("Inserido: " + p2);
		System.out.println(datanasc1);

		// --------------------------------------------------------
		// Acesso-ADD----------------------------------------------
		Acesso acesso = new Acesso();
		acesso.setEmail("titodeabreu@gmail.com");
		acesso.setSenha("12345");

		HibernateDAO<Acesso, Integer> DAOA1 = new HibernateDAO<Acesso, Integer>(
				Acesso.class);
		if (DAOA1.inclui(acesso))
			System.out.println("Inserido: " + acesso);

		// --------------------------------------------------------
		// Convite-ADD---------------------------------------------
		Convite convite = new Convite();
		// TimeStamp Tempo da maquina... para convite
		ConvitePK conpk = new ConvitePK();
		java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		java.sql.Date date = new java.sql.Date(timeStamp.getTime());
		conpk.setTimestampConvite(date);

		convite.setTimestampConvite(conpk);

		// Selecionar Pessoa 1

		Pessoa pc1 = new Pessoa();
		HibernateDAO<Pessoa, Integer> PEC1 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		pc1 = (Pessoa) PEC1.consulta(0);

		convite.setPessoa1(pc1);

		// Selecionar Pessoa 2

		Pessoa pc2 = new Pessoa();
		HibernateDAO<Pessoa, Integer> PEC2 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		pc2 = (Pessoa) PEC2.consulta(1);

		convite.setPessoa2(pc2);

		// Resposta/Tempo
		convite.setAceiteConvite("S");

		convite.setTimestampRecebimento(timeStamp);

		HibernateDAO<Convite, Integer> CON = new HibernateDAO<Convite, Integer>(
				Convite.class);

		if (CON.inclui(convite))
			System.out.println("Inserido: " + convite);

		// --------------------------------------------------------

		Conversa conversa = new Conversa();

		// Era pra ser timeStamp porém causa erro no banco de dados, inserido
		// como inteiro.
		ConversaPK conversapk = new ConversaPK();
		conversapk.setTimestampConversa(1);

		conversa.setTimestampConversa(conversapk);

		// TimeStamp Tempo da maquina... para conversa
		java.sql.Timestamp timeStampConversa = new Timestamp(
				System.currentTimeMillis());

		conversa.setTimestampAceite(timeStampConversa);

		// Selecionar Pessoa Conversa 1

		Pessoa pcon1 = new Pessoa();
		HibernateDAO<Pessoa, Integer> PEConv1 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		pcon1 = (Pessoa) PEConv1.consulta(0);

		conversa.setPessoa1(pcon1);

		// Selecionar Pessoa Conversa 2

		Pessoa pcon2 = new Pessoa();
		HibernateDAO<Pessoa, Integer> PEConv2 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		pcon2 = (Pessoa) PEConv2.consulta(1);

		conversa.setPessoa2(pcon2);

		// Incluir

		HibernateDAO<Conversa, Integer> CONV = new HibernateDAO<Conversa, Integer>(
				Conversa.class);

		if (CONV.inclui(conversa))
			System.out.println("Inserido: " + conversa);

		// --------------------------------------------------------

		// -----------------------------------------------------

		Mensagem mensagem = new Mensagem();

		MensagemPK mensagemPk = new MensagemPK();
		java.sql.Timestamp timeStampMensagem = new Timestamp(
				System.currentTimeMillis());
		java.sql.Date dateMensagem = new java.sql.Date(
				timeStampMensagem.getTime());
		mensagemPk.setTimestampMensagem(dateMensagem);

		mensagem.setTimestampMensagem(mensagemPk);

		mensagem.setTextoMensagem("VOCE CONSEGUIU");

		ConversaPK conversaPK = new ConversaPK();
		conversaPK.setTimestampConversa(1);

		Conversa conversaID = new Conversa();
		conversaID.setTimestampConversa(conversaPK);

		mensagem.setTimestampConversa(conversaID);

		// Selecionar Pessoa Mensagem 1
		Pessoa pcm1 = new Pessoa();
		HibernateDAO<Pessoa, Integer> PCM1 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		pcm1 = (Pessoa) PCM1.consulta(0);

		mensagem.setPessoa1(pcm1);

		// Selecionar Pessoa Mensagem 2
		Pessoa pcm2 = new Pessoa();
		HibernateDAO<Pessoa, Integer> PCM2 = new HibernateDAO<Pessoa, Integer>(
				Pessoa.class);
		pcm2 = (Pessoa) PCM2.consulta(1);

		mensagem.setPessoa2(pcm2);

		HibernateDAO<Mensagem, Integer> M = new HibernateDAO<Mensagem, Integer>(
				Mensagem.class);

		if (M.inclui(mensagem))
			System.out.println("Inserido: " + mensagem);

	}
}