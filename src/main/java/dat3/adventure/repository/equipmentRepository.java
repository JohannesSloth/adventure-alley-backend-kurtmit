package dat3.adventure.repository;

import dat3.adventure.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface equipmentRepository extends JpaRepository<Equipment,Integer> {
}
