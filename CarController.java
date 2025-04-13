package com.example.carrentalproject.controller;

import com.example.carrentalproject.domain.Car;
import com.example.carrentalproject.domain.CarPackage;
import com.example.carrentalproject.domain.CarParameters;
import com.example.carrentalproject.dto.CarDto;
import com.example.carrentalproject.dto.CarPackageDto;
import com.example.carrentalproject.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor  // ✅ Automatically injects CarService
public class CarController {

    private final CarService carService;  // ✅ No need for manual instantiation

    @GetMapping("/cars")
    public List<Car> getAllCars(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        return carService.getAllCars(page, sort);
    }

    @GetMapping("/cars/packages")
    public List<CarPackage> getCarPackages() {
        return carService.getCarPackages();
    }

    @GetMapping("/cars/available")
    public List<Car> getAvailableCars(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        return carService.getAvailableCars(page, sort);
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PostMapping("/cars")
    public Car saveCar(@RequestBody CarDto carDto) {
        return carService.saveCar(carDto);
    }

    @PutMapping("/cars/{id}")
    public Car editCar(@PathVariable Long id, @RequestBody CarDto carDto) {
        return carService.editCar(id, carDto);
    }

    @PutMapping("/cars/{id}/parameters")
    public Car setCarParameters(@PathVariable Long id, @RequestBody CarParameters carParameters) {
        return carService.setCarParameters(id, carParameters);
    }

    @PutMapping("/cars/{id}/packages")
    public Car setCarPackage(@PathVariable Long id, @RequestParam String packageName) {
        return carService.setCarPackage(id, packageName);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PostMapping("/cars/packages")
    public CarPackage saveCarPackage(@RequestBody CarPackageDto carPackageDto) {
        return carService.saveCarPackage(carPackageDto);
    }

    @DeleteMapping("/cars/packages/{id}")
    public void deleteCarPackage(@PathVariable Long id) {
        carService.deleteCarPackage(id);
    }
}
