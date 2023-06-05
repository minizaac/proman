package br.ufmt.proman.equipe;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.proman.projetoEquipe.ProjetoEquipe;
import br.ufmt.proman.tarefaEquipe.TarefaEquipe;
import br.ufmt.proman.usuarioEquipe.UsuarioEquipe;

import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipe")
@SequenceGenerator(name = "seqEquipe", sequenceName = "seq_equipe_id", allocationSize = 1)
@Getter
@Setter

public class Equipe {
    
    @Id
    @GeneratedValue(generator = "seqEquipe", strategy = GenerationType.SEQUENCE)
    private int idEquipe;

    @Column(name = "nome_equipe", length = 100)
    private String nomeEquipe;

    @Column(name = "descricao_equipe", length = 1000)
    private String descricaoEquipe;

    @OneToMany(mappedBy = "equipe")
    private List<UsuarioEquipe> usuarioEquipes;

    @OneToMany(mappedBy = "equipe")
    private List<ProjetoEquipe> projetoEquipes;

    @OneToMany(mappedBy = "equipe")
    private List<TarefaEquipe> tarefaEquipes;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idEquipe;
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
        Equipe other = (Equipe) obj;
        if (idEquipe != other.idEquipe)
            return false;
        return true;
    }
}
