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
    @SequenceGenerator(name = "id_project_task_seq", sequenceName = "pk_id_project_task", allocationSize = 0, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_project_task_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project", referencedColumnName = "id")
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_task", referencedColumnName = "id")
    private Task task;
}
