package cars.shop.repair.request;

import cars.shop.repair.entity.Status;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {

    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String plate;
    @NotNull
    private Status status;
    @NotNull
    private String customerCpf;
}
