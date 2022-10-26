package cars.shop.repair.service;

import cars.shop.repair.dto.CarDto;
import cars.shop.repair.dto.CustomerDto;
import cars.shop.repair.entity.Customer;
import cars.shop.repair.mapper.CarMapper;
import cars.shop.repair.mapper.CustomerMapper;
import cars.shop.repair.repository.CarRepository;
import cars.shop.repair.repository.CustomerRepository;
import cars.shop.repair.request.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CarRepository carRepository;

    public List<CustomerDto> CustomerList(){
        return repository.findAll().stream()
                .map(CustomerMapper::customerCarDto)
                .collect(Collectors.toList());
    }

    public Customer findById(UUID id){
        Optional<Customer> customer = repository.findById(id);
        if (customer.isPresent()){
           return customer.get();
        }else {
            return null;
        }
    }
    public Customer addCustomer(CustomerRequest request){
        return repository.save(CustomerMapper.customer(request));
    }

    public Customer updateCustomersInfo(CustomerRequest request, UUID id){
        Optional<Customer> customer = repository.findById(id);

        if (customer.isPresent()){
            customer.get().setName(request.getName());
            customer.get().setCpf(request.getCpf());
            return repository.save(customer.get());
        }else {
            return  null;
        }
    }
    public void delete(UUID id){
        Optional<Customer> customer = repository.findById(id);
        if (customer.isPresent()){
            customer.get();
        }
    }

}
