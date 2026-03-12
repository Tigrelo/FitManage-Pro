package FitManage.Pro.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TreinoDTO {
    private String nome;
    private String objetivo;
    private Long alunoId;
    private LocalDate dataVencimento;
    private List<ItemTreinoDTO> itens;
}