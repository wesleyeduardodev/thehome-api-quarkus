package com.thehome.api.model;
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
@Table(name = "api_user")
public class APIUser extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "api_user_id_seq", sequenceName = "pk_api_user_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "api_user_id_seq")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated at")
    private LocalDateTime updatedAt;

    @Transient
    @OneToMany(mappedBy = "apiUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<APIUserRole> userRoles;
}
