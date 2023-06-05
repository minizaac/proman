package br.ufmt.proman.projeto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufmt.proman.projetoEquipe.ProjetoEquipe;
import br.ufmt.proman.projetoStakeholder.ProjetoStakeholder;
import br.ufmt.proman.projetoUsuario.ProjetoUsuario;

import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projeto")
@SequenceGenerator(name = "seqProjeto", sequenceName = "seq_projeto_id", allocationSize = 1)
@Getter
@Setter

public class Projeto {
    
    @Id
    @GeneratedValue(generator = "seqProjeto", strategy = GenerationType.SEQUENCE)
    private int idProjeto;

    @Column(name = "nome_projeto", length = 100)
    private String nomeProjeto;

    @Column(name = "descricao_projeto", length = 1000)
    private String descricaoProjeto;

    @Column(name = "data_inicio_projeto")
    @Temporal(TemporalType.DATE)
    private Date dataInicioProjeto;

    @Column(name = "data_conclusao_projeto")
    @Temporal(TemporalType.DATE)
    private Date dataConclusaoProjeto;

    @Column(name = "status_projeto", length = 100)
    private String statusProjeto;

    @Column(name = "fase_projeto", length = 1000)
    private String faseProjeto;

    @OneToMany(mappedBy = "projeto")
    private List<ProjetoStakeholder> projetoStakeholders;

    @OneToMany(mappedBy = "projeto")
    private List<ProjetoEquipe> projetoEquipes;

    @OneToMany(mappedBy = "projeto")
    private List<ProjetoUsuario> projetoUsuarios;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idProjeto;
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
        Projeto other = (Projeto) obj;
        if (idProjeto != other.idProjeto)
            return false;
        return true;
    }

}
