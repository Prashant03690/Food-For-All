package com.backend.foodforall.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.Foodproduct;
import com.backend.foodforall.repository.FoodproductRepository;
import com.backend.foodforall.service.FoodproductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FoodproductController {

	@Autowired
	FoodproductService foodproductService;
	
	@Autowired
	FoodproductRepository foodproductRepository;
	
	@GetMapping("/getAllFoodproduct")
	public List<Foodproduct> getAllFoodproduct()
	{
		return foodproductService.getAllFoodproduct();
	}
	
	@PostMapping("/postFoodproduct")
	public Foodproduct postFP(@RequestBody Foodproduct fp)
	{
		return foodproductService.postFP(fp);
	}
	
	@GetMapping("/getFoodproduct/{fpid}")
	public Foodproduct getFoodProduct(@PathVariable("fpid") int fpid)
	{
		return foodproductService.getFoodproduct(fpid);
				
	}
	
	@PutMapping("/updateFoodproduct/{fpid}")
	public Foodproduct updateFoodproduct(@RequestBody Foodproduct newfp, @PathVariable int fpid)
	{
		return foodproductRepository.findById(fpid)
				.map(Foodproduct -> {
					Foodproduct.setFpname(newfp.getFpname());
					Foodproduct.setFpprice(newfp.getFpprice());
					Foodproduct.setFpqty(newfp.getFpqty());
					return foodproductRepository.save(newfp);
					}).orElseThrow(null);
	}
	
	@DeleteMapping("deleteFoodproduct/{fpid}")
	public String deleteFoodproduct(@PathVariable int fpid)
	{
	    foodproductService.deleteFoodproduct(fpid);
	    return "Food Product Deleted";
	}
	
	@GetMapping("/getFoodproductByCompany/{coid}")
	public List<Foodproduct> getByCompany(@PathVariable("coid") int coid)
	{
		return foodproductService.getByCompany(coid);
	}

}
