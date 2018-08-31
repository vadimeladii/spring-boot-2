package md.springboot.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by veladii on 31.08.2018
 */
@Entity
@Table(
        name = "role",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"type"})
        }
)
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
}
