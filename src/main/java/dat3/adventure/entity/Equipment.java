package dat3.adventure.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Equipment {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int equipmentId;

  @Column(length= 50, nullable = false)
  String equipmentName;

  @ManyToOne
  Activity activity;

}
