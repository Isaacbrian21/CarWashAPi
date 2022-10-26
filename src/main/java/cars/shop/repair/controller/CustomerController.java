package cars.shop.repair.controller;

import cars.shop.repair.dto.CustomerDto;
import cars.shop.repair.entity.Customer;
import cars.shop.repair.request.CarRequest;
import cars.shop.repair.request.CustomerRequest;
import cars.shop.repair.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    @GetMapping()
    public List<CustomerDto> getCustomer(){
        return service.CustomerList();
    }
    @GetMapping("/{id}")
    public Customer getById(@PathVariable("id") UUID id){
        return service.findById(id);
    }
    @PostMapping()
    public Customer add(@RequestBody @Validated CustomerRequest request){
        return service.addCustomer(request);
    }
    @PutMapping("/{id}")
    public Customer update(@RequestBody CustomerRequest request, @PathVariable("id") UUID id) {
        return service.updateCustomersInfo(request, id);
    }
    @DeleteMapping("/{id}")
    public void delete(UUID id){
        service.delete(id);
    }
}
