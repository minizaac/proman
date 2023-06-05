package br.ufmt.proman.projetoStakeholder;

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
@RequestMapping(path = "/projeto_stakeholder")
@RequiredArgsConstructor

public class ProjetoStakeholderController {
    
    private final ProjetoStakeholderRepository repository;

    @GetMapping(path = "/")
    public List<ProjetoStakeholder> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProjetoStakeholderResponse> getById(@PathVariable int id){
        Optional<ProjetoStakeholder> found = repository.findById(id);
        if (found.isPresent()){
            ProjetoStakeholderResponse response = ProjetoStakeholderResponse.from(found.get());
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
    public ResponseEntity cadastrar(@RequestBody ProjetoStakeholderRequest request){
        ProjetoStakeholder projetoStakeholder = new ProjetoStakeholder();

        projetoStakeholder.setFuncaoProjetoStakeholder(request.getFuncaoProjetoStakeholder());
        projetoStakeholder.setInfluenciaProjetoStakeholder(request.getInfluenciaProjetoStakeholder());
        projetoStakeholder.setInteresseProjetoStakeholder(request.getInteresseProjetoStakeholder());

        try {
            repository.save(projetoStakeholder);

        } catch (IllegalArgumentException erro) {
            return ResponseEntity.badRequest().body("Dados invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody ProjetoStakeholderRequest request){
        ProjetoStakeholder projetoStakeholder = new ProjetoStakeholder();

        projetoStakeholder.setFuncaoProjetoStakeholder(request.getFuncaoProjetoStakeholder());
        projetoStakeholder.setInfluenciaProjetoStakeholder(request.getInfluenciaProjetoStakeholder());
        projetoStakeholder.setInteresseProjetoStakeholder(request.getInteresseProjetoStakeholder());


        try {
            repository.save(projetoStakeholder);
        } catch (IllegalArgumentException erro) {
            erro.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
