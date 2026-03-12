package FitManage.Pro.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoDTO {
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
}