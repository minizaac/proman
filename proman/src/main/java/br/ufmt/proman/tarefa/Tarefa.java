package br.ufmt.proman.tarefa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufmt.proman.projeto.Projeto;
import br.ufmt.proman.tarefaEquipe.TarefaEquipe;

import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefa")
@SequenceGenerator(name = "seqTarefa", sequenceName = "seq_tarefa_id", allocationSize = 1)
@Getter
@Setter

public class Tarefa {
    
    @Id
    @GeneratedValue(generator = "seqTarefa", strategy = GenerationType.SEQUENCE)
    private int idTarefa;

    /*@Column(name = "nome_tarefa", length = 100)
    private String nomeTarefa;*/

    @Column(name = "descricao_tarefa", length = 1000)
    private String descricaoTarefa;

    @Column(name = "data_criacao_tarefa")
    @Temporal(TemporalType.DATE)
    private Date dataCriacaoTarefa; //alterar para dataInicioTarefa

    @Column(name = "data_conclusao_tarefa")
    @Temporal(TemporalType.DATE)
    private Date dataConclusaoTarefa;

    @Column(name = "status_tarefa", length = 100)
    private String statusTarefa;

    @OneToMany(mappedBy = "tarefa")
    private List<TarefaEquipe> tarefaEquipes;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idTarefa;
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
        Tarefa other = (Tarefa) obj;
        if (idTarefa != other.idTarefa)
            return false;
        return true;
    }

}
