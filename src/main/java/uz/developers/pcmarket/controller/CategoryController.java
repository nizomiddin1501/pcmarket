package uz.developers.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.pcmarket.entity.Category;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.CategoryDto;
import uz.developers.pcmarket.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categories);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addCategory(@RequestBody CategoryDto categoryDto) {
        ApiResponce apiResponce = categoryService.addCategory(categoryDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        ApiResponce apiResponce = categoryService.editCategory(id,categoryDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        ApiResponce apiResponce = categoryService.deleteCategory(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
