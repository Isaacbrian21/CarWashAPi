package cars.shop.repair.mapper;

import cars.shop.repair.dto.CustomerCarDto;
import cars.shop.repair.dto.CustomerDto;
import cars.shop.repair.entity.Customer;
import cars.shop.repair.request.CustomerRequest;

import java.util.stream.Collectors;

public class CustomerMapper {
    public CustomerMapper(){}
    public static Customer customer(CustomerRequest request){
        return Customer.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .build();
    }
    public static CustomerDto customerDto(Customer customer){
        return CustomerDto.builder()
                .name(customer.getName())
                .cpf(customer.getCpf())
                .build();
    }

    public static CustomerCarDto customerCarDto(Customer customer){
        return CustomerCarDto.builder()
                .name(customer.getName())
                .cpf(customer.getCpf())
                .cars((customer.getCars().stream()
                        .map(CarMapper::carDTO))
                        .collect(Collectors.toList()))
                .build();
    }
}
