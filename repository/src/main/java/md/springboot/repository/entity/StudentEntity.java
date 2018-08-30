package md.springboot.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by veladii on 30.08.2018
 */
@Getter
@Setter
@Entity
@Table(name = "student")
@NoArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;
}
