package FitManage.Pro.Service;

import FitManage.Pro.Model.Aluno;
import FitManage.Pro.DTO.AlunoDTO;
import FitManage.Pro.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    // Salvar um novo aluno (recebendo a Entity do Controller)
    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    // Listar todos os alunos para a tabela do Angular
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // Buscar um aluno por ID (útil para edição)
    public Aluno buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    // Atualizar os dados usando o DTO que criamos
    public Aluno atualizar(Long id, AlunoDTO dto) {
        Aluno alunoExistente = buscarPorId(id);

        alunoExistente.setNome(dto.getNome());
        alunoExistente.setEmail(dto.getEmail());
        alunoExistente.setCpf(dto.getCpf());
        alunoExistente.setTelefone(dto.getTelefone());
        alunoExistente.setDataNascimento(dto.getDataNascimento());

        return repository.save(alunoExistente);
    }

    // Excluir aluno
    public void excluir(Long id) {
        Aluno aluno = buscarPorId(id);
        repository.delete(aluno);
    }
}