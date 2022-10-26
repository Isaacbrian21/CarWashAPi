package cars.shop.repair.controller;

import cars.shop.repair.dto.CarDto;
import cars.shop.repair.entity.Car;
import cars.shop.repair.request.CarRequest;
import cars.shop.repair.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService service;

    @GetMapping
    public List<CarDto> getCars(){
        return service.CarList();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable("id") UUID id){
        return service.findById(id);
    }

    @PostMapping()
    public Car addCar(@RequestBody @Validated CarRequest request){
        return service.addCar(request);
    }

    @PutMapping("/{id}")
    public Car updateCar(@RequestBody CarRequest request, @PathVariable("id") UUID id){
        return service.updateCarsInfo(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(UUID id){
        service.delete(id);
    }
}
