package uz.developers.pcmarket.service;

import uz.developers.pcmarket.entity.Category;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategory(Integer id);

    ApiResponce addCategory(CategoryDto categoryDto);

    ApiResponce editCategory(Integer id, CategoryDto categoryDto);

    ApiResponce deleteCategory(Integer id);
}
