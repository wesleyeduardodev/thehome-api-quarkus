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
@Table(name = "project")
public class Project extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "id_project_seq", sequenceName = "pk_id_project", allocationSize = 0, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_project_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;

    @Transient
    @OneToMany(mappedBy = "project")
    private List<ProjectBudget> projectBudgets;

    @Transient
    @OneToMany(mappedBy = "project")
    private List<ProjectTask> tasks;
}
