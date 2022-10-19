package uz.developers.pcmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.pcmarket.entity.Attachment;
import uz.developers.pcmarket.entity.Category;
import uz.developers.pcmarket.entity.Product;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.ProductDto;
import uz.developers.pcmarket.repository.AttachmentRepository;
import uz.developers.pcmarket.repository.CategoryRepository;
import uz.developers.pcmarket.repository.ProductRepository;
import uz.developers.pcmarket.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;


    @Override
    public List<Product> getProducts() {
       return productRepository.findAll();
    }

    @Override
    public Product getProduct(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    @Override
    public ApiResponce addProduct(ProductDto productDto) {
        boolean exists = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (exists) {
            return new ApiResponce("There is such product in this category", false);
        }

        //categoryni tekshirish
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ApiResponce("There is not such category", false);
        }

        //photoni tekshirish
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (optionalAttachment.isEmpty()) {
            return new ApiResponce("There is not such photo", false);
        }

        boolean existsByCode = productRepository.existsByCode(productDto.getCode());
        if (existsByCode) {
            return new ApiResponce("Such code ever been exist", false);
        }

        // saqlash

        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode(productDto.getCode());
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());

        productRepository.save(product);
        return new ApiResponce("Product is saved", true);

    }

    @Override
    public ApiResponce editProduct(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return new ApiResponce("Such product is not found", false);
        }

        boolean existsByCode = productRepository.existsByCode(productDto.getCode());
        if (existsByCode) {
            return new ApiResponce("Product is already exist", false);
        }

        Product editedProduct = optionalProduct.get();
        editedProduct.setName(productDto.getName());
        editedProduct.setCode(productDto.getCode());

        productRepository.save(editedProduct);
        return new ApiResponce("Product is edited",true);


    }

    @Override
    public ApiResponce deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return new ApiResponce("Product is deleted",true);
    }
}
