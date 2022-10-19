package uz.developers.pcmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.pcmarket.entity.Product;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.payload.ProductDto;
import uz.developers.pcmarket.repository.ProductRepository;
import uz.developers.pcmarket.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(Integer id) {
        return null;
    }

    @Override
    public ApiResponce addProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ApiResponce editProduct(Integer id, ProductDto productDto) {
        return null;
    }

    @Override
    public ApiResponce deleteProduct(Integer id) {
        return null;
    }
}
