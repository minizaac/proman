package br.ufmt.proman.usuarioEquipe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_equipe")
@SequenceGenerator(name = "seqUsuarioEquipe", sequenceName = "seq_usuario_equipe_id", allocationSize = 1)
@Getter
@Setter

public class UsuarioEquipe {
    
    @Id
    @GeneratedValue(generator = "seqUsuarioEquipe", strategy = GenerationType.SEQUENCE)
    private int idUsuarioEquipe;

    @Column(name = "cargo_usuario_equipe", length = 100)
    private String cargoUsuarioEquipe;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idUsuarioEquipe;
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
        UsuarioEquipe other = (UsuarioEquipe) obj;
        if (idUsuarioEquipe != other.idUsuarioEquipe)
            return false;
        return true;
    }
}
