package FitManage.Pro.Service;

import FitManage.Pro.Model.*;
import FitManage.Pro.Repository.*;
import FitManage.Pro.DTO.TreinoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Transactional // Garante que se um item falhar, nada será salvo (Atomicidade)
    public Treino salvar(TreinoDTO dto) {
        Treino treino = new Treino();
        treino.setNome(dto.getNome());
        treino.setObjetivo(dto.getObjetivo());
        treino.setDataVencimento(dto.getDataVencimento());

        // 1. Busca o Aluno dono do treino
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        treino.setAluno(aluno);

        // 2. Mapeia os itens que vieram do DTO para a Entity ItemTreino
        List<ItemTreino> itens = dto.getItens().stream().map(itemDto -> {
            ItemTreino item = new ItemTreino();

            // Busca o exercício pelo ID que veio no JSON
            Exercicio ex = exercicioRepository.findById(itemDto.getExercicioId())
                    .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));

            item.setExercicio(ex);
            item.setSeries(itemDto.getSeries());
            item.setRepeticoes(itemDto.getRepeticoes());
            item.setCarga(itemDto.getCarga());
            item.setTreino(treino); // Vincula o item ao treino pai
            return item;
        }).collect(Collectors.toList());

        treino.setItens(itens);
        return treinoRepository.save(treino);
    }

    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }
}