package uz.developers.pcmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.pcmarket.entity.Category;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.CategoryDto;
import uz.developers.pcmarket.repository.CategoryRepository;
import uz.developers.pcmarket.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public Category getCategory(Integer id) {
        return null;
    }

    @Override
    public ApiResponce addCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ApiResponce editCategory(Integer id, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ApiResponce deleteCategory(Integer id) {
        return null;
    }
}
