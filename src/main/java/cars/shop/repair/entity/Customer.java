package cars.shop.repair.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private String name;
    private String cpf;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private final List<Car> cars = new ArrayList<Car>();
}
