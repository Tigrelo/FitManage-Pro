package FitManage.Pro.Model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="exercicio")

public class Exercicio {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nome;
private String grupoMuscular;
private String equipamento;
private String videoUrl;

}
