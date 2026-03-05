package FitManage.Pro.Service;

import FitManage.Pro.DTO.AlunoDTO;
import FitManage.Pro.Model.Aluno;
import FitManage.Pro.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // Altere aqui para receber o AlunoDTO
    public Aluno atualizar(Long id, AlunoDTO dto) {
        return repository.findById(id)
                .map(aluno -> {
                    aluno.setNome(dto.getNome());
                    aluno.setEmail(dto.getEmail());
                    aluno.setCpf(dto.getCpf());

                    return repository.save(aluno);
                }).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}