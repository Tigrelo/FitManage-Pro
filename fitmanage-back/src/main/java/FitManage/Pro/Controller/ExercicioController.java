package FitManage.Pro.Controller;

import FitManage.Pro.Model.Exercicio;
import FitManage.Pro.Repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercicios")
@CrossOrigin(origins = "*")
public class ExercicioController {

    @Autowired
    private ExercicioRepository repository;

    // --- CRIAR ---
    @PostMapping
    public Exercicio criar(@RequestBody Exercicio exercicio) {
        return repository.save(exercicio);
    }

    // --- LISTAR ---
    @GetMapping
    public List<Exercicio> listar() {
        return repository.findAll();
    }

    // --- ATUALIZAR ---
    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizar(@PathVariable Long id, @RequestBody Exercicio novosDados) {
        return repository.findById(id)
                .map(exercicio -> {
                    exercicio.setNome(novosDados.getNome());
                    exercicio.setGrupoMuscular(novosDados.getGrupoMuscular());
                    exercicio.setEquipamento(novosDados.getEquipamento());
                    exercicio.setVideoUrl(novosDados.getVideoUrl());
                    Exercicio atualizado = repository.save(exercicio);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // --- DELETAR ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return repository.findById(id)
                .map(exercicio -> {
                    repository.delete(exercicio);
                    return ResponseEntity.noContent().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}