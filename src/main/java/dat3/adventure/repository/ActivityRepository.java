package dat3.adventure.repository;

import dat3.adventure.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ActivityRepository extends JpaRepository<Activity,String> {
}
