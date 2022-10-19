package uz.developers.pcmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.pcmarket.entity.Category;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.CategoryDto;
import uz.developers.pcmarket.repository.CategoryRepository;
import uz.developers.pcmarket.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        return null;
    }

    @Override
    public ApiResponce addCategory(CategoryDto categoryDto) {
        Category savedCategory = new Category();
        savedCategory.setName(categoryDto.getName());

        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (optionalCategory.isEmpty()) {
                return new ApiResponce("Such category is not found", false);
            }
            savedCategory.setParentCategory(optionalCategory.get());
        }
        categoryRepository.save(savedCategory);
        return new ApiResponce("Category is saved", true);
    }

    @Override
    public ApiResponce editCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            return new ApiResponce("Such category is not found", false);
        }
        Category editedCategory = optionalCategory.get();
        editedCategory.setName(categoryDto.getName());
        editedCategory.setParentCategory(optionalCategory.get());
        categoryRepository.save(editedCategory);
        return new ApiResponce("Category is edited",true);

    }

    @Override
    public ApiResponce deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return new ApiResponce("Category is deleted",true);
    }
}
