package restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restfull.model.Car;
import restfull.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	CarService service;
	
	@GetMapping
	public ResponseEntity<List<Car>> getAllCars() {
		List<Car> result = service.getAllCars();
		return new ResponseEntity<List<Car>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> getItemById(@PathVariable("id") Long id) {
		Car c = service.getCarById(id);
		return new ResponseEntity<Car>(c, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Car> createOrUpdate(@RequestBody Car c) {
		Car coche = service.createOrUpdateClient(c);
		return new ResponseEntity<Car>(coche, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteCar(@PathVariable("id") Long id) {
		service.removeCar(id);
		return HttpStatus.OK;
	}
	
}
