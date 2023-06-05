package br.ufmt.proman.projetoEquipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projeto_equipe")
@SequenceGenerator(name = "seqProjetoEquipe", sequenceName = "seq_projeto_equipe_id", allocationSize = 1)
@Getter
@Setter

public class ProjetoEquipe {
    
    @Id
    @GeneratedValue(generator = "seqProjetoEquipe", strategy = GenerationType.SEQUENCE)
    private int idProjetoEquipe;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idProjetoEquipe;
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
        ProjetoEquipe other = (ProjetoEquipe) obj;
        if (idProjetoEquipe != other.idProjetoEquipe)
            return false;
        return true;
    }
}
