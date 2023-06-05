package br.ufmt.proman.projetoStakeholder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projeto_stakeholder")
@SequenceGenerator(name = "seqProjetoStakeholder", sequenceName = "seq_projeto_stakeholder_id", allocationSize = 1)
@Getter
@Setter

public class ProjetoStakeholder {
    
    @Id
    @GeneratedValue(generator = "seqProjetoStakeholder", strategy = GenerationType.SEQUENCE)
    private int idProjetoStakeholder;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idProjetoStakeholder;
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
        ProjetoStakeholder other = (ProjetoStakeholder) obj;
        if (idProjetoStakeholder != other.idProjetoStakeholder)
            return false;
        return true;
    }
}
