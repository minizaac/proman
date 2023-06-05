package br.ufmt.proman.stakeholder;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.proman.projetoStakeholder.ProjetoStakeholder;

import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stakeholder")
@SequenceGenerator(name = "seqStakeholder", sequenceName = "seq_stakeholder_id", allocationSize = 1)
@Getter
@Setter

public class Stakeholder {
    
    @Id
    @GeneratedValue(generator = "seqStakeholder", strategy = GenerationType.SEQUENCE)
    private int idStakeholder;

    @Column(name = "nome_stakeholder", length = 100)
    private String nomeStakeholder;

    @Column(name = "funcao_stakeholder", length = 100)
    private String funcaoStakeholder;

    @Column(name = "influencia_stakeholder", length = 100)
    private String influenciaStakeholder;

    @Column(name = "interesse_stakeholder", length = 100)
    private String interesseStakeholder;

    @OneToMany(mappedBy = "stakeholder")
    private List<ProjetoStakeholder> projetoStakeholders;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idStakeholder;
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
        Stakeholder other = (Stakeholder) obj;
        if (idStakeholder != other.idStakeholder)
            return false;
        return true;
    }
}
