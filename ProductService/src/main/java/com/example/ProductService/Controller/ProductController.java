package com.example.ProductService.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductService.Entity.Product;
import com.example.ProductService.Repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Value("${server.port}")
    private String port;
	
	@GetMapping
    public String getProduct() {
        return "Response from Product Service, Port: " + port ;
    }
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		Product saveProduct=productRepository.save(product);
		return new ResponseEntity<>(saveProduct,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
	      Optional<Product> byId = productRepository.findById(id);
	      
	      return byId.get();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);

		return "Product is deleted from sourrce," + id;

	}
	
}
