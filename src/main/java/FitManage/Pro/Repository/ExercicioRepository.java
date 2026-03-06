package FitManage.Pro.Repository;

import FitManage.Pro.Model.Exercicio;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    }

