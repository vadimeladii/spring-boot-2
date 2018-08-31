package md.springboot.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;

/**
 * Created by veladii on 31.08.2018
 */
@Entity
@Table(
        name = "`user`",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"})
        }
)
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {MERGE, REMOVE, REFRESH, DETACH})
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_role")})
    private Set<RoleEntity> roles = new HashSet<>();
}
