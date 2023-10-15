package com.thehome.api.model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task")
public class Task extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "id_task_seq", sequenceName = "pk_id_task", allocationSize = 0, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_task_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
