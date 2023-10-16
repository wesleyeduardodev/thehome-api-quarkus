package com.thehome.api.model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project_budget")
public class ProjectBudget extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "id_project_budget_seq", sequenceName = "pk_id_project_budget", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_project_budget_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_project", referencedColumnName = "id", nullable = false)
    private Project project;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "number_installments")
    private Integer numberInstallments;

    @OneToMany(mappedBy = "projectBudget", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payments;
}
