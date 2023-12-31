package com.thehome.api.model;
import com.thehome.api.model.enums.PaymentType;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "payment_id_seq", sequenceName = "pk_payment_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_budget_id", referencedColumnName = "id", nullable = false)
    private ProjectBudget projectBudget;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Enumerated
    @Column(name = "payment_type")
    private PaymentType paymentType;
}
