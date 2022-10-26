package cars.shop.repair.mapper;

import cars.shop.repair.dto.CarCustomerDto;
import cars.shop.repair.dto.CarDto;
import cars.shop.repair.entity.Car;
import cars.shop.repair.request.CarRequest;

public class CarMapper {
    public CarMapper() {}

    public static Car  car(CarRequest request){
      return   Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .plate(request.getPlate())
                .status(request.getStatus())
                .build();
    }

    public static CarDto carDTO(Car entity){
        return CarDto.builder()
                .brand(entity.getBrand())
                .model(entity.getModel())
                .plate(entity.getPlate())
                .status(entity.getStatus()).build();
    }
    public static CarCustomerDto carCustomerDto(Car entity){
        return CarCustomerDto.builder()
                .brand(entity.getBrand())
                .model(entity.getModel())
                .plate(entity.getPlate())
                .status(entity.getStatus())
                .customer(CustomerMapper.customerDto(entity.getCustomer())).build();

    }
}
