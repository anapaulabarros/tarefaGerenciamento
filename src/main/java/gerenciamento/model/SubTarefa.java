package gerenciamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class SubTarefa {

	@Id
	@GeneratedValue(generator="STORE_SEQ")
	@SequenceGenerator(name="STORE_SEQ",sequenceName="STORE_SEQ", allocationSize=1)
	private Long subTarefaId;
	
	private String nomeSubTarefa;
	
	public SubTarefa(){}
	
	public SubTarefa(String nomeSubTarefa){
		this.nomeSubTarefa = nomeSubTarefa;
	}

	public Long getSubTarefaId() {
		return subTarefaId;
	}

	public void setSubTarefaId(Long subTarefaId) {
		this.subTarefaId = subTarefaId;
	}

	public String getNomeSubTarefa() {
		return nomeSubTarefa;
	}

	public void setNomeSubTarefa(String nomeSubTarefa) {
		this.nomeSubTarefa = nomeSubTarefa;
	}
	
	@Override
	public String toString(){
		return this.nomeSubTarefa;
	}
}
