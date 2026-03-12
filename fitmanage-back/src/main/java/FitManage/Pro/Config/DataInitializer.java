package FitManage.Pro.Config;

import FitManage.Pro.Model.Exercicio;
import FitManage.Pro.Repository.ExercicioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ExercicioRepository repository) {
        return args -> {
            if (repository.count() == 0) { // Só cadastra se o banco estiver vazio
                Exercicio ex1 = new Exercicio();
                ex1.setNome("Supino Reto");
                ex1.setGrupoMuscular("Peito");
                ex1.setEquipamento("Barra");
                ex1.setVideoUrl("https://wger.de/media/exercise-images/192/Bench-press-1.png");

                repository.save(ex1);
                System.out.println("Banco de Exercícios populado com dados da Wger!");
            }
        };
    }
}