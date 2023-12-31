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
@Table(name = "client")
public class Client extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "client_id_seq", sequenceName = "pk_client_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated at")
    private LocalDateTime updatedAt;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Transient
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;
}
