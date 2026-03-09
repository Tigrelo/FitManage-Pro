package FitManage.Pro.Model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "Treinos")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String objetivo;
    private LocalDate dataCriacao = LocalDate.now();
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL)
    private List<ItemTreino> itens;
}
