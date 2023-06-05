package br.ufmt.proman.projetoUsuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.proman.projeto.Projeto;
import br.ufmt.proman.usuario.Usuario;

import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projeto_usuario")
@SequenceGenerator(name = "seqProjetoUsuario", sequenceName = "seq_projeto_usuario_id", allocationSize = 1)
@Getter
@Setter

public class ProjetoUsuario {
    
    @Id
    @GeneratedValue(generator = "seqProjetoUsuario", strategy = GenerationType.SEQUENCE)
    private int idProjetousuario;

    @Column(name = "relatorio_projeto_usuario", length = 1000)
    private String relatorioProjetoUsuario;
    
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idProjetousuario;
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
        ProjetoUsuario other = (ProjetoUsuario) obj;
        if (idProjetousuario != other.idProjetousuario)
            return false;
        return true;
    }
}
