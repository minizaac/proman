package br.ufmt.proman.tarefa;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface TarefaRepository extends JpaRepositoryImplementation<Tarefa,Integer> {
    
}
