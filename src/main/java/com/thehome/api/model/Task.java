package com.thehome.api.model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task")
public class Task extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "task_id_seq", sequenceName = "pk_task_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectTask> projectTasks;
}
