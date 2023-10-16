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
    @SequenceGenerator(name = "id_client_seq", sequenceName = "pk_id_client", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_client_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "date_register")
    private LocalDateTime dateRegister;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;
}
