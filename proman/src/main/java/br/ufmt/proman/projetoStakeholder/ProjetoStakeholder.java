package br.ufmt.proman.projetoStakeholder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.proman.projeto.Projeto;
import br.ufmt.proman.stakeholder.Stakeholder;

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

    @Column(name = "funcao_projeto_stakeholder", length = 100)
    private String funcaoProjetoStakeholder;

    @Column(name = "influencia_projeto_stakeholder", length = 100)
    private String influenciaProjetoStakeholder;

    @Column(name = "interesse_projeto_stakeholder", length = 100)
    private String interesseProjetoStakeholder;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "stakeholder_id")
    private Stakeholder stakeholder;

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
