package br.ufmt.proman.tarefaEquipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefa_equipe")
@SequenceGenerator(name = "seqTarefaEquipe", sequenceName = "seq_tarefa_equipe_id", allocationSize = 1)
@Getter
@Setter

public class TarefaEquipe {
    
    @Id
    @GeneratedValue(generator = "seqTarefaEquipe", strategy = GenerationType.SEQUENCE)
    private int idTarefaEquipe;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idTarefaEquipe;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TarefaEquipe other = (TarefaEquipe) obj;
        if (idTarefaEquipe != other.idTarefaEquipe)
            return false;
        return true;
    }
}
