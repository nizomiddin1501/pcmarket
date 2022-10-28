package uz.developers.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.pcmarket.entity.Product;
import uz.developers.pcmarket.entity.User;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.ProductDto;
import uz.developers.pcmarket.payload.UserDto;
import uz.developers.pcmarket.service.ProductService;
import uz.developers.pcmarket.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(products);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addProduct(@RequestBody ProductDto productDto) {
        ApiResponce apiResponce = productService.addProduct(productDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        ApiResponce apiResponce = productService.editProduct(id,productDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        ApiResponce apiResponce = productService.deleteProduct(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
