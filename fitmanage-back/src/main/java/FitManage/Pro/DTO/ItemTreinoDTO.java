package FitManage.Pro.DTO;

import lombok.Data;

@Data
public class ItemTreinoDTO {
    private Long exercicioId;
    private int series;
    private int repeticoes;
    private String carga;
}