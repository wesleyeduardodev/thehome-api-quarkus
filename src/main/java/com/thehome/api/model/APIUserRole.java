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
@Table(name = "api_user_role")
public class APIUserRole extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "api_user_role_id_seq", sequenceName = "pk_api_user_role_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "api_user_role_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "api_user_id", referencedColumnName = "id", nullable = false)
    private APIUser apiUser;

    @Column(name = "role", nullable = false)
    private String role;
}
