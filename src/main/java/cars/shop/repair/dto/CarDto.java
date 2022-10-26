package cars.shop.repair.dto;

import cars.shop.repair.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Data
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private UUID id;
    private String brand;
    private String model;
    private String plate;
    private Status status;
}
