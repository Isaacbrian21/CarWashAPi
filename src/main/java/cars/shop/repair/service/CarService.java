package cars.shop.repair.service;

import cars.shop.repair.dto.CarDto;
import cars.shop.repair.entity.Car;
import cars.shop.repair.entity.Customer;
import cars.shop.repair.mapper.CarMapper;
import cars.shop.repair.repository.CarRepository;
import cars.shop.repair.repository.CustomerRepository;
import cars.shop.repair.request.CarRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    public List<CarDto> CarList(){
        return carRepository.findAll().stream()
                .map(CarMapper::carCustomerDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Car addCar(CarRequest request){
        Customer customer = customerRepository.findByCpf(request.getCustomerCpf());
        Car car = carRepository.save(CarMapper.car(request));
        car.addCustomer(customer);

        return CarMapper.car(request);
    }

    public Car findById(UUID id){
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()){
            car.get();
        }
        return car.get();
    }

    @Transactional
    public Car updateCarsInfo(CarRequest request, UUID id){
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()){
        }
            car.get().setBrand(request.getBrand());
            car.get().setModel(request.getModel());
            car.get().setPlate(request.getPlate());
            car.get().setStatus(request.getStatus());
        return carRepository.save(car.get());
    }
    public void delete(UUID id){
        Optional<Car> car = carRepository.findById(id);

        if (car.isPresent()){
            carRepository.delete(car.get());
        }
    }
}
