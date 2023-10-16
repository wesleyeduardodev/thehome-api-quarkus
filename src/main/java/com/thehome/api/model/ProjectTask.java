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
@Table(name = "project_task")
public class ProjectTask extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "id_project_task_seq", sequenceName = "pk_id_project_task", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_project_task_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_project", referencedColumnName = "id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "id_task", referencedColumnName = "id", nullable = false)
    private Task task;
}
