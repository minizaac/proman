package br.ufmt.proman.usuario;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario,Integer> {
    
}
