package com.example.Userbooking.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Userbooking.model.bookingorder;
import com.example.Userbooking.repository.Userbookingrepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/book")
public class Userbookingcontroller {
	
	@Autowired 
	private Userbookingrepository Userbookingrepository;
	
	@PostMapping("/orders/addorder")
	public String saveBook(@RequestBody bookingorder book) {
		Userbookingrepository.save(book);
		return null;
	    }

	@GetMapping("/")
	public String Check(){
		return("checked");
	}
	@GetMapping("/orders")
	public List<bookingorder> getAllTrains(){
		return Userbookingrepository.findAll();
	}
	@GetMapping("/orders/{_id}")
	public Optional<bookingorder> getBook(@PathVariable String _id){
		return Userbookingrepository.findById(_id);
	}
	@PutMapping("/orders/update/{_id}")
	public bookingorder updateOrder(@PathVariable("_id") String _id,@RequestBody bookingorder order ) {
		
		Userbookingrepository.save(order);
		return order;
	}
	@DeleteMapping("/orders/delete/{_id}")
	 public String deleteOrder (@PathVariable String _id) {
	  Userbookingrepository.deleteById(_id);
		return null;
		}
}
