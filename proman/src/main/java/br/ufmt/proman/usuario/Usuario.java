package br.ufmt.proman.usuario;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.proman.projetoUsuario.ProjetoUsuario;
import br.ufmt.proman.usuarioEquipe.UsuarioEquipe;

import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@SequenceGenerator(name = "seqUsuario", sequenceName = "seq_usuario_id", allocationSize = 1)
@Getter
@Setter

public class Usuario {

    @Id
    @GeneratedValue(generator = "seqUsuario", strategy = GenerationType.SEQUENCE)
    private int idUsuario;

    @Column(name = "nome_usuario", length = 100)
    private String nomeUsuario;

    @Column(name = "email_usuario", length = 100)
    private String emailUsuario;

    @Column(name = "senha_usuario", length = 100)
    private String senhaUsuario;

    @Column(name = "permissoes_usuario", length = 100)
    private String permissoesusuario;

    @OneToMany(mappedBy = "usuario")
    private List<ProjetoUsuario> projetoUsuarios;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioEquipe> usuarioEquipes;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idUsuario;
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
        Usuario other = (Usuario) obj;
        if (idUsuario != other.idUsuario)
            return false;
        return true;
    }
}
