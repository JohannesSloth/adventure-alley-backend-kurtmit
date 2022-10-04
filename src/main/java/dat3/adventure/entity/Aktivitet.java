package dat3.adventure.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aktivitet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int aktivitetsId;

}
