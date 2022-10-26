package cars.shop.repair.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarCustomerDto extends CarDto{
    private CustomerDto customer;
}
