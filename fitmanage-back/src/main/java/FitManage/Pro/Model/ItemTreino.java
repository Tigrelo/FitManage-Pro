package FitManage.Pro.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "itens_treino")
public class ItemTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com a tabela de Exercícios
    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;

    // Relacionamento com a tabela de Treino
    @ManyToOne
    @JoinColumn(name = "treino_id")
    @JsonIgnore
    private Treino treino;

    private int series;
    private int repeticoes;
    private String carga;
}