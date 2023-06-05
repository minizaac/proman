package br.ufmt.proman.stakeholder;

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
@RequestMapping(path = "/stakeholder")
@RequiredArgsConstructor

public class StakeholderController {

    private final StakeholderRepository repository;

    @GetMapping(path = "/")
    public List<Stakeholder> index() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StakeholderResponse> getById(@PathVariable int id) {
        Optional<Stakeholder> found = repository.findById(id);
        if (found.isPresent()){
            StakeholderResponse response = StakeholderResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{pk}")
    public ResponseEntity<Void> remover(@PathVariable (name = "pk") int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity cadastrar(@RequestBody StakeholderRequest request){
        Stakeholder stakeholder = new Stakeholder();

        stakeholder.setNomeStakeholder(request.getNomeStakeholder());   

        try {
            repository.save(stakeholder);

        } catch (IllegalArgumentException erro) {
            return ResponseEntity.badRequest().body("Dados invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody StakeholderRequest request){
        Stakeholder stakeholder = new Stakeholder();

        stakeholder.setIdStakeholder(id);
        stakeholder.setNomeStakeholder(request.getNomeStakeholder());
        
        try {
            repository.save(stakeholder);
        } catch (IllegalArgumentException erro) {
            erro.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
