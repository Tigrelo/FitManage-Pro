package FitManage.Pro.Controller;

import FitManage.Pro.Model.Aluno;
import FitManage.Pro.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(origins = "*") // Permite que o Angular acesse a API
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return service.salvar(aluno);
    }

    @GetMapping
    public List<Aluno> listar() {
        return service.listarTodos();
    }
}