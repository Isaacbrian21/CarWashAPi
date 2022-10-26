package cars.shop.repair.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCarDto extends CustomerDto {
    private List<CarDto> cars;
}
