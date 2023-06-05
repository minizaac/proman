package br.ufmt.proman.equipe;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/projeto")
@RequiredArgsConstructor

public class EquipeController {

    private final EquipeRepository repository;

    @GetMapping(path = "/")
    public List<Equipe> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EquipeResponse> getById(@PathVariable int id){
        Optional<Equipe> found = repository.findById(id);
        if (found.isPresent()){
            EquipeResponse response = EquipeResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{pk}")
    public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();

        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody EquipeRequest request){
        Equipe equipe = new Equipe();

        equipe.setNomeEquipe(request.getNomeEquipe());
        equipe.setDescricaoEquipe(request.getDescricaoEquipe());

        try {
            repository.save(equipe);

        } catch (IllegalArgumentException erro) {
            return ResponseEntity.badRequest().body("Dados invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody EquipeRequest request){
        Equipe equipe = new Equipe();

        equipe.setNomeEquipe(request.getNomeEquipe());
        equipe.setDescricaoEquipe(request.getDescricaoEquipe());

        try {
            repository.save(equipe);
        } catch (IllegalArgumentException erro) {
            erro.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
