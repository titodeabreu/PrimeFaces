package pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPessoa;

	@Column(name = "CPF", nullable = false)
	private String cpf;

	@Column(name = "CTPS", nullable = false)
	private String ctps;

	@Column(name = "dataNascimento", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "orgaoExpedicao", nullable = false)
	private String orgaoExpedicao;

	@Column(name = "RG", nullable = false)
	private String rg;

	@Column(name = "telefone", nullable = false)
	private String telefone;

	private int tipoPessoa;

	@OneToMany(orphanRemoval = true, mappedBy="pessoa1")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Conversa> conversas1;

	@OneToMany(orphanRemoval = true, mappedBy="pessoa2")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Conversa> conversas2;

	@OneToMany(orphanRemoval = true, mappedBy="pessoa1")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Convite> convites1;

	@OneToMany(orphanRemoval = true, mappedBy="pessoa2")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Convite> convites2;

	@ManyToOne
	private Endereco endereco;

	@OneToOne(cascade = {javax.persistence.CascadeType.ALL})
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	private Acesso acesso;
	

	public Pessoa() {
	}
	
	





	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", cpf=" + cpf + ", ctps="
				+ ctps + ", dataNascimento=" + dataNascimento + ", nome="
				+ nome + ", orgaoExpedicao=" + orgaoExpedicao + ", rg=" + rg
				+ ", telefone=" + telefone + ", tipoPessoa=" + tipoPessoa
				+ ", conversas1=" + conversas1 + ", conversas2=" + conversas2
				+ ", convites1=" + convites1 + ", convites2=" + convites2
				+ ", endereco=" + endereco + ", acesso=" + acesso + "]";
	}







	public int getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCtps() {
		return this.ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrgaoExpedicao() {
		return this.orgaoExpedicao;
	}

	public void setOrgaoExpedicao(String orgaoExpedicao) {
		this.orgaoExpedicao = orgaoExpedicao;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Conversa> getConversas1() {
		return this.conversas1;
	}

	public void setConversas1(List<Conversa> conversas1) {
		this.conversas1 = conversas1;
	}

	public Conversa addConversas1(Conversa conversas1) {
		getConversas1().add(conversas1);
		conversas1.setPessoa1(this);

		return conversas1;
	}

	public Conversa removeConversas1(Conversa conversas1) {
		getConversas1().remove(conversas1);
		conversas1.setPessoa1(null);

		return conversas1;
	}

	public List<Conversa> getConversas2() {
		return this.conversas2;
	}

	public void setConversas2(List<Conversa> conversas2) {
		this.conversas2 = conversas2;
	}

	public Conversa addConversas2(Conversa conversas2) {
		getConversas2().add(conversas2);
		conversas2.setPessoa2(this);

		return conversas2;
	}

	public Conversa removeConversas2(Conversa conversas2) {
		getConversas2().remove(conversas2);
		conversas2.setPessoa2(null);

		return conversas2;
	}

	public List<Convite> getConvites1() {
		return this.convites1;
	}

	public void setConvites1(List<Convite> convites1) {
		this.convites1 = convites1;
	}

	public Convite addConvites1(Convite convites1) {
		getConvites1().add(convites1);
		convites1.setPessoa1(this);

		return convites1;
	}

	public Convite removeConvites1(Convite convites1) {
		getConvites1().remove(convites1);
		convites1.setPessoa1(null);

		return convites1;
	}

	public List<Convite> getConvites2() {
		return this.convites2;
	}

	public void setConvites2(List<Convite> convites2) {
		this.convites2 = convites2;
	}

	public Convite addConvites2(Convite convites2) {
		getConvites2().add(convites2);
		convites2.setPessoa2(this);

		return convites2;
	}

	public Convite removeConvites2(Convite convites2) {
		getConvites2().remove(convites2);
		convites2.setPessoa2(null);

		return convites2;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Acesso getAcesso() {
		return this.acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

}