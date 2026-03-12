package FitManage.Pro.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataMatricula = LocalDate.now();
    private String status = "ATIVO";
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
}