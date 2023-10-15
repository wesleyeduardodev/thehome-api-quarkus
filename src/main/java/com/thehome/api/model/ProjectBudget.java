package com.thehome.api.model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project_budget")
public class ProjectBudget extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "id_project_budget_seq", sequenceName = "pk_id_project_budget", allocationSize = 0, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_project_budget_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project", referencedColumnName = "id")
    private Project project;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Enumerated
    @Column(name = "payment_type")
    private PaymentType paymentType;
}
