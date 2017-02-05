package gerenciamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(generator="STORE_SEQ")
	@SequenceGenerator(name="STORE_SEQ",sequenceName="STORE_SEQ", allocationSize=1)
	private Long usuarioId;
	
	private String nomeUsuario;
	private String emailUsuario;
	private String linkGitHubUsuario;
	
	public Usuario(){}
	
	public Usuario(String nome, String email, String link){
		this.nomeUsuario = nome;
		this.emailUsuario = email;
		this.linkGitHubUsuario = link;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getLinkGitHubUsuario() {
		return linkGitHubUsuario;
	}

	public void setLinkGitHubUsuario(String linkGitHubUsuario) {
		this.linkGitHubUsuario = linkGitHubUsuario;
	}
	
	@Override
	public String toString(){
		return this.getNomeUsuario() + ", " + this.emailUsuario;
	}
}
