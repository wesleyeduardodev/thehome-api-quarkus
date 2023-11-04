package com.thehome.api.model;
import com.thehome.api.model.enums.ProjectStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
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
    @SequenceGenerator(name = "project_id_seq", sequenceName = "pk_project_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Enumerated
    @Column(name = "status", nullable = false)
    private ProjectStatus status;

    @Transient
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectBudget> projectBudgets;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated at")
    private LocalDateTime updatedAt;

    @Transient
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectTask> tasks;
}
