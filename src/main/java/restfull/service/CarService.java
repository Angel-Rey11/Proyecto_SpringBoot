package restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restfull.model.Car;
import restfull.model.Client;
import restfull.repository.CarRepository;
import restfull.repository.ClientRepository;

@Service
public class CarService {
	
	@Autowired
	CarRepository repository;
	@Autowired
	ClientRepository repo;
	
	public Car addCar(Car c) {
		try {
			Optional<Car> coche = repository.findById(c.getId());
			if (!coche.isPresent()) {
				c = repository.save(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public List<Car> getAllCars() {
		return repository.findAll();
	}
	
	public Car getCarById(Long id) {
		Car car = new Car();
		try {
			Optional<Car> c = repository.findById(id);
			car = c.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}
	
	public void removeCar(Long id) {
		try {
			Optional<Car> c = repository.findById(id);
			if (c.isPresent()) {
				repository.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
