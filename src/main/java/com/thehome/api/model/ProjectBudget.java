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
    @SequenceGenerator(name = "project_budget_id_seq", sequenceName = "pk_project_budget_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_budget_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    private Project project;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "number_installments")
    private Integer numberInstallments;

    @Transient
    @OneToMany(mappedBy = "projectBudget", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payments;
}
